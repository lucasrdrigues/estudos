// Pacote no qual a classe pertence
package br.com.alura.screenmatch.modelos;

// Como o código está organizado em pacotes, devemos alterar o modificador de acesso dos atributos e dos métodos de acordo com nossa necessidade, caso contrário, não conseguiríamos mexer neles. Se o código não estivesse organizado em pacotes, não precisaria desses modificadores de acesso nos métodos e nos atributos(dependendo do que voce fosse fazer precisaria, como o get para pegar valores de atributos privates).

// Como na maioria dos nossos atributos estamos usando private, devemos configurar um setter na hora de atribuir valores para eles, caso estivesse public, poderiamos mexer a vontade.

public class Titulo {
    // ATRIBUTOS - características
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes; // Sem o private nós poderíamos modificá-lo
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    // MÉTODOS - comportamentos

    // Criando os SETTERS - Alt + insert + seleciona o setter : atalho para criar os setters
    // Voce cria de acordo com a necessidade, analise quais podem ser alterados antes de criá-los
    public void setNome(String nome) {
        this.nome = nome; // o this referencia para o objeto em si
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    // Criando os GETTERS - Como o atributo é private e eu quero pegá-lo precisamos usar o "get" para criar um método acessor
    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    // OUTROS MÉTODOS
    // Método exibe ficha - devemos passar o void se caso o método não for retornar nada
    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }

    // Método que soma as notas recebidas a soma total das avaliações(atributo do objeto) - precisamos passar um argumento
    // Poderiamos adicionar condicionais de acordo com o que fossemos fazer
    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    // Método para média - não usamos o void, pois este irá retornar um valor
    public double pegaMedia(){
        // Como ele irá retornar um valor, use o "return"
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
