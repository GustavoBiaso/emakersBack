package com.br.traineemakers.apiTask.data.dto.request;

import java.time.LocalDate;
import java.util.Collection;

import com.br.traineemakers.apiTask.data.entity.Pessoa;

import jakarta.validation.constraints.NotBlank;

public record LivroRequestDTO(
    @NotBlank(message = "O nome do livro nao pode estar vazio")
    String nome,

    @NotBlank(message = "O nome do autor do livro nao pode estar vazio")
    String autor,

    LocalDate data_lanc,

    Collection<Pessoa> pessoas
) {
    
}
