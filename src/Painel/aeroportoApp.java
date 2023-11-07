package Painel;

import java.util.Locale;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class aeroportoApp {
    public static void main(String[] args) {
        painelAeroporto aeroporto = new painelAeroporto();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema do aeroporto!");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
        
        

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1 - Registrar um novo voo");
            System.out.println("2 - Alterar status e portão de embarque");
            System.out.println("3 - Controlar pousos e aterrissagens");
            System.out.println("4 - Exibir voos em ordem de partida");
            System.out.println("5 - Obter informações de um voo");
            System.out.println("6 - Cancelar um voo");
            System.out.println("7 - Exibir voos pousados");
            System.out.println("8 - Exibir estatísticas de voos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            
         


            switch (opcao) {
                case 1:
                                    System.out.print("Número do Voo: ");
                    int numeroDoVoo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.print("Destino: ");
                    String destino = scanner.nextLine();

                    System.out.print("Horário de Partida (dd/MM/yyyy HH:mm a): ");
                    String horarioDePartida = scanner.nextLine();

                    LocalDateTime horarioPartida = LocalDateTime.parse(horarioDePartida, formatter);

                    voo novoVoo = new voo(numeroDoVoo, destino, horarioPartida);

                    System.out.println("Voo registrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Número do Voo: ");
                    numeroDoVoo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.print("Novo status: ");
                    String novoStatus = scanner.nextLine();

                    System.out.print("Novo portão de embarque: ");
                    String novoPortaoDeEmbarque = scanner.nextLine();

                    aeroporto.alterarStatusEPortao(numeroDoVoo, novoStatus, novoPortaoDeEmbarque);
                    System.out.println("Status e portão de embarque atualizados com sucesso!");
                    break;

                case 3:
                    aeroporto.controlarPousosEAterrissagens();
                    break;

                case 4:
                    aeroporto.exibirVoosEmOrdemDePartida(true);
                    break;

                case 5:
                	System.out.println("Digite o número do voo:");
                    int numeroVoo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    voo vooEncontrado = aeroporto.obterInformacoesDoVoo(numeroVoo);
                    if (vooEncontrado != null) {
                        System.out.println("Informações do voo:");
                        System.out.println("Número do Voo: " + vooEncontrado.getNumeroDoVoo());
                        System.out.println("Destino: " + vooEncontrado.getDestino());
                        System.out.println("Horário de Partida: " + vooEncontrado.getHorarioDePartida().format(formatter));
                    } else {
                        System.out.println("Voo não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o número do voo que deseja cancelar: ");
                    int numeroDoVooCancelar = scanner.nextInt();
                    aeroporto.cancelarVoo(numeroDoVooCancelar);
                    System.out.println("Voo com número " + numeroDoVooCancelar + " cancelado com sucesso.");
                    break;

                case 7:
                    aeroporto.exibirVoosPousados();
                    break;

                case 8:
                    aeroporto.exibirEstatisticasDeVoos();
                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}

