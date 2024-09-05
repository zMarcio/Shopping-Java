public class Filme extends Titulo{

    private String protagonista;

    public Filme(String nome, int duracao, String protagonista) {
        super(nome, duracao);
        this.protagonista = protagonista;
    }


    public String getProtagonista() {
        return protagonista;
    }
}
