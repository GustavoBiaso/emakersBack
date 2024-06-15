package com.br.traineemakers.apiTask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.traineemakers.apiTask.data.dto.request.PessoaRequestDTO;
import com.br.traineemakers.apiTask.data.dto.response.PessoaResponseDTO;
import com.br.traineemakers.apiTask.service.PessoaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
@Tag(name = "Pessoa", description = "Endpoints relacionados à área de pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<PessoaResponseDTO>> getAllPessoa(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAllPessoa());
    }

    @GetMapping(value = "/{idPessoa}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> getPessoaById(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoaById(idPessoa));
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> createPessoa(@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.createPessoa(pessoaRequestDTO));
    }

    @PutMapping(value = "/update/{idPessoa}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> updatePessoa(@Valid @PathVariable Long idPessoa, @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updatePessoa(idPessoa, pessoaRequestDTO));
    }

    @PutMapping(value = "/updateAddLivro/{idPessoa}/{idLivro}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> updateAddLivro(@PathVariable Long idPessoa, @PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updateAddLivro(idPessoa, idLivro));
    }

    @PutMapping(value = "/updateDelLivro/{idPessoa}/{idLivro}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<PessoaResponseDTO> updateDelLivro(@PathVariable Long idPessoa, @PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updateDelLivro(idPessoa, idLivro));
    }

    @DeleteMapping(value = "/delete/{idPessoa}", consumes = "application/index", produces = "application/json")
    public ResponseEntity<String> deletePessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletePessoa(idPessoa));
    }
}
