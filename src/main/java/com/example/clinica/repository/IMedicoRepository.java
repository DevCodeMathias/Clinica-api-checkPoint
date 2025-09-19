package com.example.clinica.repository;

import com.example.clinica.domain.model.Especialidades;
import com.example.clinica.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findByCrm(String crm);
    List<Medico> findByEspecialidade(Especialidades especialidade);

}
