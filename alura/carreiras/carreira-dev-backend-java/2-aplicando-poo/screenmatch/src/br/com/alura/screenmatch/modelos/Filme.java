package br.com.alura.screenmatch.modelos;

// Usamos o extends para definir que é uma herança de uma outra classe
public class Filme extends Titulo implements Classificavel {
    // ATRIBUTOS - características
    private String diretor;


    // MÉTODOS - comportamentos


    // SETTERS
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    // GETTERS
    public String getDiretor() {
        return diretor;
    }

    // OUTROS MÉTODOS

    // Sobrescrevendo a interface Classificavel
    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2; // Precisamos fazer o casting no pegaMedia
    }
}
