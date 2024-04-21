package gestor.empresarial.contrato;


public final class Contrato {
    private int id;
    private int noContrato;
    private int annio;
    private Cargos cargo;

    public Contrato(int id, int noContrato, int annio, Cargos cargo) {
        this.id = id;
        this.noContrato = noContrato;
        this.annio = annio;
        this.cargo = cargo;
    }
    public String getInfo() {
        String info = "ID del contrato: " + id + "\n";
        info += "Año del contrato: " + annio + "\n";
        info += "Cargo: " + cargo + "\n";
        return info;
    }
    public int getId() {

        return id;
    }

    public int getNoContrato() {

        return noContrato;
    }

    public void setNoContrato(int noContrato) {

        this.noContrato = noContrato;
    }

    public int getAnnio() {

        return annio;
    }

    public void setAnnio(int annio) {

        this.annio = annio;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }
}

