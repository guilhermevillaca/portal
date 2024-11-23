package br.com.villaca.portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.villaca.portal.model.Categoria;
import br.com.villaca.portal.model.Noticia;


public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {
    List<Noticia> findAllNoticiasByCategoria(Categoria categoria);
    
    Noticia findTopByOrderByDataPublicacaoDesc();

    Noticia findTopByCategoriaIdOrderByDataPublicacaoDesc(Integer categoriaId);
}
