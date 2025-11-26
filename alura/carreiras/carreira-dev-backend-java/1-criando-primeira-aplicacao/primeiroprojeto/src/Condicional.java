public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 1990;
        boolean incluidoNoPlano = false;
        double notaDoFilme = 8.1;
        String tipoPlano = "normal";

        if (anoDeLancamento >= 2022){
            System.out.println("Lançamento que os clientes estão curtindo.");
        } else {
            System.out.println("Filme retrô que vale a pena assistir!");
        }

        // Para comparar string devemos usar o equals(), pois a String é um objeto. Não usamos o operador de igual(==)
        //if (incluidoNoPlano == true || tipoPlano == "plus"){
        if (incluidoNoPlano == true && tipoPlano.equals("plus")){
            System.out.println("Filme liberado.");
        } else {
            System.out.println("Deve pagar a locação.");
        }
    }
}
