package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi(); // Instanciando o consumo API

    ConverteDados conversor = new ConverteDados(); // Instanciando conversor

    // https://www.omdbapi.com/?t=gilmore+girls&apikey=e80f425f
    private final String ENDERECO = "https://www.omdbapi.com/?t="; // Como estamos usando o final, ja devemos atribuir um valor na hora de declarar a variavel
    private final String API_KEY = "&apikey=e80f425f";

    public void exibeMenu(){
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();

        // Consumindo API
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        // Dados Serie
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        // Dados Temporada
        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

        // Imprimindo cada episódio da série
//        for (int i = 0; i < dados.totalTemporadas(); i++){
//            List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }
        // Escrevendo o código acima de outra forma: Para cada temporada(t), vamos usar outro forEach para pegar cada episodio(e) e imprimir
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        //temporadas.forEach(System.out::println);
        //temporadas.forEach(t -> System.out.println(t)); // É equivalente a linha de cima

//        EXEMPLO -TRABALHANDO COM STREAMS
//        List<String> nomes = Arrays.asList("Jacque", "Iasmin", "Paulo", "Rodrigo", "Nico");
//        nomes.stream()
//                .sorted()
//                .limit(3)
//                .filter(n -> n.startsWith("N"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);

//        TOP 5 MELHORES EPISODIOS
//        O flatMap serve para transformar cada elemento em múltiplos elementos, e depois achatar tudo numa única sequência.
        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()) // Usamos este para dizer queteremos uma lista  dentro de outra lista, ou seja: lista de episodios dentro da lista de temporadas
                .collect(Collectors.toList());
                // Poderia ser somente .toList(). porem este nos traria somente uma lista imutavel, caso precisemos mexer nela depois, nao conseguiriamos

        System.out.println("\n Top 5 episodios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                    // Para cada dado episodio(d) quero criar um novo episodio. Ou seja, cada episódio da temporada vira um novo objeto Episodio completo.
                    .map(d -> new Episodio(t.numero(), d)) // map transforma cada elemento do stream em outro elemento.
                ).collect(Collectors.toList());
//        EXPLICACAO:
//        map(...) retorna um stream de Episodio.
//        flatMap(...) pega: temporada 1: stream com episódios 1,2,3..., temporada 2: stream com episódios 1,2,3..., temporada 3: stream com episódios 1,2..., e junta tudo num único único stream com todos os episódios.

        episodios.forEach(System.out::println);

        // Filtrando a partir de uma data
        System.out.println("A partir de que ano voce deseja ver os episodios? ");
        var ano = leitura.nextInt();
        leitura.nextLine(); // Apos usar nextInt devemos usar o nextLine, para que nao nos atrapalhe

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        // Formatador da data
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                "Episodio: " + e.getTitulo() +
                                "Data Lançamento: " + e.getDataLancamento().format(formatador)
                ));
    }
}
