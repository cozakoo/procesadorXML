package xml;

import Interfaz.IConsultaSql;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import main.DataBase;
import presentacion.presentacion_B.AgentesRetencionType;
import presentacion.presentacion_B.presentacionTypeSeccionB;
import util.XmlUtils;
import static util.XmlUtils.convertirAStringToFecha;
import static util.XmlUtils.esPresentCargadaPosteriorPresentVigente;
import static util.XmlUtils.obtenerDni;
import static util.XmlUtils.obtenerFechaActual;
import static xml.XMLSeccion.obtenerUltimaPresentacionVigente;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSeccionB extends XMLSeccion {

    private static final String FORMATO_ARCHIVO_REGEX = "^\\d{" + LONGITUD_CUIT + "}_\\d{" + LONGITUD_PERIODO + "}" + NOMBRE_PREDEFINIDO + "\\d{" + LONGITUD_NUM_ENVIO + "}_b\\.xml$";

    @XmlElement(name = "presentacion")
    private presentacionTypeSeccionB presentacion;

    public XMLSeccionB(File selectedFile) throws JAXBException {
//        if(!esNombreValido(selectedFile.getName())){
//            throw new IllegalArgumentException("El nombre del archivo no es válido.");
//        }
        super(selectedFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(presentacionTypeSeccionB.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.presentacion = (presentacionTypeSeccionB) unmarshaller.unmarshal(selectedFile);
    }

    public static boolean esNombreValido(String nombre) {
        Pattern pattern = Pattern.compile(FORMATO_ARCHIVO_REGEX);
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }

    @Override
    public String toString() {

        return presentacion.toString();

    }

    private BigDecimal getDniPresentacion() {
        String docString = obtenerDni(presentacion.getEmpleado().getCuit());
        return new BigDecimal(docString);
    }


    public boolean existeAgente(DataBase db) throws SQLException {
        ResultSet rs = obtenerUltimaPresentacionVigente(db, this.getDniPresentacion());
        if (!rs.next()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean esPresentacionActualizable(DataBase db) throws SQLException {
        ResultSet rs = obtenerUltimaPresentacionVigente(db, this.getDniPresentacion());
        rs.next();

        int excep = rs.getInt("excep");
        int nroPresenVigente = rs.getInt("nropres");
        int periodoPresenVigente = rs.getInt("periodo");
        System.out.println("DATOS OBTENIDOS exep, nropres, periodo "
                + excep + "," + nroPresenVigente + "," + periodoPresenVigente);

        //datos presentacion carrgada
        int nroPresenCargada = this.presentacion.getNroPresentacion();
        int periodoPresenCargada = this.presentacion.getPeriodo();
        if (esPresentCargadaPosteriorPresentVigente(periodoPresenVigente,
                nroPresenVigente,
                periodoPresenCargada,
                nroPresenCargada)) {
            String cuitRet = this.presentacion.getAgenteRetencion().getCuit();
            return  !EsliqPorMinistEconomia(db, cuitRet);
             
        }
        return false;

    }

    private void actualizarNuevosDatosAgente(DataBase db) throws SQLException, ParseException {
        String sql = "UPDATE agentes SET fechaf572 = ?, fechapres = ?, fechaweb = ?, web = ?, "
                + "wapellido = ?, wnombre = ?, wcp = ?, wlocalidad = ?, wcalle = ?, "
                + "wnro = ?, wpiso = ?, wdpto = ?, wcuit = ?, excep = 1, nropres = ?, "
                + "periodo = ?, wcuitreten = ?, wdescreten = ? WHERE documento = ?";

        // Crear un PreparedStatement para la actualización
        PreparedStatement pstmt = db.getConection().prepareStatement(sql);
        Date fechaPres = convertirAStringToFecha(this.presentacion.getFechaPresentacion());
        // Establecer los valores para los parámetros
        int i = 0;
        pstmt.setDate(++i, obtenerFechaActual());  // Nuevo nombre
        pstmt.setDate(++i, fechaPres);      // Nuevo salario
        pstmt.setDate(++i, obtenerFechaActual());    // Nuevo departamento
        pstmt.setInt(++i, 1);
        pstmt.setString(++i, this.presentacion.getEmpleado().getApellido());// ID del empleado a actualizar
        pstmt.setString(++i, this.presentacion.getEmpleado().getNombre());
        pstmt.setString(++i, this.presentacion.getEmpleado().getDireccion().getCp());
        pstmt.setString(++i, this.presentacion.getEmpleado().getDireccion().getLocalidad());
        pstmt.setString(++i, this.presentacion.getEmpleado().getDireccion().getCalle());
        pstmt.setString(++i, this.presentacion.getEmpleado().getDireccion().getNro());
        pstmt.setString(++i, this.presentacion.getEmpleado().getDireccion().getPiso());
        pstmt.setString(++i, this.presentacion.getEmpleado().getDireccion().getDtp());
        pstmt.setString(++i, this.presentacion.getEmpleado().getCuit());
        pstmt.setInt(++i, this.presentacion.getNroPresentacion());
        pstmt.setInt(++i, this.presentacion.getPeriodo());
        BigDecimal wcuitreten = new BigDecimal(this.presentacion.getAgenteRetencion().getCuit());
        pstmt.setBigDecimal(++i, wcuitreten);
        pstmt.setString(++i, this.presentacion.getAgenteRetencion().getDenominacion());

        pstmt.setBigDecimal(++i, getDniPresentacion());

        // Ejecutar la actualización
        int filasActualizadas = pstmt.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("El empleado ha sido actualizado exitosamente. tuplas actualizadas: " + filasActualizadas);
        } else {
            System.out.println("No se encontró el empleado con el id 5.");
        }

    }

    public boolean EsliqPorMinistEconomia(DataBase db, String cuit) throws SQLException {
        String sql = IConsultaSql.consulta_esLiqPorMinstEconomia;
        PreparedStatement pstmt = db.getConection().prepareStatement(sql);
        String cuitEmpRet = util.XmlUtils.obtenerCuitConGuion(cuit);
        int i = 0;
        pstmt.setString(++i, cuitEmpRet);

        ResultSet result = pstmt.executeQuery();
        
        if (result.next()) {
            
            System.out.println("ES LIQUIDADO POR EL MINISTERIO CUIT: " +this.presentacion.getAgenteRetencion().getCuit() );
            return true;
        }
        
        return false;
    }

    @Override
    public void insertarEnBD(DataBase db) {
        Connection conexion = db.getConection();
        try {
            conexion.setAutoCommit(false);
            limpiarDatosAnteriores(this.getDniPresentacion(), db);
            actualizarNuevosDatosAgente(db);
            conexion.commit();
        } catch (SQLException e) {
            try {
                // Hacer rollback si hay un error
                conexion.rollback();
                System.out.println("SE REALIZO UN ROLLBACK");
            } catch (SQLException ex) {
                Logger.getLogger(XMLSeccionA.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(XMLSeccionB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
