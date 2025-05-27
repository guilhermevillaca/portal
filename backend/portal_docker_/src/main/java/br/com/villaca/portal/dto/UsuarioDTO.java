package br.com.villaca.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String login;
    private String senha;
    private Integer pessoaId;

}
