package com.example.clinica.service;

import com.example.clinica.Contracts.Request.MedicoCreateDto;
import com.example.clinica.Contracts.Response.MedicoResponseDto;
import com.example.clinica.Interfaces.Service.IMedicoService;
import com.example.clinica.domain.model.Especialidades;
import com.example.clinica.domain.model.Medico;
import com.example.clinica.repository.IMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor
public class MadicoService  implements IMedicoService {

    private final IMedicoRepository repo ;

    @Transactional
    public Long criar(MedicoCreateDto dto) {
        repo.findByCrm(dto.crm()).ifPresent(p -> {
            throw new IllegalArgumentException("CRM já cadastrado");
        });

        Medico medico = Medico.builder()
                .nome(dto.nome())
                .crm(dto.crm())
                .especialidade(dto.especialidade())
                .build();
        return repo.save(medico).getId();
    }

    @Override
    public List<MedicoResponseDto> ProcurarMedicoBySpecialist(Especialidades especialidades) {
        List<Medico> listaMedico = repo.findByEspecialidade(especialidades);

        if (listaMedico.isEmpty()) {
            throw new RuntimeException("Nenhum médico encontrado para a especialidade: ");
        }

        return  listaMedico.stream()
                .map(m-> new MedicoResponseDto(
                        m.getNome(),
                        m.getCrm(),
                        m.getEspecialidade(),
                        m.getId()
                ))
                .toList();

    }



}
