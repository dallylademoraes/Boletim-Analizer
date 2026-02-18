package com.boletim_analizer.boletim_analizer.controller;

import com.boletim_analizer.boletim_analizer.model.AnaliseRetorno;
import com.boletim_analizer.boletim_analizer.service.AnaliseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/analise")
public class AnaliseController {
    private final AnaliseService service; // Injeção de dependência do serviço

    public AnaliseController(AnaliseService service){
        this.service = service; // isso é o construtor que recebe o serviço como parâmetro, acho que é inutil mas ele serve para injetar o serviço na classe, ou seja, para que a classe possa usar os métodos do serviço
    }

    @PostMapping // Anotação para mapear requisições POST para este método
    public String analisarBoletim(@RequestBody Map<String, Double> notas) {
        return service.analisar(notas);
    }
}
