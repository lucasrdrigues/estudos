import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {
        // CRIANDO UMA INSTÂNCIA(OBJETO)
        Filme meuFilme = new Filme();

        // ATRIBUINDO VALORES AS INSTÂNCIAS - SETTERS
        //meuFilme.nome = "O poderoso chefão"; // Forma ERRADA, pois o atributo é privado
        meuFilme.setNome("O poderoso chefão"); // Forma CORRETA, pois temos um setter para poder mexer nos atributos privados
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        // Imprimindo os atributos sem o Método
        //System.out.println(meuFilme); // Imprime somente a classe e o endereço do espaço da memória
        //System.out.println(meuFilme.nome); // Imprime o atributo
        //System.out.println(meuFilme.anoDeLancamento);

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        // CHAMANDO MÉTODOS
        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.pegaMedia());

        // EXIBINDO VALORES - GETTERS
        // Forma CORRETA de pegar o valor de uma atributo private - precisar criar o método de acesso na classe!
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes()); // Forma correta de pegar o total de avaliações

        // Forma ERRADA
        //System.out.println(meuFilme.somaDasAvaliacoes); // Só poderiamos fazer isso sem o modificador de acesso "private" lá a classe

        // Exemplo de algo errado a se fazer:
        // Não podemos setar(atribuir) manualmente valores aos atributos, pois NESTE caso temos o método que faz .
        //meuFilme.somaDasAvaliacoes = 10; // Só poderiamos fazer isso sem o modificador de acesso "private" lá a classe

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        // Usando a classe para calcular
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        System.out.println(calculadora.getTempoTotal());

        // Usando o filtro
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost); // Aqui estamos relacionando dois objetos.
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
    }
}
