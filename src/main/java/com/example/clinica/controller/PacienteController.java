package com.example.clinica.controller;

import com.example.clinica.Contracts.Response.PacienteResponseDto;
import com.example.clinica.Interfaces.Service.IPacienteService;
import com.example.clinica.Contracts.Request.PacienteCreateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final IPacienteService service;

    @Operation(summary = "Cria um paciente")
    @ApiResponse(responseCode = "201", description = "Criado")
    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody PacienteCreateDto dto) {
        Long id = service.criar(dto);
        return ResponseEntity.created(URI.create("/pacientes/" + id)).build();
    }

    @Operation(summary = "Detalhar paciente ")
    @ApiResponse(responseCode = "200")
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> criar(@Valid @PathVariable Long id) {
        PacienteResponseDto pacient = service.pegarDetalhesPaciente(id);
        return ResponseEntity.ok(pacient);
    }

    @GetMapping("HealthCheck")
    public String HealthCheck(){
        return  "Api is Run";
    }
}
