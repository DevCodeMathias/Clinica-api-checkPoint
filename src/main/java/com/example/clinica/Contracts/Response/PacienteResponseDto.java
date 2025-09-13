package com.example.clinica.Contracts.Response;

public record PacienteResponseDto(
        Long id,
        String nome,
        String cpf,
        String email
) {
}
