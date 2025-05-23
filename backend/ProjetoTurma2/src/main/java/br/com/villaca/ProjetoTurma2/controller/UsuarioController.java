package br.com.villaca.ProjetoTurma2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.ProjetoTurma2.modelo.Usuario;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController extends GenericController<Usuario, Integer>{

}
