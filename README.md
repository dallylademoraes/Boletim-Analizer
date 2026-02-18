# 📊 Boletim Analizer - Java & GenAI 🤖

Este projeto é um analisador inteligente de desempenho acadêmico desenvolvido durante o meu último ano de Ciência da Computação na **Universidade Federal do Tocantins (UFT)**. Ele utiliza **Java (Spring Boot 3)** para orquestrar chamadas a modelos de linguagem (LLMs), permitindo uma análise qualitativa e preditiva de históricos escolares.

O diferencial deste projeto foi a **flexibilidade de arquitetura** e a resiliência técnica, tendo sido testado e integrado com **Google Gemini**, **xAI Grok** e, finalmente, implementado com **Ollama (Qwen 2.5)** para execução 100% local, garantindo privacidade e custo zero.



## 🚀 Tecnologias e Conceitos
* **Java 17 & Spring Boot 3/4**: Core da aplicação e injeção de dependências.
* **Spring RestClient**: Interface moderna e fluida para consumo de APIs REST.
* **Ollama**: Orquestração de modelos de linguagem locais (LLM Agnostic).
* **Qwen 2.5 (7b-instruct)**: Modelo utilizado para o raciocínio clínico sobre os dados acadêmicos.
* **Jackson**: Manipulação e extração eficiente de dados de JSONs complexos.

## 🛠️ Arquitetura
A aplicação segue o padrão de camadas para garantir que a lógica de negócio seja independente do modelo de IA utilizado:

1.  **Controller**: Recebe o histórico acadêmico em formato JSON.
2.  **Service**: Formata os dados e constrói o prompt contextualizado para a IA.
3.  **Client (Ollama/Grok/Gemini)**: Camada de infraestrutura que conversa com a API de IA escolhida.



## 📑 Inteligência de Dados na Prática
O sistema analisa métricas como o **IRA (Índice de Rendimento Acadêmico)** e horas cursadas para gerar insights automáticos:

* **Evolução Acadêmica**: Identificação de curvas de aprendizado e superação de disciplinas de alta complexidade.
* **Mapeamento de Competências**: Destaque para excelência técnica em áreas como *Engenharia de Software* e *Inteligência Artificial*.
* **Veredito Preditivo**: Sugestões de estudo focadas para o semestre atual com base no histórico de afinidade com as disciplinas.

## ⚙️ Como Executar
1. Certifique-se de ter o **Ollama** rodando localmente:
   ```bash
   ollama run qwen2.5:7b-instruct