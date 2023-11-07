package Painel;
import java.time.LocalDateTime;

public class listaDuplamenteLigada {
    private horarioPartida head;
    private horarioPartida tail;

    public void inserirVooOrdenado(voo voo) {
        horarioPartida novoNodo = new horarioPartida(voo);
        if (head == null) {
            head = novoNodo;
            tail = novoNodo;
        } else {
            horarioPartida atual = head;
            while (atual != null && voo.getHorarioDePartida().compareTo(atual.getVoo().getHorarioDePartida()) >= 0) {
                atual = atual.getNext();
            }
            if (atual == head) {
                novoNodo.setNext(head);
                head.setPrev(novoNodo);
                head = novoNodo;
            } else if (atual == null) {
                novoNodo.setPrev(tail);
                tail.setNext(novoNodo);
                tail = novoNodo;
            } else {
                novoNodo.setNext(atual);
                novoNodo.setPrev(atual.getPrev());
                atual.getPrev().setNext(novoNodo);
                atual.setPrev(novoNodo);
            }
        }
    }
    
    public horarioPartida getHead() {
        return head;
    }
    
    public int tamanhoLista() {
        int tamanho = 0;
        horarioPartida atual = head;
        while (atual != null) {
            tamanho++;
            atual = atual.getNext();
        }
        return tamanho;
    }

    public void removerVoo(horarioPartida vooParaRemover) {
        if (vooParaRemover == null) {
            return; // Não faz nada se o voo fornecido for nulo
        }

        if (vooParaRemover == head) {
            // Se o voo a ser removido for o primeiro da lista
            head = vooParaRemover.getNext();
        }

        if (vooParaRemover.getPrev() != null) {
            vooParaRemover.getPrev().setNext(vooParaRemover.getNext());
        }

        if (vooParaRemover.getNext() != null) {
            vooParaRemover.getNext().setPrev(vooParaRemover.getPrev());
        }
    }
    
    public int contarVoosAtrasados() {
        int contadorAtrasados = 0;
        LocalDateTime horarioAtual = LocalDateTime.now();

        horarioPartida atual = head;
        while (atual != null) {
            if (horarioAtual.isAfter(atual.getVoo().getHorarioDePartida())) {
                contadorAtrasados++;
            }
            atual = atual.getNext();
        }
        return contadorAtrasados;
    }
   
    public void exibirVoosEmOrdemDePartida() {
        horarioPartida atual = head;
        while (atual != null) {
            System.out.println(atual.getVoo().getNumeroDoVoo() + " - " + atual.getVoo().getHorarioDePartida());
            atual = atual.getNext();
        }
    }

    // Outros métodos necessários para gerenciar a lista duplamente ligada
}
