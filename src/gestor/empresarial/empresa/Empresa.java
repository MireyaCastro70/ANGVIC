package gestor.empresarial.empresa;
import gestor.empresarial.empleados.*;

public final class Empresa { //esta clase no ofrece herencia, solo instancia
    private String nombreEmpresa;
    private String telefono;
    private String rfc;
    private String representanteLegal;

    public Empleados datosRH;

    public Empresa(String nombreEmpresa, String rfc) {
        this.nombreEmpresa=nombreEmpresa;
        this.rfc=rfc;

        datosRH= new Empleados();
//        datosRH = ArregloInformacion.creandoInstanciaPrivada8349();
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInfo() {
        String datos="";

        datos += "Representante Legal: " + this.representanteLegal + "\n";
        datos += "Empresa: " + this.nombreEmpresa + "\n";
        datos += "RFC: " + this.rfc + "\n";
        datos += "Teléfono empresarial: " + (this.telefono!=null ? this.telefono : "No registrado") + "\n";

        return datos;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String repreentanteLegal)  {
        this.representanteLegal = repreentanteLegal;
    }

}

