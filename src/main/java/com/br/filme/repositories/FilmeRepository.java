package com.br.filme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.filme.models.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer>{

}
