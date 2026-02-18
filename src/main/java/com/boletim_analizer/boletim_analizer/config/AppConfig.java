package com.boletim_analizer.boletim_analizer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
}// isso daqui existe pq o RestClient não é um bean gerenciado pelo Spring, ou seja, ele não é criado automaticamente pelo Spring, então precisamos criar um bean para ele, para que possamos injetar ele em outras classes, como o GeminiClient.
// RestClient é a classe que o Spring usa para fazer requisições HTTP, e o RestClient.Builder é a classe que usamos para configurar o RestClient, como por exemplo, definir a URL base, os headers, etc.