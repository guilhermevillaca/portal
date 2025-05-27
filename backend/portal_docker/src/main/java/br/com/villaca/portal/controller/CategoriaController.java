package br.com.villaca.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.modelo.Categoria;

@RestController
@RequestMapping(value = "categoria")
public class CategoriaController extends GenericController<Categoria, Integer> {

}
