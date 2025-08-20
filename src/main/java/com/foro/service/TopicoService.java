package com.foro.service;

import com.foro.model.Topico;
import com.foro.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) { this.repository = repository; }

    public List<Topico> listar() { return repository.findAll(); }
    public Optional<Topico> obtener(Long id) { return repository.findById(id); }
    public Topico guardar(Topico topico) { return repository.save(topico); }
    public void eliminar(Long id) { repository.deleteById(id); }
}
