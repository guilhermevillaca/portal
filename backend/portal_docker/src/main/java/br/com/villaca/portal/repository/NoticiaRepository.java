package br.com.villaca.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Categoria;
import br.com.villaca.portal.modelo.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

    List<Noticia> findAllByCategoria(Categoria categoria);

    Noticia findTopByOrderByDataPublicacaoDesc();

    Noticia findTopByCategoriaIdOrderByDataPublicacaoDesc(Integer categoriaId);

    List<Noticia> findByDestaqueTrue();

    Noticia findTopByDestaqueTrueOrderByDataPublicacaoDesc();

    List<Noticia> findByCategoriaOrderByDataPublicacaoDesc(Categoria categoria);

}
