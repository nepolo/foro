package com.foro.repository;

import com.foro.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UsuarioRepository {
    private final List<Usuario> usuarios = new ArrayList<>();
    private Long contador = 1L;

    public Optional<Usuario> findByEmail(String email) {
        return usuarios.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    public Usuario save(Usuario usuario) {
        usuario.setId(contador++);
        usuarios.add(usuario);
        return usuario;
    }
}
