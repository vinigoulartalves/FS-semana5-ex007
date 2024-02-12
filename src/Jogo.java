import java.util.List;
import java.util.Scanner;

public class Jogo {

    private String melhorJogador;
    private int numeroJogadas;

    public void jogar(Scanner scanner, ListaJogadores lista) {

        List<Jogador> listaJogadores = lista.getListaJogadores();
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};

        System.out.println("Informe o jogador: ");
        String nomeJogador1 = scanner.nextLine();

        Jogador jogador = procurarJogador(nomeJogador1, listaJogadores, scanner);

        while (true) {
            System.out.println(jogador.getNome() + " vs Máquina");
            System.out.println("Escolha entre Pedra, Papel ou Tesoura:");

            System.out.print("Escolha do jogador: ");
            String escolhaJogador1 = scanner.nextLine();

            String escolhaJogador2 = opcoes[(int) (Math.random() * 3)];

            System.out.println(jogador.getNome() + " escolheu: " + escolhaJogador1);
            System.out.println("Máquina escolheu: " + escolhaJogador2);

            if (escolhaJogador1.equals(escolhaJogador2)) {
                System.out.println("Empate!");
            } else if ((escolhaJogador1.equals("Pedra") && escolhaJogador2.equals("Tesoura")) ||
                    (escolhaJogador1.equals("Papel") && escolhaJogador2.equals("Pedra")) ||
                    (escolhaJogador1.equals("Tesoura") && escolhaJogador2.equals("Papel"))) {
                System.out.println(jogador.getNome() + " venceu!");
                jogador.adicionaPontos(1);
            } else {
                System.out.println("Máquina venceu!");
            }

            this.numeroJogadas = jogador.adicionaTentativa();

            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }


    }

    public void jogar(Scanner scanner, ListaJogadores lista, int num) {

        List<Jogador> listaJogadores = lista.getListaJogadores();

        System.out.println("Informe o jogador: ");
        String nomeJogador1 = scanner.nextLine();
        Jogador jogador = procurarJogador(nomeJogador1, listaJogadores, scanner);

        if (jogador == null) {
            System.out.println("Jogador não encontrado. Saindo do jogo.");
            return;
        }

        while (true) {
            int numeroCorreto = (int) (Math.random() * (num + 1));

            System.out.println("Adivinhe um número de 0 a " + num + ": ");
            int palpite = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            if (palpite == numeroCorreto) {
                System.out.println("Parabéns! Você acertou!");
                jogador.adicionaPontos(1);
            } else {
                System.out.println("Que pena! Você errou. O número correto era: " + numeroCorreto);
                jogador.perdePontos(1);
            }

            System.out.println("Pontuação atual: " + jogador.getPontuacao());
            this.numeroJogadas = jogador.adicionaTentativa();

            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public Jogador procurarJogador(String nomeJogador, List<Jogador> lista, Scanner scanner) {

        while (true) {
            for (Jogador jogador : lista) {
                if (jogador.getNome().equalsIgnoreCase(nomeJogador)) {
                    return jogador;
                }
            }

            System.out.println("Jogador não encontrado. Insira outro nome de jogador ou digite 'sair' para sair:");
            nomeJogador = scanner.nextLine().trim();

            if (nomeJogador.equalsIgnoreCase("sair")) {
                return null;
            }
        }
    }
}





