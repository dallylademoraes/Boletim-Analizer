package com.boletim_analizer.boletim_analizer.service;

import com.boletim_analizer.boletim_analizer.client.OllamaClient;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnaliseService {

    private final OllamaClient ollamaClient;

    public AnaliseService(OllamaClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

    public String analisar(Map<String, Double> notas) {
        // 1. Transforma o mapa em texto: "PAA: 4.1, IA: 9.5..."
        String historicoFormatado = notas.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining(", "));

        // 2. Cria o comando claro para o Qwen
        String prompt = """
        Analise o seguinte histórico acadêmico de um aluno de Computação na UFT e dê um veredito curto sobre persistência e facilidades:
        %s
        """.formatted(historicoFormatado);

        // 3. Envia para o Ollama
        return ollamaClient.analisar(prompt);
    }
}
