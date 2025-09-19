package com.example.clinica.Contracts.Request;

import com.example.clinica.domain.model.Especialidades;
import jakarta.validation.constraints.NotNull;

public record MedicoCreateDto(
       @NotNull String crm,
       @NotNull String nome,
       @NotNull Especialidades especialidade
) {
}
