package com.example.clinica.Interfaces.Service;

import com.example.clinica.Contracts.Request.ConsultaCreateDto;
import com.example.clinica.Contracts.Response.ConsultaResponseDto;

import java.time.LocalDateTime;

public interface IConsultaService {
   ConsultaResponseDto MarcarConsulta(ConsultaCreateDto ConsultaDto);
}
