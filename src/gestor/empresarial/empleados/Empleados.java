package gestor.empresarial.empleados;
import gestor.empresarial.datos.*;
import gestor.empresarial.contrato.*;
import gestor.errores.GestionErrores;


public final class Empleados implements iEmpleados { //esta clase no ofrece herencia, solo instancia
    private DatosEmpresariales[] datosRH;
    private Contrato[] contratosRH;
    public GestionErrores error;
    private int i;
    private int j;

    public Empleados() {
        this.i = 0;
        this.j = 0;
        datosRH = new DatosEmpresariales[100];
        contratosRH = new Contrato[100];
        error = new GestionErrores();
    }
    public int addDatosPersonales(String nombre, String apellido, String correo, String whatsapp){
        if (i < 100){
            int id = i + 1; // Se genera el ID
            datosRH[i] = new DatosEmpresariales(id, nombre, apellido, correo, whatsapp);
            datosRH[i].setNombre(nombre);
            datosRH[i].setApellidos(apellido);
            datosRH[i].setWhatsApp(whatsapp);
            datosRH[i].setCorreo(correo);
            this.i++;
            System.out.println("Solicitante registrado con ID: " + id);
            System.out.println("Datos Aspirante registrados");
            return id; // Se devuelve el ID generado
        }
        else {
            GestionErrores errores = new GestionErrores();
            errores.setNoError(2, "Error: no se pueden agregar más solicitantes, límite alcanzado.");
            System.out.println(errores.getError());
        }
        return 0;
    }
    public int getId(){
        return this.i;
    }
    public void showDatosPersonales(){
        for (int a=0; a<1; a++ ){
            System.out.println("Ingrese ID: " + datosRH[a].getId()+ "\n Ingrese nombre: "+datosRH[a].getNombre()+"\n Ingrese Apellidos: "+ datosRH[a].getApellidos()+"\nIngrese correo: "+ datosRH[a].getCorreo()+
                    "\n Ingrese whatsaap+"+ datosRH[a].getWhatsApp());
        }
    }
    public DatosEmpresariales getDatosPersonales(int id) {
        for (int a = 0; a < i; a++) {
            if (datosRH[a].getId() == id) {
                return datosRH[a];
            }
        }
        GestionErrores errores = new GestionErrores();
        errores.setNoError(3, "Error: no se encontró ningún solicitante con el ID proporcionado.");
        System.out.println(errores.getError());
        return null; // Retorna null si no se encuentra ningún solicitante con el ID dado
    }
    public void addDatosEmpresariales(int id, String adscripcion, String telefonoExterior, String puesto) {
        DatosEmpresariales empleado = getDatosPersonales(id);
        if (empleado != null) { // Verificar si se encontró al empleado
            empleado.setAdscripcion(adscripcion);
            empleado.setTelefonoExtension(telefonoExterior);
            empleado.setPuesto(puesto);
            System.out.println("Se registraron los datos empresariales con éxito.");
        } else {
            GestionErrores errores = new GestionErrores();
            errores.setNoError(1, "Error: empleado no encontrado o datos no inicializados."); // Podrías definir un código de error específico
            System.out.println(errores.getError()); // Mostrar el mensaje de error
        }
    }
    public void showDatosEmpleado(int id) {
        boolean empleadoEncontrado = false;
        for (int a = 0; a < i; a++) {
            if (datosRH[a].getId() == id) {
                System.out.println("ID: " + datosRH[a].getId() +
                        "\nNombre: " + datosRH[a].getNombre() +
                        "\nApellidos: " + datosRH[a].getApellidos() +
                        "\nCorreo: " + datosRH[a].getCorreo() +
                        "\nWhatsApp: " + datosRH[a].getWhatsApp() +
                        "\nAdscripción: " + datosRH[a].getAdscripcion() +
                        "\nTeléfono de extensión: " + datosRH[a].getTelefonoExtension() +
                        "\nPuesto: " + datosRH[a].getPuesto() + "\n");
                empleadoEncontrado = true;
                break;
            }
        }
        if (!empleadoEncontrado) {
            System.out.println("Empleado con ID " + id + " no encontrado.");
        }
    }
    public void addContrato(int id, int noContrato, int annio, String horario, Cargos tipoCargo){
        contratosRH[j] = new Contrato(id);
        if (this.j < 100){
            contratosRH[j].setNoContrato(noContrato);
            contratosRH[j].setAnnio(annio);
            contratosRH[j].sethorario(horario);
            contratosRH[j].setTipoCargo(tipoCargo);
            this.j++;
        }else {
            GestionErrores errores = new GestionErrores();
            errores.setNoError(2, "Error: no se pueden agregar más contratos, límite alcanzado.");
            System.out.println(errores.getError());
        }
    }
    public void showContratoEmpleado(int n){
        for(int a = 0; a<j; a++){
            if (contratosRH[a] != null){
                System.out.println("Ingrese ID del empleado: "+contratosRH[a].getId()+ "\nIngrese No.Contrato: "+ contratosRH[a].getNoContrato()+
                        "\nIngrese Año: "+ contratosRH[a].getAnnio()+"\nIngrese horario: "+ contratosRH[a].getHorario()+ "\nIngrese tipo de cargo:" + contratosRH[a].getTipoCargo());
            }
        }
    }
    public  void showEmpresa(){
        System.out.println("Nombre de la empresa: Itera S.A. de C.V.");
        System.out.println("RFC: RFC123456789");
        System.out.println("Telefono: 221353424");
        System.out.println("Representante Legal: Victor Zacatzontle");
    }
    @Override
    public String getInfoEmpleado(int id) {
        return null;
    }

