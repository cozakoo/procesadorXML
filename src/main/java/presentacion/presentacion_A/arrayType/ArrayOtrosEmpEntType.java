package presentacion_A.arrayType;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import presentacion.presentacion_A.type.EmpleadorEntidadType;
import presentacion.presentacion_A.type.ingresoAporteType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ArrayOtrosEmpEntType {

    @XmlElement(name = "empEnt")
    private List<EmpleadorEntidadType> empEnt = new ArrayList<>();

    public List<EmpleadorEntidadType> getEmpleadores() {
        return empEnt;
    }

    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (EmpleadorEntidadType emp : empEnt) {
            sb.append("----------- EMPLEADOR ENTIDAD ----------- \n");
            sb.append("cuit: ").append(emp.getCuit()).append("\n");
            sb.append("denominacion: ").append(emp.getDenominacion()).append("\n");
            sb.append("convenio colectivo: ").append(emp.getConvenioColectivo()).append("\n");
            sb.append("transporte largdist: ").append(emp.getTransporteLargaDist()).append("\n");

            for (ingresoAporteType ingAp : emp.getIngresosAportes().getIngAp()) {
                sb.append("*IngresosAportes*\n");
                sb.append("------- mes: ").append(ingAp.getMes())
                        .append("  regimen: ").append(ingAp.getRegimen()).append("----------\n");
                sb.append("\n");
                sb.append("obraSoc: ").append(ingAp.getObraSoc()).append("\n");
                sb.append("secSoc: ").append(ingAp.getSegSoc()).append("\n");
                sb.append("sind: ").append(ingAp.getSind()).append("\n");
                sb.append("ganBrut: ").append(ingAp.getGanBrut()).append("\n");
                sb.append("retGan: ").append(ingAp.getRetGan()).append("\n");
                sb.append("retriNoHab: ").append(ingAp.getRetriNoHab()).append("\n");
                sb.append("ajuste: ").append(ingAp.getAjuste()).append("\n");
                sb.append("exenoALC: ").append(ingAp.getExeNoAlc()).append("\n");
                sb.append("sac: ").append(ingAp.getSac()).append("\n");
                sb.append("horasExtGr: ").append(ingAp.getHorasExtGr()).append("\n");
                sb.append("horasExtEx: ").append(ingAp.getHorasExtEx()).append("\n");
                sb.append("MatDid: ").append(ingAp.getMatDid()).append("\n");
                sb.append("Movilidad: ").append(ingAp.getMovilidad()).append("\n");
                sb.append("viaticos: ").append(ingAp.getViaticos()).append("\n");
                sb.append("otrosConAn: ").append(ingAp.getOtrosConAn()).append("\n");
                sb.append("bonosProd: ").append(ingAp.getBonosProd()).append("\n");
                sb.append("fallosCaja: ").append(ingAp.getFallosCaja()).append("\n");
                sb.append("conSimNat: ").append(ingAp.getConSimNat()).append("\n");
                sb.append("remunExentaLey27549: ").append(ingAp.getRemunExentaLey27549()).append("\n");
                sb.append("suplemParticLey19101: ").append(ingAp.getSuplemParticLey19101()).append("\n");
                sb.append("teletrabajoExento: ").append(ingAp.getTeletrabajoExento()).append("\n");
                sb.append("---------------------------------------------------------------------------\n");
            }
        }

        return sb.toString();

    }

}
