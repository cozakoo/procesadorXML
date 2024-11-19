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
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import main.DataBase;
import main.DataBasePostGre;
import presentacion.presentacion_A.arrayType.ArrayIngresosAporteType;
import presentacion.presentacion_A.type.CargaFamilia;
import presentacion.presentacion_A.type.ConceptoType;
import presentacion.presentacion_A.type.DetalleType;
import presentacion.presentacion_A.type.EmpleadorEntidadType;
import presentacion.presentacion_A.type.presentacionTypeSeccionA;
import presentacion.presentacion_A.type.PeriodoType;
import presentacion.presentacion_A.type.ingresoAporteType;
import util.NotaList;
import util.XmlUtils;
import static util.XmlUtils.ExisteEtiqueta;
import static util.XmlUtils.StringADate;
import static util.XmlUtils.convertirAStringToFecha;
import static util.XmlUtils.esPresentCargadaPosteriorPresentVigente;
import static util.XmlUtils.isMesInicioEqualSMesFIN;
import static util.XmlUtils.obtenerCodEmpresa;
import static util.XmlUtils.obtenerNombreYApellido;
import static util.XmlUtils.obtenerCodParentesto;
import static util.XmlUtils.obtenerConceptoDeduccAdmitida;
import static util.XmlUtils.obtenerDni;
import static util.XmlUtils.obtenerFechaActual;
import static util.XmlUtils.obtenerMesActual;
import static util.XmlUtils.obtenerUltimaPresentacionVigente;

