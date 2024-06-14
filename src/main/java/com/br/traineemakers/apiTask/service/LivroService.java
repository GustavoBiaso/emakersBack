package com.br.traineemakers.apiTask.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.traineemakers.apiTask.data.dto.request.LivroRequestDTO;
import com.br.traineemakers.apiTask.data.dto.response.LivroResponseDTO;
import com.br.traineemakers.apiTask.data.entity.Livro;
import com.br.traineemakers.apiTask.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroResponseDTO> getAllLivro(){
        List<Livro> livros = livroRepository.findAll();

        return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    public LivroResponseDTO getLivroById(Long idLivro){
        Livro livro = getLivroId(idLivro);

        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO createLivro(LivroRequestDTO livroRequestDTO){
        Livro livro = new Livro(livroRequestDTO);
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public LivroResponseDTO updateLivro(Long idLivro, LivroRequestDTO livroRequestDTO){
        Livro livro = getLivroId(idLivro);

        livro.setNome(livroRequestDTO.nome());
        livro.setAutor(livroRequestDTO.autor());
        livro.setData_lanc(livroRequestDTO.data_lanc());
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    public String deleteLivro(Long idLivro){
        Livro livro = getLivroId(idLivro);

        livroRepository.delete(livro);
        return "Livro deletado com sucesso";
    }

    private Livro getLivroId(Long idLivro){
        Livro livro = livroRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Erro ao achar livro por ID"));
        return livro;
    }
}
