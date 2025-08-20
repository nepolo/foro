package com.foro.controller;

import com.foro.model.Usuario;
import com.foro.security.JwtUtils;
import com.foro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public String registrar(@RequestBody Usuario usuario) {
        usuarioService.guardar(usuario);
        return "Usuario registrado con éxito";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        return usuarioService.obtenerPorEmail(usuario.getEmail())
                .filter(u -> u.getPassword().equals(usuario.getPassword()))
                .map(u -> jwtUtils.generarToken(u.getEmail()))
                .orElse("Credenciales incorrectas");
    }
}
