package Painel;

import java.util.Queue;
import java.util.Stack;

public class ordemChegada {
    private Queue<voo> filaVoosAgendados; // Fila de voos agendados
    private Stack<vooPousado> pilhaVoosPousados; // Pilha de voos pousados
    private Queue<voo> filaVoosCancelados; 
    
    
    public Queue<voo> getFilaVoosCancelados() {
        return filaVoosCancelados;
    }

    public ordemChegada(Queue<voo> filaVoosAgendados) {
        this.filaVoosAgendados = filaVoosAgendados;
        this.pilhaVoosPousados = new Stack<>();
    }

    public void adicionarVooAgendado(voo voo) {
        filaVoosAgendados.offer(voo);
    }

    public Queue<voo> getFilaVoosAgendados() {
        return filaVoosAgendados;
    }
    
    public int getFilaVoosCanceladosSize() {
        return filaVoosCancelados.size();
    }

    public Stack<vooPousado> getPilhaVoosPousados() {
        return pilhaVoosPousados;
    }
    public void moverVooPousadoDaFilaParaPilha() {
        if (!filaVoosAgendados.isEmpty()) {
            voo voo = filaVoosAgendados.poll();
            vooPousado vooPousado = new vooPousado(voo);
            pilhaVoosPousados.push(vooPousado);
        }
    }

    // Outros métodos, se necessário
}