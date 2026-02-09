public class Main {
    public static void main(String[] args) {
        System.out.println("Esse é o Screen Match");
        System.out.println("Filme: Top Gun: Maverick");

        // Ano do lançamento
        int anoDoLancamento = 2022;
        System.out.println("Ano de Lançamento: " + anoDoLancamento);

        // Nota de filme
        boolean incluidoNoPlano = true;

        // Incluido no plano ?
        double notaDoFilme = 8.1; // Temos o float, mas o double é o mais comum.

        // Média da nota
        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println(media);

        // Sinopse
        String sinopse;
        // Formatando com TextBlocks
        sinopse = """
                 Filme Top Gun
                 Filme de aventura com galã dos anos 80
                 Muito bom!
                 Ano de Lançamento
                 """ + anoDoLancamento;
        System.out.println(sinopse);

        // Classificação
        int classificacao = (int) (media / 2);
        System.out.println(classificacao);
    }
}
