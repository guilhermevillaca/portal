package br.com.villaca.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean destaque;
    private Integer categoriaPaiId;

}
