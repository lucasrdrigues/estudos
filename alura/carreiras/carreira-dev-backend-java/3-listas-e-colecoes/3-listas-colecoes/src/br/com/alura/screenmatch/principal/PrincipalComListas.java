package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville", 2023);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        // A linha abaixo não cria outro objeto ! Ela apenas muda a referência, ou seja, podemos chegar no filme do paulo a partir de f1. A mesma coisa funciona com os casting, nós não transformamos os dados, apenas mudamos a forma de nos referenciarmos a ele. O POO em Java funciona desta maneira.
        Filme f1 = filmeDoPaulo;

//        Como queremos colocar Filmes e Series nesta lista, devemos pegar a superclasse na qual elas pertencem, se fosse só filmes, o array teria que ser somente de filmes.
        ArrayList<Titulo> lista = new ArrayList<>(); // também poderiamos usar o "var"
        //List<Titulo> lista = new LinkedList<>(); // CUIDADO! Não poderia ser "new List<>();", pois List é uma interface!
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        // Para cada item dentro da lista(nome da lista é lista) faça:
        for ( Titulo item: lista){
            System.out.println(item.getNome());
            //System.out.println(item);
            // A serie ele irá retornar com o endereco da variavel, pois não reescrevemos este método dentro da classe Serie

            // Como podemos pegar a classificacao dos filmes, sabendo que o getClassificacao tem somente nos filmes ?
            // Se tentarmos igual a linha abaixo dará erro pois "item" é tanto serie quanto filme
            //System.out.println("Classificação " + item.getClassificacao());

            // MÉTODO 1 - LEGADO, NÃO USAM MAIS
            // Precisamos fazer uma verificação usando if e instanceof e depois podemos chamar o getClassificacao:
            // Se o item for uma instância de Filme faça:
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());

            }
        }

        // Trabalhando com ordenação
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");
        System.out.println(buscaPorArtista);

        // Existem vários algoritmos que mexem com ordenação de dados, mas para quase tudo já temos algo feito, como por exemplo ordenar listas:
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação: " + buscaPorArtista);

        // ORDENANDO OBJETOS

        // PRIMEIRA FORMA:
        // Como um objeto tem vários campos, precisamos passar o critério de ordenação para o sort
        // Precisamos usar uma interface(um contrato a ser assinado que toda classe que implementá-la deverá conter o que for especificado) e implementá-la na Classe, no nosso caso vamos implementar a interface Comparable na classe Titulo(ela puxa o filme e a serie). Nesta interface, terá um método que será usado para comparacao.
        System.out.println("Lista de títulos ordenados:");
        Collections.sort(lista); // Este somente ordena, não mostra
        System.out.println(lista);

        // SEGUNDA FORMA DE ORDENAÇÃO: Não precisamos sobrescrever o método como fizemos na forma passada
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
