package com.example.clinica.service;

import com.example.clinica.Contracts.Request.PacienteCreateDto;
import com.example.clinica.Contracts.Response.MedicoResponseDto;
import com.example.clinica.Contracts.Response.PacienteResponseDto;
import com.example.clinica.Interfaces.Service.IPacienteService;
import com.example.clinica.domain.model.Especialidades;
import com.example.clinica.domain.model.Medico;
import com.example.clinica.domain.model.Paciente;
import com.example.clinica.domain.model.vo.Cpf;
import com.example.clinica.domain.model.vo.Email;
import com.example.clinica.repository.IPacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor
public class PacienteService implements IPacienteService {

    private final IPacienteRepository repo;

    @Transactional
    public Long criar(PacienteCreateDto dto) {
        repo.findByCpfValue(dto.cpf()).ifPresent(p -> {
            throw new IllegalArgumentException("CPF já cadastrado");
        });

        Paciente paciente = Paciente.builder()
                .nome(dto.nome())
                .cpf(new Cpf(dto.cpf()))
                .email(new Email(dto.email()))
                .build();

        return repo.save(paciente).getId();
    }

    public PacienteResponseDto pegarDetalhesPaciente(Long id) {
        Paciente paciente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com id: " + id));

        return new PacienteResponseDto(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf().getValue(),
                paciente.getEmail().getValue()
        );
    }

}
