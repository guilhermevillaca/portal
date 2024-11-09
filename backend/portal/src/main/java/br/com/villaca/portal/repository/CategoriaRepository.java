package br.com.villaca.portal.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import br.com.villaca.portal.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
    List<Categoria> findByDestaque(boolean destaque);

}
