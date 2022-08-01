package com.micael.attornatus.pessoa.repository;

import com.micael.attornatus.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}