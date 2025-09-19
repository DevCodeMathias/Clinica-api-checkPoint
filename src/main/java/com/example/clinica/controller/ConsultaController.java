package com.example.clinica.controller;


import com.example.clinica.Contracts.Request.ConsultaCreateDto;
import com.example.clinica.Contracts.Response.ConsultaResponseDto;
import com.example.clinica.Interfaces.Service.IConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor
public class ConsultaController {


    private  final IConsultaService _service;

    @Operation(summary = "marcar consulta")
    @ApiResponse(responseCode = "201", description = "Criado")
    @PostMapping
    public ResponseEntity<ConsultaResponseDto> criar(@Valid @RequestBody ConsultaCreateDto dto) {
        ConsultaResponseDto response = _service.MarcarConsulta(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
