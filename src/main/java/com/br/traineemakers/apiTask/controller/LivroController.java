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

import com.br.traineemakers.apiTask.data.dto.request.LivroRequestDTO;
import com.br.traineemakers.apiTask.data.dto.response.LivroResponseDTO;
import com.br.traineemakers.apiTask.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
     @Autowired
    private LivroService livroService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LivroResponseDTO>> getAllLivro(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getAllLivro());
    }

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroResponseDTO> getLivroById(@PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.getLivroById(idLivro));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LivroResponseDTO> createLivro(@RequestBody LivroRequestDTO livroRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.createLivro(livroRequestDTO));
    }

    @PutMapping(value = "/update/{idLivro}")
    public ResponseEntity<LivroResponseDTO> updateLivro(@PathVariable Long idLivro, @RequestBody LivroRequestDTO livroRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.updateLivro(idLivro, livroRequestDTO));
    }

    @DeleteMapping(value = "/delete/{idLivro}")
    public ResponseEntity<String> deleteLivro(@PathVariable Long idLivro){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteLivro(idLivro));
    }
}
