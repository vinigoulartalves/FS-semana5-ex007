import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ListaJogadores lista = new ListaJogadores();
        Jogo jogo = new Jogo();

        lista.iniciarListaJogadores();


        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("+------- BEM VINDO -------+");
            System.out.println("| 1 - Cadastrar jogador   |");
            System.out.println("| 2 - Exibir jogadores    |");
            System.out.println("| 3 - Exibir top10        |");
            System.out.println("| 4 - Jogar               |");
            System.out.println("+-------------------------+");
            System.out.println("| 0 - Sair                |");
            System.out.println("+-------------------------+");
            System.out.println("Informe um número: ");
            int entrada = scanner.nextInt();
            scanner.nextLine();

            switch (entrada) {

                case 1:
                    cadastrarNovoJogador(scanner, lista);
                    break;

                case 2:
                    lista.exibirMelhoresJogadores();
                    break;

                case 3:
                    lista.exibirTop10();
                    break;

                case 4:
                    jogo.jogar(scanner, lista);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    System.exit(1);
            }
        } while (true);
    }

    public static void cadastrarNovoJogador(Scanner scanner, ListaJogadores lista) {
        while (true) {
            System.out.println("CADASTRAR JOGADOR");

            System.out.print("Nome: ");
            String nome = scanner.next();

            boolean nomeExistente = false;
            for (Jogador jogador : lista.getListaJogadores()) {
                if (jogador.getNome().equals(nome)) {
                    nomeExistente = true;
                    break;
                }
            }

            if (nomeExistente) {
                System.out.println("Nome inválido. Este nome já está na lista de jogadores.");
            } else {
                System.out.print("Idade: ");
                int idade = scanner.nextInt();

                Jogador jogador = new Jogador(nome, idade);
                lista.adicionarJogador(jogador);
                break; // Sai do loop infinito quando o jogador é adicionado com sucesso
            }
        }
    }
}
