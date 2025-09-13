package com.example.clinica.Interfaces.Service;
import com.example.clinica.Contracts.Request.MedicoCreateDto;
import com.example.clinica.domain.model.Medico;

public interface IMedicoService {
    Long criar(MedicoCreateDto dto);
    Medico pegarDetalhesMedicos(Long Id);
}
