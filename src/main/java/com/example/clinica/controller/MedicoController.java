package com.example.clinica.controller;


import com.example.clinica.Contracts.Request.MedicoCreateDto;
import com.example.clinica.Contracts.Response.PacienteResponseDto;
import com.example.clinica.Interfaces.Service.IMedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/Medicos")
@RequiredArgsConstructor
public class MedicoController {

    private  final IMedicoService service;

    @Operation(summary = "Cria um medico")
    @ApiResponse(responseCode = "201", description = "Criado")
    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody MedicoCreateDto dto) {
        Long id = service.criar(dto);
        return ResponseEntity.created(URI.create("/medicos/" + id)).build();
    }


}
