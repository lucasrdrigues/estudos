package br.com.alura.screenmatch.modelos;

// Usamos o extends para definir que é uma herança de uma outra classe
public class Serie extends Titulo {
    // ATRIBUTOS - características
    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    // MÉTODOS - comportamentos
    // SETTERS
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    // GETTERS
    public int getTemporadas() {
        return temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    // OUTROS MÉTODOS

    // Vamos sobrescrever o método getDuracaoEmMinutos para que ele tenha um comportamento diferente na classe de Série
    // Nas séries precisamos somar a duração em minutos de todos os episódios de cada temporada
    @Override // Sobrescrever
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }
}
