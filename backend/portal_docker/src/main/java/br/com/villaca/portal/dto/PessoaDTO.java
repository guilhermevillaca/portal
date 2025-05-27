package br.com.villaca.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String email;
}
