package com.example.clinica.Contracts.Response;


import java.time.LocalDateTime;

public record ConsultaResponseDto(
         Long pacienteId,
         Long medicoId,
         LocalDateTime dataHora
) {
}
