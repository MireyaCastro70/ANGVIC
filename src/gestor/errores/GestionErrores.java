package gestor.errores;

import java.util.HashMap;
import java.util.Map;

public final class GestionErrores {
    private final Map<Integer, String> errores;
    private int noError;
    private final String descripcionTecnica;

    public GestionErrores() {
        errores = new HashMap<>();
        descripcionTecnica = "Error desconocido";
        cargarErrores();
    }

    private void cargarErrores() {
        // Aquí se cargarían los errores predefinidos en el mapa
        // Ejemplo:
        errores.put(1, "Error de conexión");
        errores.put(2, "Error de lectura de archivo");
        // Agrega más errores según sea necesario
    }

    public void setNoError(int codigoError, String descripcion) {
        errores.put(codigoError, descripcion);
    }

    public String getError() {
        return errores.getOrDefault(noError, "Error desconocido");
    }

    public String getErrorTecnico() {
        return descripcionTecnica;
    }

    public boolean existeError() {
        return errores.containsKey(noError);
    }
}