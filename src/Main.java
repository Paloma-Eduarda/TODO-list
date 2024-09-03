import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int opcao;

        GerenciarTarefas gt = new GerenciarTarefas();
        do {
            System.out.println("=========== Menu ===========");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Excluir Tarefa");
            System.out.println("4. Filtrar tarefa por Status");
            System.out.println("5. Filtrar tarefa por Categoria");
            System.out.println("6. Filtrar tarefa por prioridade");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Adicione uma tarefa");

                    System.out.println("Nome da tarefa");
                    String nome = scanner.nextLine();

                    System.out.println("Descrição da tarefa");
                    String descricao = scanner.nextLine();

                    System.out.println("Escolha uma das seguintes categorias: TRABALHO, ESTUDO E CASA");
                    Tarefas.Categoria categoria = Tarefas.Categoria.valueOf(scanner.nextLine().toUpperCase());

                    LocalDate dataFinal = null;
                    while (dataFinal == null) {
                        try {
                            System.out.print("Adicione uma data no formato dd/MM/yyyy: ");
                            String data = scanner.nextLine();
                            dataFinal = LocalDate.parse(data, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy.");
                        }
                    }

                    System.out.println("Adicione a prioridade de 1 a 5, sendo 1 Highest, 2 Critical, 3 High, 4 Medium e 5 Low");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Adicione um status para tarefa");
                    System.out.println("TODO, DOING e DONE");
                    Tarefas.Status opcaoStatus = Tarefas.Status.valueOf(scanner.nextLine().toUpperCase());

                    gt.adicionarTarefa(nome, descricao, categoria, dataFinal, prioridade, opcaoStatus);

                    break;
                case 2:
                    System.out.println("Listar Tarefas");
                    gt.listarTarefas();
                    break;
                case 3:
                    System.out.println("Digite o número que corresponde a tarefa que deseja excluir");
                    gt.listarTarefas();
                    int indiceTarefa = scanner.nextInt()-1;

                    gt.excluirTarefa(indiceTarefa);

                    break;
                case 4:
                    Tarefas.Status filtroStatus = null;
                    while (filtroStatus == null) {
                        try {
                            System.out.print("Filtrar por Status (TODO, DOING, DONE): ");
                            filtroStatus = Tarefas.Status.valueOf(scanner.nextLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Status inválido. Tente novamente.");
                        }
                    }
                    gt.filtrarTarefaPorStatus(filtroStatus);
                    break;
                case 5:
                    Tarefas.Categoria filtroCategoria = null;
                    while (filtroCategoria == null) {
                        try {
                            System.out.print("Filtrar por Categoria (TRABALHO, CASA E ESTUDO: ");
                            filtroCategoria = Tarefas.Categoria.valueOf(scanner.nextLine().toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Categoria inválida. Tente novamente.");
                        }
                    }
                    gt.filtrarTarefaPorCategoria(filtroCategoria);
                    break;
                case 6:
                    System.out.println("Filtrar por prioridade");
                    System.out.println("Digite 1 para - Highest");
                    System.out.println("Digite 2 para - Critical");
                    System.out.println("Digite 3 para - High");
                    System.out.println("Digite 4 para - Medium");
                    System.out.println("Digite 5 para - Low");;
                    int filtrarPrioridade = scanner.nextInt();

                    if(filtrarPrioridade>=1 && filtrarPrioridade<=5) {
                        gt.filtrarTarefaPorPrioridade(filtrarPrioridade);
                    }else{
                        System.out.println("Entrada invalida, digite um número de 1 a 5");
                    }

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

}