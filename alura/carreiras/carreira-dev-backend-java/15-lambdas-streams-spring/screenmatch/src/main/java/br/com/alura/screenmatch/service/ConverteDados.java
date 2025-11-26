package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    // Objeto do Jackson que faz conversão
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        // Leia o json e tente transformar na classe que foi passada
        // Antes o readValue estava fora de um try catch, dai ele estava dando erro, deixei o mouse em cima > more action > add try catch
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
