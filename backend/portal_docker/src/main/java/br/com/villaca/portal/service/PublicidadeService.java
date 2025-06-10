package br.com.villaca.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.villaca.portal.modelo.Publicidade;
import br.com.villaca.portal.repository.PublicidadeRepository;

@Service
public class PublicidadeService {

    @Autowired
    private PublicidadeRepository publicidadeRepository;

    public List<Publicidade> listarPorPosicao(String nomePosicao) {
        return publicidadeRepository.findByPosicao_NomeIgnoreCase(nomePosicao);
    }

    public List<Publicidade> listarTodas() {
        return publicidadeRepository.findAll();
    }
}
