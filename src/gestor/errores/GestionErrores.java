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
        errores.put(1, "Error: empleado no encontrado o datos no inicializados.");
        errores.put(2, "Error: no se pueden agregar más contratos, límite alcanzado.");
        errores.put(3, "Error: no se encontró ningún solicitante con el ID proporcionado.");
        errores.put(4, "Error: falta información requerida.");
        errores.put(5, "Error: la operación no se pudo completar debido a un error interno.");
        errores.put(6, "Error: permisos insuficientes para realizar la operación.");
        errores.put(7, "Error: el formato de los datos es incorrecto.");
        errores.put(8, "Error: la conexión con la base de datos ha fallado.");
        errores.put(9, "Error: la operación no está permitida en el estado actual.");
        errores.put(10, "Error: el archivo no se pudo leer o escribir correctamente.");
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