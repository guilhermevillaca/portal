package br.com.villaca.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.villaca.portal.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
