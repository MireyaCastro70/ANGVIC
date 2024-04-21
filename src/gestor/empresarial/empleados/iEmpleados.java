package gestor.empresarial.empleados;

public interface iEmpleados {
    String getInfoEmpleado(int id);
    String getInfoEmpleado(String nombre);
    void showDatosEmpleados();
    void showContratosEmpleado(int id);
    int getAntiguedad(int id);
}
