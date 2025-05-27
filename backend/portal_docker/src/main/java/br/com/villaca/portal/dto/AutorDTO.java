package br.com.villaca.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {

    private Integer id;
    private String biografia;
    private Integer pessoaId;

}
