public class Calc {
    public String calcTotalTempo(Titulo t){
        return "Nome do Título: " + t.getNome() + ", Duração: " + t.getDuracao()/60 + " horas e " + t.getDuracao()%60 + " minutos";
    }
}
