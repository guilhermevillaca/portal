package br.com.villaca.portal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.villaca.portal.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

}