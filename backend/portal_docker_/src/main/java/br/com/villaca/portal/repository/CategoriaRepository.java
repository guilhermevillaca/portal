package br.com.villaca.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
