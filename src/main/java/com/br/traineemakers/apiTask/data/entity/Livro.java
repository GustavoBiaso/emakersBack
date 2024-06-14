package com.br.traineemakers.apiTask.data.entity;

import java.time.LocalDate;
import java.util.Collection;

import com.br.traineemakers.apiTask.data.dto.request.LivroRequestDTO;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "livro")
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idLivro;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "autor", nullable = false, length = 45)
    private String autor;

    @Column(name = "data_lanc")
    private LocalDate data_lanc;

    @ManyToMany(mappedBy = "livros")
    private Collection<Pessoa> pessoas;

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO){
        this.nome = livroRequestDTO.nome();
        this.autor = livroRequestDTO.autor();
        this.data_lanc = livroRequestDTO.data_lanc();
        this.pessoas = livroRequestDTO.pessoas();
    }
}