    @Override
    public String getInfoEmpleado(String nombre) {
        for (int a = 0; a < i; a++) {
            if (datosRH[a].getNombre().equals(nombre)) {
                return "ID: " + datosRH[a].getId() +
                        "\nNombre: " + datosRH[a].getNombre() +
                        "\nApellidos: " + datosRH[a].getApellidos() +
                        "\nCorreo: " + datosRH[a].getCorreo() +
                        "\nWhatsApp: " + datosRH[a].getWhatsApp() +
                        "\nAdscripción: " + datosRH[a].getAdscripcion() +
                        "\nTeléfono de extensión: " + datosRH[a].getTelefonoExtension() +
                        "\nPuesto: " + datosRH[a].getPuesto();
            }
        }
        return "Empleado no encontrado.";
    }

    @Override
    public void showDatosEmpleados() {
        for (int a = 0; a < i; a++) {
            System.out.println("ID: " + datosRH[a].getId() +
                    "\nNombre: " + datosRH[a].getNombre() +
                    "\nApellidos: " + datosRH[a].getApellidos() +
                    "\nCorreo: " + datosRH[a].getCorreo() +
                    "\nWhatsApp: " + datosRH[a].getWhatsApp() +
                    "\nAdscripción: " + datosRH[a].getAdscripcion() +
                    "\nTeléfono de extensión: " + datosRH[a].getTelefonoExtension() +
                    "\nPuesto: " + datosRH[a].getPuesto() + "\n");
        }
    }

    @Override
    public void showContratosEmpleado(int id) {
        for (int a = 0; a < j; a++) {
            if (contratosRH[a].getId() == id) {
                System.out.println("ID del empleado: " + contratosRH[a].getId() +
                        "\nNo. Contrato: " + contratosRH[a].getNoContrato() +
                        "\nAño: " + contratosRH[a].getAnnio() +
                        "\nHorario: " + contratosRH[a].getHorario() +
                        "\nTipo de cargo: " + contratosRH[a].getTipoCargo() + "\n");
            }
        }
    }

    @Override
    public int getAntiguedad(int id) {
        return 0 ;
    }
}