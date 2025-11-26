package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in); // Criando Scanner
        String busca = ""; // Pegando o conteudo digitado
        List<Titulo> titulos = new ArrayList<>(); // Lista para adicionar os filmes

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca: "); // Imprimindo a mensagem
            busca = leitura.nextLine(); // Pegando o conteudo digitado

            // Se for igual a "sair" ele sai do loop
            if (busca.equalsIgnoreCase("sair")){
                break;
            }

            // Endereço dinâmico
            // Tratando erro de caracter inválido, trocando o espaço em branco pelo sinal de "+". Tem outras formas para resolvermos isso
            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=e80f425f";

            try {
                // Criando a request
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // Jogando o json da resposta em uma variável
                String json = response.body();
                System.out.println(json);

                // Transformando o json em uma instância de Titulo
                // Trabalhando com a lib de json da google - veja a documentação(https://github.com/google/gson)
                // CUIDADO: na classe Titulo ao inves de "titulo", nos usamos nome. Precisamos dizer isso ao Java para ele saber mapear corretamente. ]
                // MÉTODO 1 - Para fazer esse mapeamento precisamos ir na Classe e usar a notação "SerializedName" que a lib nos fornece.
                //Gson gson = new Gson(); // No método 2, se fossemos usar esta linha teriamos que colocar a primeira letra dos parametros da Classe TituloOmdd maiúscula. Para não termos que fazer isso por causa das boas práticas, vamos usar a linha abaixo se caso fossemos usar o método 2.
//                Gson gson = new GsonBuilder() // SUBI PARA CIMA
//                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                        .create();
                //Titulo meuTitulo = gson.fromJson(json, Titulo.class); // Método 1 - no metodo 1 precisamos somente desta linha
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class); // Método 2
//        System.out.println(meuTitulo);

                // Sem estar convertido
                System.out.println(meuTituloOmdb);

                //try {
                // Método 2
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido:");
                System.out.println(meuTitulo);

                // Gravando dados em um arquivo
//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuTitulo.toString());
//                escrita.close();

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
                ;
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa finalizou corretamente!");
    }
}
