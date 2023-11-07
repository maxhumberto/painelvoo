package Painel;
import java.util.PriorityQueue;

public class arvoreBinariaPesquisa {
    private PriorityQueue<voo> heap = new PriorityQueue<>((v1, v2) -> v1.getHorarioDePartida().compareTo(v2.getHorarioDePartida()));

    public void inserirVoo(voo voo) {
        heap.offer(voo);
    }

    public void exibirVoosEmOrdemDePartida() {
        System.out.println("Voos em ordem de partida (usando Heap):");
        for (voo voo : heap) {
            System.out.println(voo.getNumeroDoVoo() + " - Destino: " + voo.getDestino() + " - Horário de Partida: " + voo.getHorarioDePartida());
        }
    }

    // Outros métodos necessários para gerenciar a árvore binária de pesquisa (Heap)
}