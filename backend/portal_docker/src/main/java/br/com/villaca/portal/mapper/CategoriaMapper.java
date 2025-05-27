package br.com.villaca.portal.mapper;

import br.com.villaca.portal.dto.CategoriaDTO;
import br.com.villaca.portal.modelo.Categoria;

public interface CategoriaMapper {

    CategoriaDTO toDTO(Categoria categoria);

    Categoria toEntity(CategoriaDTO dto, Categoria categoriaPai);

}
