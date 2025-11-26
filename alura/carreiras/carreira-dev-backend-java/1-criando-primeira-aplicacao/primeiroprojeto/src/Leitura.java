import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        // Configurando para pegar a entrada
        Scanner leitura = new Scanner(System.in);

        // Exibindo mensagem
        System.out.println("Digite seu filme favorito: ");
        // Declarando variável para receber a entrada
        String filme = leitura.nextLine();

        // Exibindo mensagem
        System.out.println("Qual o ano de lançamento? ");
        // Declarando variável para receber a entrada
        // Declarando variável para a entrada do dado, preste atenção no tipo de entrada que queremos receber!
        int anoDeLancamento = leitura.nextInt();

        // Exibindo mensagem
        System.out.println("Diga sua avaliação para o filme: ");
        // Declarando variável para receber a entrada
        // CUIDADO: Na hora de receber uma entrada, deve-se colocar vírgula ao inves de ponto para valores decimais
        double avaliacao = leitura.nextDouble();

        // Exibindo as respostas das entradas
        System.out.println(filme);
        System.out.println(anoDeLancamento);
        System.out.println(avaliacao);
    }
}
