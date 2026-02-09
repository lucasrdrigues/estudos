package br.com.alura.screenmatch.modelos;

public interface Classificavel {
    // Aqui definimos qual método e atributos que sejam comuns nas classes que irão utilizar essa interface
    //Não definimos o que o método irá fazer, pois em cada Classe será diferente. Na Classe em que ele será usado devemos usar o @Overrides e modifica-la da forma que ela irá atuar na Classe(Estamos usando no Filme)
    int getClassificacao();
}
