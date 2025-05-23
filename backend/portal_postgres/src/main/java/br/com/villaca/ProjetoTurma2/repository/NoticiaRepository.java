package br.com.villaca.ProjetoTurma2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.villaca.ProjetoTurma2.modelo.Categoria;
import br.com.villaca.ProjetoTurma2.modelo.Noticia;




public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {
    List<Noticia> findAllNoticiasByCategoria(Categoria categoria);
    
    Noticia findTopByOrderByDataPublicacaoDesc();

    Noticia findTopByCategoriaIdOrderByDataPublicacaoDesc(Integer categoriaId);
}
