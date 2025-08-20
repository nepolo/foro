package com.foro.repository;

import com.foro.model.Topico;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TopicoRepository {
    private final List<Topico> topicos = new ArrayList<>();
    private Long contador = 1L;

    public List<Topico> findAll() { return topicos; }

    public Optional<Topico> findById(Long id) {
        return topicos.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Topico save(Topico topico) {
        topico.setId(contador++);
        topicos.add(topico);
        return topico;
    }

    public void deleteById(Long id) {
        topicos.removeIf(t -> t.getId().equals(id));
    }
}
