package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    // CONSTRUTOR - DEVE COINCIDIR COM O DA MAE, POIS AS CLASSES FILHAS NÃO HERDAM ELES
    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    // Se tentarmos printar o conteudo de uma lista com "System.out.println(listaDeFilmes);" ele irá retornar o modelo abaixo:
    // getClass().getName() + '@' + Integer.toHexString(hashCode())
    // -> por exemplo: br.com.alura.screenmatch.modelos.Filme@378bf509
    // Para que ele retorne o valor da lista, sobrescreva o método toString(que já vem do Java)
    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}