package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//JsonAlias irá transformar o title em titulo, pois o json que pegamos vem a chave title. Ex: è como se estivessemos dando um apelido para o dado que queremos pegar.
@JsonIgnoreProperties(ignoreUnknown = true) // Faz com que o json pegue somente as propiedades abaixo e ignore o restante que for desconhecido, por padrao ele vem false, devemos por true
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
}
