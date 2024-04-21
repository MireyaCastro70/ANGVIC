package gestor.archivos;

import java.io.File;

public abstract class ControlArchivos {
    protected String archivo;

    public ControlArchivos(String archivo) {
        this.archivo = archivo;
    }

    public abstract boolean Crear();

    public boolean Eliminar() {
        File file = new File(archivo);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean Cambiar(String nuevoNombre) {
        File file = new File(archivo);
        if (file.exists()) {
            File nuevoArchivo = new File(nuevoNombre);
            return file.renameTo(nuevoArchivo);
        }
        return false;
    }

    public boolean Mover(String nuevoDirectorio) {
        File file = new File(archivo);
        if (file.exists()) {
            File nuevoDirectorioFile = new File(nuevoDirectorio);
            if (!nuevoDirectorioFile.exists()) {
                if (nuevoDirectorioFile.mkdirs()) {
                    return file.renameTo(new File(nuevoDirectorioFile, file.getName()));
                }
            } else {
                return file.renameTo(new File(nuevoDirectorioFile, file.getName()));
            }
        }
        return false;
    }
}
