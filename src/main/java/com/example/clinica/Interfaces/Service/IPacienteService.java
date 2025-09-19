package com.example.clinica.Interfaces.Service;


import com.example.clinica.Contracts.Request.PacienteCreateDto;
import com.example.clinica.Contracts.Response.MedicoResponseDto;
import com.example.clinica.Contracts.Response.PacienteResponseDto;
import com.example.clinica.domain.model.Especialidades;

import java.util.List;

public interface IPacienteService {
    Long criar(PacienteCreateDto dto);

    PacienteResponseDto pegarDetalhesPaciente(Long id);

}
