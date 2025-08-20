package com.foro.controller;

import com.foro.model.Topico;
import com.foro.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @GetMapping
    public List<Topico> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Topico obtener(@PathVariable Long id) {
        return service.obtener(id).orElse(null);
    }

    @PostMapping
    public Topico crear(@RequestBody Topico topico) {
        return service.guardar(topico);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "Tópico eliminado con éxito";
    }
}

