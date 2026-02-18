package com.boletim_analizer.boletim_analizer.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Component
public class OllamaClient {

    private final RestClient restClient;

    public OllamaClient(RestClient.Builder builder) {
        // O Ollama roda localmente na porta 11434
        this.restClient = builder.baseUrl("http://localhost:11434/api").build();
    }


    public String analisar(String prompt) {
        var corpo = Map.of(
                "model", "qwen2.5:7b-instruct",
                "prompt", prompt,
                "stream", false
        );

        String jsonResposta = restClient.post()
                .uri("/generate")
                .body(corpo)
                .retrieve()
                .body(String.class);

        try {
            // Extrai apenas o texto que a IA escreveu
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResposta);
            return root.get("response").asText();
        } catch (Exception e) {
            return "Erro ao ler resposta da IA: " + e.getMessage();
        }
    }
}