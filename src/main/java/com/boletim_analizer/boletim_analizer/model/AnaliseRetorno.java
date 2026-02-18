package com.boletim_analizer.boletim_analizer.model;

public record AnaliseRetorno (
    String perfil,
    String pontosFortes,
    String pontosDeAtencao,
    String recomendacao
) {}

// uma record é como se eu criasse um banco cujas colunas são essas strings que eu declarei
