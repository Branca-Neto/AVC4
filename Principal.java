import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssociacaoDesportiva associacao = new AssociacaoDesportiva();

        int opcao;
        do {
            System.out.println("\n----- Menu Principal -----");
            System.out.println("1. Criar sócio");
            System.out.println("2. Adicionar campeonato em uma atividade");
            System.out.println("3. Adicionar equipe");
            System.out.println("4. Registrar partida");
            System.out.println("5. Pagar quotas de sócio");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Criar sócio
                    associacao.criarSocio(scanner);
                    break;
                case 2:
                    // Adicionar campeonato em uma atividade
                    associacao.adicionarCampeonato(scanner);
                    break;
                case 3:
                    // Adicionar equipe
                    associacao.adicionarEquipe(scanner);
                    break;
                case 4:
                    // Registrar partida
                    associacao.registrarPartida(scanner);
                    break;
                case 5:
                    // Pagar quotas de sócio
                    associacao.pagarQuotas(scanner);
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
