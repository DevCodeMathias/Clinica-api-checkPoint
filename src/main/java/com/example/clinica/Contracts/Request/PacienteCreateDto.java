package com.example.clinica.Contracts.Request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PacienteCreateDto(
        @NotBlank
        String nome,
        @NotBlank @Pattern(regexp="\\d{11}") String cpf,
        @NotBlank @Email String email
) { }
