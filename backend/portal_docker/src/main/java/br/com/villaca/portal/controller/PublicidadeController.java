package br.com.villaca.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.modelo.Publicidade;
import br.com.villaca.portal.service.PublicidadeService;

@RestController
@RequestMapping(value = "publicidade")
public class PublicidadeController extends GenericController<Publicidade, Integer> {

    @Autowired
    private PublicidadeService publicidadeService;

    @GetMapping("/posicao/{nome}")
    public ResponseEntity<List<Publicidade>> buscarPorPosicao(@PathVariable String nome) {
        List<Publicidade> lista = publicidadeService.listarPorPosicao(nome);
        return ResponseEntity.ok(lista);
    }

    @GetMapping
    public ResponseEntity<List<Publicidade>> listarTodas() {
        return ResponseEntity.ok(publicidadeService.listarTodas());
    }
}