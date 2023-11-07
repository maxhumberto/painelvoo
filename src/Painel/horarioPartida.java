package Painel;

public class horarioPartida {
    private voo voo;
    private horarioPartida prev;
    private horarioPartida next;

    public horarioPartida(voo voo) {
        this.voo = voo;
    }

    public voo getVoo() {
        return voo;
    }

    public horarioPartida getPrev() {
        return prev;
    }

    public void setPrev(horarioPartida prev) {
        this.prev = prev;
    }

    public horarioPartida getNext() {
        return next;
    }

    public void setNext(horarioPartida next) {
        this.next = next;
    }
}
