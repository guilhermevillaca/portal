package br.com.villaca.portal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.villaca.portal.model.Noticia;

public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {

}
