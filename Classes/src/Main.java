public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme("Titanic", 195, "Leonardo DiCaprio");

        Calc test = new Calc();

        System.out.println(test.calcTotalTempo(filme));

    }
}