package com.br.traineemakers.apiTask.data.dto.response;

import com.br.traineemakers.apiTask.data.entity.Pessoa;

public record PessoaResponseDTO(
    Long id,
    String nome,
    String cep,
    String email
) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep(), pessoa.getEmail());
        }
}
