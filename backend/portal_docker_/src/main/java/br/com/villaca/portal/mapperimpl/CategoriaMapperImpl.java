package br.com.villaca.portal.mapperimpl;

import org.springframework.stereotype.Component;

import br.com.villaca.portal.dto.CategoriaDTO;
import br.com.villaca.portal.mapper.CategoriaMapper;
import br.com.villaca.portal.modelo.Categoria;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) return null;

        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());        
        dto.setNome(categoria.getNome());
        dto.setDestaque(categoria.getDestaque());
        dto.setDescricao(categoria.getDescricao());        
        dto.setCategoriaPaiId(
            categoria.getCategoria() != null ? categoria.getCategoria().getId() : null
        );

        return dto;
    }

    @Override
    public Categoria toEntity(CategoriaDTO dto, Categoria categoriaPai) {
        if (dto == null) return null;

        Categoria categoria = new Categoria();     
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());        
        categoria.setDestaque(dto.getDestaque());
        categoria.setCategoria(categoriaPai);

        return categoria;
    }

    
}
