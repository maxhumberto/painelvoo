package Painel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class voo {
    private int numeroDoVoo;
    private String destino;
    private String status;
    private String portaoDeEmbarque;
    private LocalDateTime horarioDePouso;
    private LocalDateTime horarioDePartida;

    public voo(int numeroDoVoo, String destino, LocalDateTime horarioDePartida) {
        this.numeroDoVoo = numeroDoVoo;
        this.destino = destino;
        this.status = "Programado";
        this.portaoDeEmbarque = "A definir";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        this.horarioDePartida = LocalDateTime.of(1970, 1, 1, 0, 0);
    }
    
    public int getNumeroDoVoo() {
        return numeroDoVoo;
    }

    public String getDestino() {
        return destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPortaoDeEmbarque() {
        return portaoDeEmbarque;
    }

    public void setPortaoDeEmbarque(String portaoDeEmbarque) {
        this.portaoDeEmbarque = portaoDeEmbarque;
    }

    public LocalDateTime getHorarioDePartida() {
        return this.horarioDePartida;
    }
    
    public void setHorarioDePartida(LocalDateTime horarioDePartida) {
        this.horarioDePartida = horarioDePartida;
    }
    
    public void setHorarioDePouso(LocalDateTime horarioDePouso) {
        this.horarioDePouso = horarioDePouso;
    }
    
  
}