package com.pedidos.controller;

import com.pedidos.model.*;
import com.pedidos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido){

        Cupon c = new Cupon();
        c.setCodigo("PROMO10");

        return service.procesar(pedido, c);
    }
}