package com.br.traineemakers.apiTask.data.entity;

import java.util.List;

import com.br.traineemakers.apiTask.data.dto.request.PessoaRequestDTO;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idPessoa;

    @Column(name = "nome", nullable = false, length = 80)
    private String nome;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    @Column(name = "email", nullable = false, length = 40)
    private String email;

    @Column(name = "senha", nullable = false, length = 40)
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "emprestimo",
            joinColumns = @JoinColumn(name = "idPessoa"),
            inverseJoinColumns = @JoinColumn(name = "idLivro")
    )
    private List<Livro> livros;

    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO){
        this.nome = pessoaRequestDTO.nome();
        this.cep = pessoaRequestDTO.cep();
        this.email = pessoaRequestDTO.email();
        this.senha = pessoaRequestDTO.senha();
        this.livros = pessoaRequestDTO.livros();
    }
}
