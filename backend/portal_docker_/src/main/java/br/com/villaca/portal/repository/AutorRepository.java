package br.com.villaca.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
