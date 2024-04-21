package gestor.archivos;
import java.io.*;

public final class ArchivoTexto extends ControlArchivos implements iFileText{
    private File file;
    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;
    private boolean archivoExiste;
    private boolean modoLectura;
    private boolean modoEscritura;

    public ArchivoTexto(String tituloArchivo){
        super(tituloArchivo);
        try {
            file = new File(tituloArchivo);

            if (!file.exists())
                file.createNewFile();

            this.archivoExiste=true;
            this.modoLectura=false;
            this.modoEscritura=false;
        }
        catch (Exception e){
            System.out.println("Error al intentar buscar el archivo");
            this.archivoExiste=false;
            //System.out.println();
        }
    }

    @Override
    public boolean Crear() {
        if (file != null) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                    archivoExiste = true;
                    return true;
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
                archivoExiste = false;
            }
        }
        return false;
    }
    public ArchivoTexto(String tituloArchivo, boolean nuevo) {
        super(tituloArchivo);

    }


    public void AbrirModoLectura(){
        if (archivoExiste==true) {
            try {
                fr = new FileReader(this.file.getAbsoluteFile());
                br = new BufferedReader(this.fr);
                this.modoLectura=true;
                System.out.println("Archivo abierto en modo lectura");
            } catch (Exception e) {
                System.out.println("Error: El archivo no se puede abrir en modo lectura");
            }
        }
    }
    public void Leer2(){
        if (archivoExiste==true) {
            try {
                int i = 1;
                String linea = this.br.readLine();

                while (linea != null) {
                    System.out.println(i + ".- " + linea);
                    linea = this.br.readLine();
                    i++;
                }
            } catch (Exception e) {
                System.out.println("Error: No se puede extraer información del archivo");
            }
        }
    }

    public String Leer(){
        if (archivoExiste==true) {
            try {
                return this.br.readLine();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void AbrirModoEscritura(){
        if (archivoExiste==true) {
            try {
                fw = new FileWriter(this.file.getAbsoluteFile(),true);
                bw = new BufferedWriter(this.fw);
                modoEscritura=true;
                System.out.println("Archivo abierto en modo escritura");
            } catch (Exception e) {
                System.out.println("Error: El archivo no se puede abrir en modo escritura");
            }
        }
    }

    public void Escribir(String texto){
        if (archivoExiste==true) {
            try {
                this.bw.write(texto+"\n");
            } catch (Exception e) {
                System.out.println("Error: No se puede escribir información en el archivo");
            }
        }
    }

    public void Cerrar()
    {
        if (modoEscritura==true){
            try {
                this.bw.close();
                this.fw.close();
            }catch (Exception e){ }
        }
        else if (modoLectura==true)
        {
            try {
                this.br.close();
                this.fr.close();
            }catch (Exception e) { }
        }
    }
}
