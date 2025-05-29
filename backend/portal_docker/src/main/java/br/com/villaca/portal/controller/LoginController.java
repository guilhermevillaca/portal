package br.com.villaca.portal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.villaca.portal.dto.LoginDTO;
import br.com.villaca.portal.dto.LoginResponseDTO;
import br.com.villaca.portal.modelo.Usuario;
import br.com.villaca.portal.repository.UsuarioRepository;
import br.com.villaca.portal.seguranca.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    /*@PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByLoginAndSenha(
                loginDTO.getLogin(),
                loginDTO.getSenha());

        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok("Login permitido");
        } else {
            return ResponseEntity.status(401).body("Login ou senha inválidos");
        }
    }*/
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println(loginDTO.toString());
        Optional<Usuario> usuarioOpt = usuarioRepository.findByLoginAndSenha(
                loginDTO.getLogin(),
                loginDTO.getSenha()
        );

        if (usuarioOpt.isPresent()) {
            String token = jwtUtil.generateToken(usuarioOpt.get().getLogin());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }

}
