package com.example.clinica.Contracts.Response;

import com.example.clinica.domain.model.Especialidades;

public record MedicoResponseDto(
         String crm,
         String nome,
        Especialidades especialidade,
         Long Id
) {
}
