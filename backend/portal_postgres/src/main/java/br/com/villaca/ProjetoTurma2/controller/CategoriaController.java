package br.com.villaca.ProjetoTurma2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.ProjetoTurma2.modelo.Categoria;
import br.com.villaca.ProjetoTurma2.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "categoria")
public class CategoriaController extends GenericController<Categoria, Integer> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @RequestMapping(value = "listarDestaque", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listarDestaque(){
        return ResponseEntity.ok((List<Categoria>) categoriaRepository.findByDestaque(true));
    }
    
}
