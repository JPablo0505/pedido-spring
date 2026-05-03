package com.pedidos;

import com.pedidos.model.*;
import com.pedidos.service.PedidoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoServiceTest {

    @Test
    void testPedido(){

        PedidoService service = new PedidoService(null, null, null);

        Pedido p = new Pedido();
        p.cliente = new Cliente();
        p.cliente.saldo = 10000;
        p.cliente.tipo = "VIP";

        Producto pr = new Producto();
        pr.precio = 1000;

        ItemPedido item = new ItemPedido();
        item.producto = pr;
        item.cantidad = 2;

        p.items.add(item);

        Pedido res = service.procesar(p, null);

        assertNotNull(res);
    }
}