package com.example.clinica.service;

import com.example.clinica.Contracts.Request.ConsultaCreateDto;
import com.example.clinica.Contracts.Response.ConsultaResponseDto;
import com.example.clinica.Interfaces.Service.IConsultaService;
import com.example.clinica.repository.IConsultaRepository;
import com.example.clinica.repository.IMedicoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService implements IConsultaService {

    private final IConsultaRepository repo ;

    @Transactional
    @Override
    public ConsultaResponseDto MarcarConsulta(ConsultaCreateDto consultaDto) {
        repo.marcarConsulta(consultaDto.dataHora(),consultaDto.medicoId(),consultaDto.pacienteId());

        return new ConsultaResponseDto(
                consultaDto.pacienteId(),
                consultaDto.medicoId()  ,
                consultaDto.dataHora()
        );
    }
}
