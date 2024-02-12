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


