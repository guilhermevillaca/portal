package br.com.villaca.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Publicidade;

public interface PublicidadeRepository extends JpaRepository<Publicidade, Integer> {
    List<Publicidade> findByPosicao_NomeIgnoreCase(String nome);
}
