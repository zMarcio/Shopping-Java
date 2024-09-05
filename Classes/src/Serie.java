public class Serie extends Titulo{

    private int temporadas;

    public Serie(String nome, int duracao, int temporadas) {
        super(nome, duracao);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }
}
