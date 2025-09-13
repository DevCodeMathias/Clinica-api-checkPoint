package com.example.clinica.service;

import com.example.clinica.Contracts.Request.MedicoCreateDto;
import com.example.clinica.Interfaces.Service.IMedicoService;
import com.example.clinica.domain.model.Medico;
import com.example.clinica.repository.IMedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .build();
        return repo.save(medico).getId();
    }
}
