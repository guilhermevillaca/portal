package br.com.villaca.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.modelo.Usuario;

@RestController
@RequestMapping(value="usuario")
public class UsuarioController extends GenericController<Usuario, Integer>{

}
