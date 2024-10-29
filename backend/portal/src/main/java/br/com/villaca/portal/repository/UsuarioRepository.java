package br.com.villaca.portal.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.villaca.portal.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
