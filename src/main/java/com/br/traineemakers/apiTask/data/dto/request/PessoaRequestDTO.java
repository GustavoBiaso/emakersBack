package com.br.traineemakers.apiTask.data.dto.request;

import java.util.List;

import com.br.traineemakers.apiTask.data.entity.Livro;

import jakarta.validation.constraints.NotBlank;

public record PessoaRequestDTO(

    @NotBlank(message = "O nome da pessoa nao pode estar vazio")
    String nome,

    @NotBlank(message = "O cep da pessoa nao pode estar vazio")
    String cep,

    @NotBlank(message = "O email da pessoa nao pode estar vazio")
    String email,
    
    @NotBlank(message = "A senha da pessoa nao pode estar vazia")
    String senha,

    List<Livro> livros)
    {
        
    }

