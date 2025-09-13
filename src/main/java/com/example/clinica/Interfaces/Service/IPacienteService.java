package com.example.clinica.Interfaces.Service;


import com.example.clinica.Contracts.Request.PacienteCreateDto;
import com.example.clinica.Contracts.Response.PacienteResponseDto;

public interface IPacienteService {
    Long criar(PacienteCreateDto dto);

    PacienteResponseDto pegarDetalhesPaciente(Long id);
}
