package com.example.clinica.repository;

import com.example.clinica.Contracts.Response.ConsultaResponseDto;
import com.example.clinica.domain.model.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultaRepository extends JpaRepository<Consulta, Long> {


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = """
        INSERT INTO consulta (data_hora, medico_id, paciente_id, status)
        VALUES (:dataHora, :idMedico, :idPaciente, 'CRIADO')
        """, nativeQuery = true)
    int marcarConsulta(@Param("dataHora") LocalDateTime dataConsulta,
                       @Param("idMedico") Long idMedico,
                       @Param("idPaciente") Long idPaciente);
}


