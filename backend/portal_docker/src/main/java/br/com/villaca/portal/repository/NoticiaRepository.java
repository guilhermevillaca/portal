package br.com.villaca.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
