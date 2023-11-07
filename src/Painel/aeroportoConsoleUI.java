package Painel;

import java.util.Scanner;

public class aeroportoConsoleUI {
    private painelAeroporto painelAeroporto;

    public aeroportoConsoleUI(painelAeroporto painelAeroporto) {
        this.painelAeroporto = painelAeroporto;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar novo voo");
            System.out.println("2. Alterar status e portão de embarque");
            System.out.println("3. Controlar pousos e aterrissagens");
            System.out.println("4. Exibir voos em ordem de partida");
            System.out.println("5. Exibir informações de um voo");
            System.out.println("6. Cancelar um voo");
            System.out.println("7. Exibir voos pousados");
            System.out.println("8. Exibir estatísticas de voos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Implemente a lógica para registrar um novo voo.
                    break;
                case 2:
                    // Implemente a lógica para alterar status e portão de embarque.
                    break;
                case 3:
                    // Implemente a lógica para controlar pousos e aterrissagens.
                    break;
                case 4:
                    // Implemente a lógica para exibir voos em ordem de partida.
                    break;
                case 5:
                    // Implemente a lógica para exibir informações de um voo.
                    break;
                case 6:
                    // Implemente a lógica para cancelar um voo.
                    break;
                case 7:
                    // Implemente a lógica para exibir voos pousados.
                    break;
                case 8:
                    // Implemente a lógica para exibir estatísticas de voos.
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        painelAeroporto painelAeroporto = new painelAeroporto();
        aeroportoConsoleUI ui = new aeroportoConsoleUI(painelAeroporto);
        ui.exibirMenu();
    }
}