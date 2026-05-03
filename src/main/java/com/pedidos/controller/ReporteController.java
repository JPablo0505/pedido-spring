package com.pedidos.controller;

import com.pedidos.repository.PedidoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    private final PedidoRepository repo;

    public ReporteController(PedidoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/total")
    public int total(){
        return repo.listar().size();
    }
}