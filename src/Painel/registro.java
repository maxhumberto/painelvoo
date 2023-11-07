package Painel;

public class registro {
    private int numeroDoVoo;
    private String destino;
    private String status;
    private String portaoDeEmbarque;
    private String horarioDePartida;
    private boolean pousado;
    private String horarioDePouso;

    public registro(int numeroDoVoo, String destino, String horarioDePartida) {
        this.numeroDoVoo = numeroDoVoo;
        this.destino = destino;
        this.status = "Programado";
        this.portaoDeEmbarque = "A definir";
        this.horarioDePartida = horarioDePartida;
        this.pousado = false;
        this.horarioDePouso = null;
    }

    // Implemente os métodos getters e setters necessários.

    public boolean isPousado() {
        return pousado;
    }

    public void setPousado(boolean pousado) {
        this.pousado = pousado;
    }

    public String getHorarioDePouso() {
        return horarioDePouso;
    }

    public void setHorarioDePouso(String horarioDePouso) {
        this.horarioDePouso = horarioDePouso;
    }
}