package br.com.villaca.ProjetoTurma2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.villaca.ProjetoTurma2.modelo.Categoria;



public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
    List<Categoria> findByDestaque(boolean destaque);

}
