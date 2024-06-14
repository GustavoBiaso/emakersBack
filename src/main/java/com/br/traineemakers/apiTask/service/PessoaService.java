package com.br.traineemakers.apiTask.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.traineemakers.apiTask.data.dto.request.PessoaRequestDTO;
import com.br.traineemakers.apiTask.data.dto.response.PessoaResponseDTO;
import com.br.traineemakers.apiTask.data.entity.Pessoa;
import com.br.traineemakers.apiTask.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaResponseDTO> getAllPessoa(){
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public PessoaResponseDTO getPessoaById(Long idPessoa){
        Pessoa pessoa = getPessoaId(idPessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO createPessoa(PessoaRequestDTO pessoaRequestDTO){
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO updatePessoa(Long idPessoa, PessoaRequestDTO pessoaRequestDTO){
        Pessoa pessoa = getPessoaId(idPessoa);

        pessoa.setNome(pessoaRequestDTO.nome());
        pessoa.setCep(pessoaRequestDTO.cep());
        pessoa.setEmail(pessoaRequestDTO.email());
        pessoa.setSenha(pessoaRequestDTO.senha());
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public String deletePessoa(Long idPessoa){
        Pessoa pessoa = getPessoaId(idPessoa);

        pessoaRepository.delete(pessoa);
        return "Pessoa deletada com sucesso";
    }

    private Pessoa getPessoaId(Long idPessoa){
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new RuntimeException("Erro ao achar pessoa por ID"));
        return pessoa;
    }
}
