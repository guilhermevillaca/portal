package br.com.villaca.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.modelo.Posicao;

@RestController
@RequestMapping(value = "posicao")
public class PosicaoController extends GenericController<Posicao, Integer> {

}
