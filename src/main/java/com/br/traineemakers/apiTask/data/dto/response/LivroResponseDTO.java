package com.br.traineemakers.apiTask.data.dto.response;

import java.time.LocalDate;

import com.br.traineemakers.apiTask.data.entity.Livro;

public record LivroResponseDTO(
    Long id,
    String nome,
    String autor,
    LocalDate data_lanc
) {
    public LivroResponseDTO(Livro livro){
        this(livro.getIdLivro(), livro.getNome(), livro.getAutor(), livro.getData_lanc());
    }
}
