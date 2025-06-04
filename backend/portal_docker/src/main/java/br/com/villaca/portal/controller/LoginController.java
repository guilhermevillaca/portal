package br.com.villaca.portal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.dto.LoginDTO;
import br.com.villaca.portal.modelo.Usuario;
import br.com.villaca.portal.repository.UsuarioRepository;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByLoginAndSenha(
                loginDTO.getLogin(),
                loginDTO.getSenha());

        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok("Login permitido");
        } else {
            return ResponseEntity.status(401).body("Login ou senha inválidos");
        }
    }
 

}