@XmlRootElement(name = "presentacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSeccionA extends XMLSeccion {

    @XmlElement(name = "presentacion")
    private presentacionTypeSeccionA presentacion;

    public XMLSeccionA(File selectedFile) throws JAXBException {
        super(selectedFile); // Llama al constructor de la clase base para validar y extraer el periodo
        JAXBContext jaxbContext = JAXBContext.newInstance(presentacionTypeSeccionA.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        this.presentacion = (presentacionTypeSeccionA) unmarshaller.unmarshal(selectedFile);
    }

    @Override
    public String toString() {
        return presentacion.toString();
    }

    private void insertCargFamilia(List<CargaFamilia> familiares, DataBase db) throws SQLException, Exception {
        String sql = IConsultaSql.consulta_familiar_insert;
        PreparedStatement pstmt = db.getPreparedStatement(sql);

        for (CargaFamilia familiar : familiares) {

            BigDecimal nroDoc = this.getDniPresentacion();
            BigDecimal nroDniFamiliar = new BigDecimal(obtenerDni(familiar.getNroDoc()));

            int parentescod = obtenerCodParentesto(familiar.getParentesco());

            //armando consulta 
            pstmt.setBigDecimal(1, nroDoc);
            pstmt.setInt(2, parentescod);
            pstmt.setBigDecimal(3, nroDniFamiliar);
            pstmt.setString(4, obtenerNombreYApellido(familiar.getNombre(), familiar.getApellido()));
            pstmt.setDate(5, obtenerFechaActual());
            pstmt.setNull(6, java.sql.Types.DATE);
            pstmt.setInt(7, 1);
            pstmt.setNull(8, java.sql.Types.INTEGER);
            pstmt.setInt(9, 1);
            pstmt.setInt(10, 1);
            pstmt.setInt(11, familiar.getMesDesde());
            pstmt.setInt(12, familiar.getMesHasta());
            pstmt.setDate(13, StringADate(familiar.getFechaNac()));
            pstmt.setInt(14, familiar.getPorcentajeDeduccion());
            pstmt.addBatch();
            //imprimir consulta
            System.out.println("carga familia: " + pstmt.toString());

        }
        pstmt.executeBatch();

        System.out.println("Inserciones de familiares completadas.");

    }

    private void insertGanLiqOTrosEmpEnt(List<EmpleadorEntidadType> empleadores, DataBase db) throws SQLException {
        String sql = IConsultaSql.consulta_ganliqOtrosEmpl_insert;
        PreparedStatement pstmt = db.getPreparedStatement(sql);
        for (EmpleadorEntidadType empleador : empleadores) {
            int codEmp = obtenerCodEmpresa(empleador.getCuit(), db);
            List<ingresoAporteType> ingApList = empleador.getIngresosAportes().getIngAp();
            for (ingresoAporteType ingAp : ingApList) {
                armarCuerpoGanLiqOTrosEmpEnt(codEmp, ingAp, pstmt);
            }
            pstmt.executeBatch();
        }
    }

    private BigDecimal getDniPresentacion() {
        String docString = obtenerDni(presentacion.getEmpleado().getCuit());
        return new BigDecimal(docString);
    }

    @Override
    public void insertarEnBD(DataBase db) {

        //cleanDatosAsociadoDocumento();
        Connection conexion = db.getConection();
        //INICIO TRANSACCION

        try {
            conexion.setAutoCommit(false);
            limpiarDatosAnteriores(this.getDniPresentacion(), db);

            actualizarNuevosDatosAgente(db);

            if (ExisteEtiqueta(this.presentacion.getCargasFamilia())) {
                insertCargFamilia(this.presentacion.getCargasFamilia().getCargasFamilia(), db);
            }
            if (ExisteEtiqueta(this.presentacion.getGanLiqOtrosEmpEnt())) {
                insertGanLiqOTrosEmpEnt(this.presentacion.getGanLiqOtrosEmpEnt().getEmpleadores(), db);
            }

            if (ExisteEtiqueta(this.presentacion.getDeducciones())) {
                insertDeducciones(this.presentacion.getDeducciones().getDeduccion(), db);
            }

            if (ExisteEtiqueta(this.presentacion.getRetPerPagos())) {
                insertRetPerPagos(this.presentacion.getRetPerPagos().getRetenciones(), db);
            }
            conexion.commit();
            System.out.println("SE COMPLETO LA TRANSACCION EXITOSAMENTE");

        } catch (SQLException e) {
            try {
                // Hacer rollback si hay un error
                conexion.rollback();
                System.out.println("Se realizó el rollback de la transacción.");
            } catch (SQLException ex) {
                Logger.getLogger(XMLSeccionA.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ParseException ex) {
            try {
                conexion.rollback();
                System.out.println("Se realizó el rollback de la transacción.");
            } catch (SQLException ex1) {
                Logger.getLogger(XMLSeccionA.class.getName()).log(Level.SEVERE, null, ex1);
            }

            Logger.getLogger(XMLSeccionA.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            try {
                conexion.rollback();
                System.out.println("Se realizó el rollback de la transacción.");
            } catch (SQLException ex1) {
                Logger.getLogger(XMLSeccionA.class.getName()).log(Level.SEVERE, null, ex1);
            }

            Logger.getLogger(XMLSeccionA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Lógica para determinar si es Sección B
    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    private void armarCuerpoInsertDeduccion(PreparedStatement pstmt, ConceptoType deduccion, String concepto, int mes, double monto) throws SQLException {
        pstmt.setBigDecimal(1, this.getDniPresentacion());
        pstmt.setInt(2, this.presentacion.getPeriodo());
        pstmt.setInt(3, this.presentacion.getNroPresentacion());
        pstmt.setInt(4, 1);
        pstmt.setString(5, concepto);
        pstmt.setDouble(6, monto);
        pstmt.setInt(7, mes);
        pstmt.setBigDecimal(8, new BigDecimal(deduccion.getNroDoc()));
        pstmt.setString(9, deduccion.getDenominacion());
        pstmt.setDate(10, obtenerFechaActual());
        pstmt.setInt(11, 0);
        pstmt.setInt(12, 0);
        pstmt.setInt(13, 0);
        pstmt.setString(14, "");
        pstmt.setInt(15, 0);
        pstmt.setInt(16, 0);

        if (ExisteEtiqueta(deduccion.getDetalles())) {
            List<DetalleType> detalles = deduccion.getDetalles().getDetalle();

            for (DetalleType detalle : detalles) {
                if ("tipoGasto".equals(detalle.getNombre())) {

                    pstmt.setInt(12, Integer.parseInt(detalle.getValor()));
                }
                if ("numeroDocFamiliar".equals(detalle.getNombre())) {
                    pstmt.setBigDecimal(13, new BigDecimal(detalle.getValor()));
                }
                if ("apellidoNombreFamiliar".equals(detalle.getNombre())) {
                    pstmt.setString(14, detalle.getValor());
                }
                if ("parentescoFamiliar".equals(detalle.getNombre())) {
                    pstmt.setInt(15, Integer.parseInt(detalle.getValor()));
                }
                if ("porcentajeDedFamiliar".equals(detalle.getNombre())) {
                    pstmt.setInt(16, Integer.parseInt(detalle.getValor()));
                }
            }

        }

        pstmt.addBatch();

    }

    private void insertDeducciones(List<ConceptoType> deducciones, DataBase db) throws SQLException, Exception {
        String sql = IConsultaSql.consulta_deduccion_insert;

        PreparedStatement pstmt = db.getPreparedStatement(sql);

        BigDecimal documento = this.getDniPresentacion();
        for (ConceptoType deduccion : deducciones) {

            String concepto = obtenerConceptoDeduccAdmitida(deduccion.getTipo(), db);
            if (deduccion.getTipo() == 99) {
                if (ExisteEtiqueta(deduccion.getDetalles())) {
                    List<DetalleType> detalles = deduccion.getDetalles().getDetalle();
                    int motivo = 0;
                    int mes = 0;
                    double montoMensual = Double.parseDouble(deduccion.getMontoTotal());
                    for (DetalleType detalle : detalles) {
                        if ("motivo".equals(detalle.getNombre())) {
                            motivo = Integer.parseInt(detalle.getValor());
                        }
                        if ("mes".equals(detalle.getNombre())) {
                            mes = Integer.parseInt(detalle.getValor());
                        }
                    }
                    if (motivo > 0 && motivo < 3 && mes > 0) {
                        armarCuerpoInsertDeduccion(pstmt, deduccion, concepto, mes, montoMensual);
                        continue;
                    }

                    if (motivo == 3) {

                    }
                    continue;
                }

            }

            if (ExisteEtiqueta(deduccion.getPeriodos())) {
                List<PeriodoType> periodos = deduccion.getPeriodos().getPeriodo();
                for (PeriodoType periodo : periodos) {
                    double montoMensual = Double.parseDouble(periodo.getMontoMensual());
                    if (isMesInicioEqualSMesFIN(periodo.getMesDesde(), periodo.getMesHasta())) {
                        armarCuerpoInsertDeduccion(pstmt, deduccion, concepto, periodo.getMesDesde(), montoMensual);
                    } else {

                        for (int mes = periodo.getMesDesde(); mes <= periodo.getMesHasta(); mes++) {

                            armarCuerpoInsertDeduccion(pstmt, deduccion, concepto, mes, montoMensual);

                        }
                    }
                }
            }
        }

        pstmt.executeBatch();

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
        return esPresentCargadaPosteriorPresentVigente(periodoPresenVigente,
                nroPresenVigente,
                periodoPresenCargada,
                nroPresenCargada);

    }

    private void armarCuerpoRetenPerPagos(PreparedStatement pstmt, String concepto, int mes, double montoMensual) throws SQLException {
        pstmt.setBigDecimal(1, this.getDniPresentacion());
        pstmt.setString(2, concepto);
        pstmt.setDouble(3, montoMensual);
        int mesActual = obtenerMesActual();
        pstmt.setInt(4, mesActual);
        pstmt.setNull(5, java.sql.Types.INTEGER);
        //cod empresa -> parametro 6
        pstmt.setInt(6, 1111);
        pstmt.setInt(7, mes);
        pstmt.setString(8, "");
        pstmt.addBatch();
    }

    private void insertRetPerPagos(List<ConceptoType> retenciones, DataBase db) throws SQLException {
        String sql = IConsultaSql.consulta_retperPagos_insert;
        PreparedStatement pstmt = db.getPreparedStatement(sql);
        for (ConceptoType retencion : retenciones) {
            //String concepto = obtenerConceptoDeduccAdmitida(deduccion.getTipo(), db);
            String concepto = "OTRARET";
            List<PeriodoType> periodos = retencion.getPeriodos().getPeriodo();
            for (PeriodoType periodo : periodos) {
                double montoMensual = Double.parseDouble(periodo.getMontoMensual());
                if (isMesInicioEqualSMesFIN(periodo.getMesDesde(), periodo.getMesHasta())) {
                    armarCuerpoRetenPerPagos(pstmt, concepto, periodo.getMesDesde(), montoMensual);
                } else {

                    for (int mes = periodo.getMesDesde(); mes <= periodo.getMesHasta(); mes++) {

                        armarCuerpoRetenPerPagos(pstmt, concepto, mes, montoMensual);

                    }
                }
            }
        }
        pstmt.executeBatch();
    }

    private double obtenerGanNeta(ingresoAporteType ingAp) {

        return ((ingAp.getGanBrut()
                + ingAp.getSac()
                + ingAp.getRetriNoHab()
                + ingAp.getAjuste()
                + ingAp.getHorasExtEx()
                + ingAp.getHorasExtGr()
                + ingAp.getMatDid()
                + ingAp.getGastosMovViat()
                + ingAp.getMovilidad()
                + ingAp.getViaticos()
                + ingAp.getOtrosConAn()
                + ingAp.getBonosProd()
                + ingAp.getFallosCaja()
                + ingAp.getConSimNat())
                - (ingAp.getObraSoc() + ingAp.getSegSoc() + ingAp.getSind()));

        /*exentos
          + ingAp.getExeNoAlc()
           ingAp.getTeletrabajoExento()
         + ingAp.getExeNoAlc()
        + ingAp.getRemunExentaLey27549())
        + ingAp.getSuplemParticLey19101()
         */
    }

    private void armarCuerpoGanLiqOTrosEmpEnt(int codEmp, ingresoAporteType ingAp, PreparedStatement pstmt) throws SQLException {
        pstmt.setBigDecimal(1, this.getDniPresentacion());
        pstmt.setInt(2, codEmp);
        pstmt.setInt(3, obtenerMesActual());
        pstmt.setDouble(4, obtenerGanNeta(ingAp));
        pstmt.setDouble(5, ingAp.getGanBrut());
        pstmt.setDouble(6, ingAp.getObraSoc());
        pstmt.setDouble(7, ingAp.getSegSoc());
        pstmt.setDouble(8, ingAp.getSind());
        pstmt.setDouble(9, ingAp.getRetriNoHab());
        pstmt.setDouble(10, ingAp.getAjuste());
        pstmt.setDouble(11, ingAp.getRetGan());
        pstmt.setInt(12, ingAp.getMes());
        pstmt.setDouble(13, ingAp.getSac());
        pstmt.setDouble(14, ingAp.getExeNoAlc());
        pstmt.setDouble(15, ingAp.getHorasExtGr());
        pstmt.setDouble(16, ingAp.getHorasExtEx());
        pstmt.setDouble(17, ingAp.getMatDid());
        //gastosMovViat se dividio en 2 conseptos por lo tanto se setea en 0
        pstmt.setDouble(18, 0);
        //bonoFalla
        pstmt.setDouble(19, 0);
        //exenct covid 
        pstmt.setDouble(20, ingAp.getRemunExentaLey27549());
        //exentro trabajadores militares
        pstmt.setDouble(21, ingAp.getSuplemParticLey19101());
        pstmt.setDouble(22, ingAp.getTeletrabajoExento());
        pstmt.setString(23, ingAp.getRegimen());
        pstmt.setDouble(24, ingAp.getBonosProd());
        pstmt.setDouble(25, ingAp.getFallosCaja());
        pstmt.setDouble(26, ingAp.getViaticos());
        pstmt.setDouble(27, ingAp.getMovilidad());
        pstmt.setDouble(28, ingAp.getConSimNat());

        pstmt.addBatch();
    }

    private void actualizarNuevosDatosAgente(DataBase db) throws SQLException, ParseException {
        String sql = "UPDATE agentes SET fechaf572 = ?, fechapres = ?, fechaweb = ?, web = ?, "
                + "wapellido = ?, wnombre = ?, wcp = ?, wlocalidad = ?, wcalle = ?, "
                + "wnro = ?, wpiso = ?, wdpto = ?, wcuit = ?, excep = ?, nropres = ?, "
                + "periodo = ?, wcuitreten = 0, wdescreten = '' WHERE documento = ?";

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
        pstmt.setInt(++i, 0);
        pstmt.setInt(++i, this.presentacion.getNroPresentacion());
        pstmt.setInt(++i, this.presentacion.getPeriodo());
        pstmt.setBigDecimal(++i, getDniPresentacion());

        // Ejecutar la actualización
        int filasActualizadas = pstmt.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("El empleado ha sido actualizado exitosamente. tuplas actualizadas: " + filasActualizadas);
        } else {
            System.out.println("No se encontró el empleado con el id 5.");
        }

    }

    public boolean existeAgente(DataBase db) throws SQLException {
        ResultSet rs = obtenerUltimaPresentacionVigente(db, this.getDniPresentacion());
        if (!rs.next()) {
            return false;
        }
        return true;
    }

}
