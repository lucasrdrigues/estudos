import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        // Configurando para pegar a entrada
        Scanner leitura = new Scanner(System.in);

        double mediaAvaliacao = 0;
        double nota = 0;
        int totalDeNotas = 0;

        // Loop usando o WHILE
        while (nota != -1) {
            System.out.println("Diga sua avaliação para o filme ou -1 para encerrar: ");
            nota = leitura.nextDouble();

            // Se não colocarmos o if abaixo, ele irá tentar fazer a média somando com o -1
            if (nota != -1){
                mediaAvaliacao += nota;
                totalDeNotas++;
            }
        }

        System.out.println("Média de avaliações: " + mediaAvaliacao/totalDeNotas);
    }
}
