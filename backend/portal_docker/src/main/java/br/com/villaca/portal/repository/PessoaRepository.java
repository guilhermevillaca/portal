package br.com.villaca.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
