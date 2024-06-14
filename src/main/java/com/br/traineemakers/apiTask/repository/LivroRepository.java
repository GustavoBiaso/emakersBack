package com.br.traineemakers.apiTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.traineemakers.apiTask.data.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
