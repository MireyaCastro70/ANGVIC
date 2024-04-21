package gestor.empresarial.contrato;


public final class Contrato {
    private int id;
    private int noContrato;
    private int annio;
    private String horario;
    private Cargos tipoCargo;

    public Contrato(int id) {
        this.id = id;
        this.noContrato = noContrato;
        this.annio = annio;
        this.tipoCargo = tipoCargo;
        this.horario = horario;
    }
    public String getInfo() {
        String info = "ID del contrato: " + id + "\n";
        info += "Año del contrato: " + annio + "\n";
        info += "Cargo: " + tipoCargo + "\n";
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

    public Cargos getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(Cargos tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public void sethorario(String horario) {
        this.horario  = horario;
    }

    public String getHorario() {
        return horario;
    }
}

