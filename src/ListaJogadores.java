import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaJogadores {

    private List<Jogador> ListaJogadores;

    public ListaJogadores() {
        this.ListaJogadores = new ArrayList<>();
    }

    public List<Jogador> getListaJogadores() {
        return ListaJogadores;
    }

    public void setListaJogadores(List<Jogador> listaJogadores) {
        this.ListaJogadores = listaJogadores;
    }

    public void adicionarJogador(Jogador jogador) {
        this.ListaJogadores.add(jogador);
    }

    public Jogador obterJogador(int posicao) {
        if (posicao >= 0 && posicao < ListaJogadores.size()) {
            return ListaJogadores.get(posicao);
        } else {
            return null;
        }
    }

    public void exibirMelhoresJogadores() {
        Collections.sort(ListaJogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador jogador1, Jogador jogador2) {
                return Integer.compare(jogador2.getPontuacao(), jogador1.getPontuacao()); // Ordena em ordem decrescente
            }
        });
        System.out.println("Melhores jogadores:");
        for (int i = 0; i < ListaJogadores.size(); i++) {
            System.out.println("Posição " + (i + 1) + ": " + ListaJogadores.get(i).getNome() +
                    " | Pontução: " + ListaJogadores.get(i).getPontuacao());
        }
    }

    public void exibirTop10() {
        Collections.sort(ListaJogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador jogador1, Jogador jogador2) {
                return Integer.compare(jogador2.getPontuacao(), jogador1.getPontuacao()); // Ordena em ordem decrescente
            }
        });
        int limite = Math.min(ListaJogadores.size(), 10);
        System.out.println("Top 10:");
        for (int i = 0; i < limite; i++) {
            System.out.println(ListaJogadores.get(i).getNome() + " - " + (i + 1));
        }
    }

    public void iniciarListaJogadores() {
        Jogador jogador1 = new Jogador("Vini", 28, 17, 0);
        Jogador jogador2 = new Jogador("Mario", 20, 2, 0);
        Jogador jogador3 = new Jogador("Julia", 26, 3, 0);
        Jogador jogador4 = new Jogador("Leo", 19, 4, 0);
        Jogador jogador5 = new Jogador("Victor", 22, 10, 0);
        Jogador jogador6 = new Jogador("Mateus", 22, 7, 0);
        Jogador jogador7 = new Jogador("Marcos", 22, 11, 0);
        Jogador jogador8 = new Jogador("Thiago", 22, 13, 0);
        Jogador jogador9 = new Jogador("Fernando", 22, 14, 0);
        Jogador jogador10 = new Jogador("Patricia", 22, 1, 0);
        Jogador jogador11 = new Jogador("Ana", 22, 5, 0);
        Jogador jogador12 = new Jogador("João", 22, 9, 0);
        Jogador jogador13 = new Jogador("Ian", 22, 11, 0);
        Jogador jogador14 = new Jogador("Douglas", 22, 13, 0);
        Jogador jogador15 = new Jogador("Jhonata", 22, 15, 0);

        adicionarJogador(jogador1);
        adicionarJogador(jogador2);
        adicionarJogador(jogador3);
        adicionarJogador(jogador4);
        adicionarJogador(jogador5);
        adicionarJogador(jogador6);
        adicionarJogador(jogador7);
        adicionarJogador(jogador8);
        adicionarJogador(jogador9);
        adicionarJogador(jogador10);
        adicionarJogador(jogador11);
        adicionarJogador(jogador12);
        adicionarJogador(jogador13);
        adicionarJogador(jogador14);
        adicionarJogador(jogador15);
    }
}
