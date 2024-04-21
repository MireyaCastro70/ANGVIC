package gestor.empresarial.datos;

public final class DatosEmpresariales extends DatosPersonales{ //esta clase no ofrece herencia, solo instancia
    private String adscripcion;
    private String telefonoExtension;
    private String puesto;

    public DatosEmpresariales(int id, String nombre, String apellidos, String correo, String whatsapp) {
        super.setId(id);
        super.setNombre(nombre);
        super.setApellidos(apellidos);
        super.setCorreo(correo);
        super.setWhatsApp(whatsapp);

    }

    @Override
    public int getId() {
        return super.getId();
    }

    public String getAdscripcion() {

        return adscripcion;
    }

    public void setAdscripcion(String adscripcion) {

        this.adscripcion = adscripcion;
    }

    public String getTelefonoExtension() {

        return telefonoExtension;
    }

    public void setTelefonoExtension(String telefonoExtension) {

        this.telefonoExtension = telefonoExtension;
    }

    public String getPuesto() {

        return puesto;
    }

    public void setPuesto(String puesto) {

        this.puesto = puesto;
    }
}

