package com.example.clinica.controller;

import com.example.clinica.Contracts.Response.MedicoResponseDto;
import com.example.clinica.Contracts.Response.PacienteResponseDto;
import com.example.clinica.Interfaces.Service.IMedicoService;
import com.example.clinica.Interfaces.Service.IPacienteService;
import com.example.clinica.Contracts.Request.PacienteCreateDto;
import com.example.clinica.domain.model.Especialidades;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final IPacienteService service;
    private  final IMedicoService MedicoService;

    @Operation(summary = "Cria um paciente")
    @ApiResponse(responseCode = "201", description = "Criado")
    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody PacienteCreateDto dto) {
        Long id = service.criar(dto);
        return ResponseEntity.created(URI.create("/pacientes/" + id)).build();
    }

    @Operation(summary = "Detalhar Perfil do paciente ")
    @ApiResponse(responseCode = "200")
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> criar(@Valid @PathVariable Long id) {
        PacienteResponseDto pacient = service.pegarDetalhesPaciente(id);
        return ResponseEntity.ok(pacient);
    }

    @Operation(summary = "Procurar Especialistas")
    @ApiResponse(responseCode = "200")
    @GetMapping("/procurar")
    public ResponseEntity<List<MedicoResponseDto>> ProcurarProfissionais(@RequestParam Especialidades especialidades) {
        List<MedicoResponseDto> Doctor = MedicoService.ProcurarMedicoBySpecialist(especialidades);

        return ResponseEntity.ok(Doctor);
    }

    @GetMapping("HealthCheck")
    public String HealthCheck(){
        return  "Api is Run";
    }
}
