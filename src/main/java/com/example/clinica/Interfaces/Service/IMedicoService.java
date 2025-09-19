package com.example.clinica.Interfaces.Service;
import com.example.clinica.Contracts.Request.MedicoCreateDto;
import com.example.clinica.Contracts.Response.MedicoResponseDto;
import com.example.clinica.domain.model.Especialidades;
import com.example.clinica.domain.model.Medico;

import java.util.List;

public interface IMedicoService {
    Long criar(MedicoCreateDto dto);
    List<MedicoResponseDto> ProcurarMedicoBySpecialist(Especialidades Especialidades);


}
