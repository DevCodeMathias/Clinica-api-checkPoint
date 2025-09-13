package com.example.clinica.Contracts.Request;

import jakarta.validation.constraints.NotNull;

public record MedicoCreateDto(
       @NotNull String crm,
       @NotNull String nome
) {
}
