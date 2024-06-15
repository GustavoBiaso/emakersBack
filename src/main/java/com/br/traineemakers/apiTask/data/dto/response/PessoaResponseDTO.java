package com.br.traineemakers.apiTask.data.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.br.traineemakers.apiTask.data.entity.Pessoa;

public record PessoaResponseDTO(
    Long id,
    String nome,
    String cep,
    String email,
    List<LivroResponseDTO> livros
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep(), pessoa.getEmail(), pessoa.getLivros().stream().map(LivroResponseDTO::new).collect(Collectors.toList()));
    }
}
