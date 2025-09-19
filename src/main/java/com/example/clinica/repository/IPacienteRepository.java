package com.example.clinica.repository;

import com.example.clinica.Contracts.Response.ConsultaResponseDto;
import com.example.clinica.Contracts.Response.MedicoResponseDto;
import com.example.clinica.domain.model.Especialidades;
import com.example.clinica.domain.model.Medico;
import com.example.clinica.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCpfValue(String cpf);
    Optional<Paciente> findById(Long Id);


}
