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

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PessoaResponseDTO>> getAllPessoa(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getAllPessoa());
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> getPessoaById(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.getPessoaById(idPessoa));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PessoaResponseDTO> createPessoa(@RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.createPessoa(pessoaRequestDTO));
    }

    @PutMapping(value = "/update/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> updatePessoa(@PathVariable Long idPessoa, @RequestBody PessoaRequestDTO pessoaRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.updatePessoa(idPessoa, pessoaRequestDTO));
    }

    @DeleteMapping(value = "/delete/{idPessoa}")
    public ResponseEntity<String> deletePessoa(@PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletePessoa(idPessoa));
    }
}
