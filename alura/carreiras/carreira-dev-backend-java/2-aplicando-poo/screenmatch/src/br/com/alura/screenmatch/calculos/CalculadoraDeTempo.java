package br.com.alura.screenmatch.calculos;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

// Não usamos o setter aqui, pois é a calculadora que irá atribuir o valor e não nós !

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

//    public void inclui(Filme f){
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    // O nome dessa variável pode ser a mesma pois os argumentos que ela irá receber sao de classe diferente
//    public void inclui(Serie s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    // Ao invés de criar métodos iguais como os de cima, podemos fazer:
    // Como o Filme e Serie são filhas de Titulo, podemos usar ela como argumento
    public void inclui(Titulo titulo){
        System.out.println("Adicionando duração em minutos de " + titulo); // Mostrando o Classe@endereço da instância que será adicionada
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
