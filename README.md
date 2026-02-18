# Boletim Analizer - Java & GenAI

Este projeto é um analisador inteligente de desempenho acadêmico desenvolvido durante o meu último ano de Ciência da Computação na **Universidade Federal do Tocantins (UFT)**. O objetivo principal é transformar dados brutos de históricos escolares em análises qualitativas e preditivas utilizando **Java (Spring Boot 3)** e modelos de linguagem de larga escala (LLMs).

O projeto demonstra resiliência técnica e flexibilidade de arquitetura, tendo sido portado entre três provedores diferentes (**Google Gemini**, **xAI Grok**) até sua implementação final e estável com **Ollama (Qwen 2.5)** para execução 100% local.

## Foco no Desenvolvimento (Backend-First)

A aplicação foi concebida com uma abordagem **API-First**. Optei por não implementar uma interface frontend (como Angular) neste momento para priorizar a **orquestração da inteligência artificial** e a robustez da arquitetura. 

A prioridade técnica foi:
* **Abstração de LLMs**: Criar uma estrutura capaz de trocar o "cérebro" da aplicação (Client) sem afetar a lógica de negócio.
* **Privacidade e Custo**: Implementação local via Ollama para garantir que dados institucionais não saiam do ambiente controlado.
* **Padrões de Projeto**: Uso rigoroso de Injeção de Dependências e Service Layer.

## Tecnologias e Conceitos
* **Java 17 & Spring Boot 3**: Core da aplicação e gerenciamento de Beans.
* **Spring RestClient**: Interface moderna para consumo de APIs REST.
* **Ollama**: Orquestrador de LLMs locais.
* **Qwen 2.5 (7b-instruct)**: Modelo utilizado para o raciocínio clínico sobre o histórico acadêmico.
* **Jackson**: Manipulação de JSONs para extração de respostas limpas.

## Arquitetura do Sistema

A aplicação segue o padrão de camadas para garantir manutenibilidade:

1. **Controller**: Endpoint REST que recebe o mapa de disciplinas e notas.
2. **Service**: Camada de lógica que formata os dados e contextualiza o prompt.
3. **Client**: Infraestrutura de comunicação com o motor de IA (Ollama).

## Inteligência de Dados na Prática
O sistema analisa métricas como o **IRA (Índice de Rendimento Acadêmico)** e carga horária para gerar insights:

* **Evolução Acadêmica**: Identificação de curvas de aprendizado e superação de desafios em disciplinas complexas.
* **Mapeamento de Competências**: Destaque para excelência técnica em áreas como *Engenharia de Software* e *Inteligência Artificial*.
* **Veredito Preditivo**: Conselhos focados no semestre atual com base na afinidade demonstrada pelo aluno.

## Como Testar (Postman)

Com a aplicação rodando (`localhost:8080`), utilize o Postman para validar o endpoint:

### 1. Configuração da Rota
* **Método:** POST
* **URL:** http://localhost:8080/api/analise
* **Headers:** Content-Type: application/json

### 2. Corpo da Requisição (Body)
Selecione **raw** -> **JSON** e envie os dados:

```json
{
    "Algoritmos": 8.5,
    "Engenharia de Software": 10.0,
    "Inteligência Artificial": 9.5,
    "Sistemas Operacionais": 7.0
}
