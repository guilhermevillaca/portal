package br.com.villaca.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.modelo.Autor;

@RestController
@RequestMapping(value="autor")
public class AutorController extends GenericController<Autor, Integer> {

}
