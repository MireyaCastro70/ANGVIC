package gestor.archivos;

public interface iFileText {
    public void AbrirModoLectura();
    public void Leer2();

    public String Leer();

    public void AbrirModoEscritura();

    public void Escribir(String texto);

    public void Cerrar();
}
