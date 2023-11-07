package Painel;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Queue;
import java.util.Locale;

public class painelAeroporto {
    private listaDuplamenteLigada listaDuplamenteLigada = new listaDuplamenteLigada();
    private arvoreBinariaPesquisa arvoreBinariaPesquisa = new arvoreBinariaPesquisa();
    private ordemChegada ordemChegada;

    public painelAeroporto() {
        // Inicialize a ordem de chegada com a fila de voos agendados
        ordemChegada = new ordemChegada(new LinkedList<>()); // Utilize LinkedList para a fila.
    }

    public void alterarStatusEPortao(int numeroDoVoo, String status, String portaoDeEmbarque) {
        horarioPartida current = listaDuplamenteLigada.getHead();
        while (current != null) {
            if (current.getVoo().getNumeroDoVoo() == numeroDoVoo) {
                current.getVoo().setStatus(status);
                current.getVoo().setPortaoDeEmbarque(portaoDeEmbarque);
                break;
            }
            current = current.getNext();
        }
    }

    public void controlarPousosEAterrissagens() {
        if (!ordemChegada.getFilaVoosAgendados().isEmpty()) {
            // Obtenha o próximo voo agendado
            voo vooAgendado = ordemChegada.getFilaVoosAgendados().poll();

            // Simule o pouso definindo o horário de pouso
            LocalDateTime horarioDePouso = LocalDateTime.now(); // Você pode obter o horário atual
            vooAgendado.setHorarioDePouso(horarioDePouso);

            // Crie um objeto vooPousado com base no voo agendado
            vooPousado vooPousado = new vooPousado(vooAgendado, horarioDePouso);

            // Adicione o voo pousado à pilha de voos pousados
            ordemChegada.getPilhaVoosPousados().push(vooPousado);
        }
    }

    public void exibirVoosEmOrdemDePartida(boolean usarHeap) {
        if (usarHeap) {
            arvoreBinariaPesquisa.exibirVoosEmOrdemDePartida();
        } else {
            listaDuplamenteLigada.exibirVoosEmOrdemDePartida();
        }
    }

    public voo obterInformacoesDoVoo(int numeroDoVoo) {
        // Implemente a lógica para obter informações detalhadas sobre um voo com base no número do voo.
        horarioPartida current = listaDuplamenteLigada.getHead();
        while (current != null) {
            if (current.getVoo().getNumeroDoVoo() == numeroDoVoo) {
                return current.getVoo();
            }
            current = current.getNext();
        }
        // Implemente a busca na árvore se necessário.
        return null; // Retorne null se o voo não for encontrado.
    }

    public void cancelarVoo(int numeroDoVoo) {
        // Implemente a lógica para cancelar um voo com base no número do voo fornecido pelo usuário.
        // Você deve remover o voo da listaDuplamenteLigada, da arvoreBinariaPesquisa e da fila de voos agendados na ordemChegada.
        horarioPartida current = listaDuplamenteLigada.getHead();
        while (current != null) {
            if (current.getVoo().getNumeroDoVoo() == numeroDoVoo) {
                listaDuplamenteLigada.removerVoo(current);
                break;
            }
            current = current.getNext();
        }

        for (voo voo : ordemChegada.getFilaVoosAgendados()) {
            if (voo.getNumeroDoVoo() == numeroDoVoo) {
                ordemChegada.getFilaVoosAgendados().remove(voo);
                break;
            }
        }
    }

    public void exibirVoosPousados() {
        // Implemente a lógica para exibir os voos pousados, que estão na pilha de voos pousados da ordemChegada.
        System.out.println("Voos pousados:");
        while (!ordemChegada.getPilhaVoosPousados().isEmpty()) {
            vooPousado vooPousado = ordemChegada.getPilhaVoosPousados().pop();
            System.out.println("Número do Voo: " + vooPousado.getVoo().getNumeroDoVoo());
            System.out.println("Destino: " + vooPousado.getVoo().getDestino());
            System.out.println("Horário de Pouso: " + vooPousado.getHorarioDePouso());
            // Exiba outras informações, se necessário.
        }
    }

    public void exibirEstatisticasDeVoos() {
        // Implemente a lógica para calcular e exibir estatísticas de voos, como a quantidade de voos programados, atrasados, cancelados, pousados, etc.
        int totalVoosProgramados = listaDuplamenteLigada.tamanhoLista();
        int totalVoosAtrasados = listaDuplamenteLigada.contarVoosAtrasados();
        int totalVoosCancelados = ordemChegada.getFilaVoosCancelados().size();
        int totalVoosPousados = ordemChegada.getPilhaVoosPousados().size();

        System.out.println("Estatísticas de Voos:");
        System.out.println("Total de Voos Programados: " + totalVoosProgramados);
        System.out.println("Total de Voos Atrasados: " + totalVoosAtrasados);
        System.out.println("Total de Voos Cancelados: " + totalVoosCancelados);
        System.out.println("Total de Voos Pousados: " + totalVoosPousados);
    }

    public int contarVoosAtrasados() {
        int contadorAtrasados = 0;
        LocalDateTime horarioAtual = LocalDateTime.now(); // Obtém o horário atual

        horarioPartida atual = listaDuplamenteLigada.getHead();
        while (atual != null) {
            // Acesse o horário de partida diretamente da instância de horarioPartida
            if (horarioAtual.isAfter(atual.getVoo().getHorarioDePartida())) {
                contadorAtrasados++;
            }
            atual = atual.getNext();
        }
        return contadorAtrasados;
    }

    public void exibirTotalVoosAtrasados() {
        int totalVoosAtrasados = listaDuplamenteLigada.contarVoosAtrasados();
        System.out.println("Total de voos atrasados: " + totalVoosAtrasados);
    }

    public void registrarNovoVoo(int numeroDoVoo, String destino, LocalDateTime horarioDePartida) {
        // Crie uma nova instância de Voo com os dados fornecidos
        voo novoVoo = new voo(numeroDoVoo, destino, horarioDePartida);

        // Insira o novo voo na lista duplamente ligada mantendo a ordem com base no horário de partida
        listaDuplamenteLigada.inserirVooOrdenado(novoVoo);

        // Insira o novo voo na árvore binária de pesquisa mantendo a ordem com base no horário de partida
        arvoreBinariaPesquisa.inserirVoo(novoVoo);

        // Adicione o novo voo à fila de voos agendados na ordem de chegada
        ordemChegada.adicionarVooAgendado(novoVoo);
    }
    // Outros métodos necessários para coordenar as operações do sistema

	public void registrarNovoVoo(voo novoVoo) {
		// TODO Auto-generated method stub
		listaDuplamenteLigada.inserirVooOrdenado(novoVoo);

	    // Insira o novo voo na árvore binária de pesquisa mantendo a ordem com base no horário de partida
	    arvoreBinariaPesquisa.inserirVoo(novoVoo);

	    // Adicione o novo voo à fila de voos agendados na ordem de chegada
	    ordemChegada.adicionarVooAgendado(novoVoo);
	
	}

	
}