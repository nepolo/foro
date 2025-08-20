package com.foro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    private Long id;
    private Long idUsuario;
    private String titulo;
    private String mensaje;
    private String curso;
}
