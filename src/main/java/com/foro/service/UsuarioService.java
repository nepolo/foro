package com.foro.service;

import com.foro.model.Usuario;
import com.foro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) { this.repository = repository; }

    public Optional<Usuario> obtenerPorEmail(String email) { return repository.findByEmail(email); }
    public Usuario guardar(Usuario usuario) { return repository.save(usuario); }
}
