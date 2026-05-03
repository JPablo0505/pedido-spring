package com.pedidos;

import com.pedidos.model.*;
import com.pedidos.repository.PedidoRepository;
import com.pedidos.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoServiceTest {

    @Test
    void testPedido(){
        PedidoRepository repo = new PedidoRepository();
        PagoService pagoService = new PagoService();
        CuponService cuponService = new CuponService();

        PedidoService service = new PedidoService(repo, pagoService, cuponService);

        Pedido p = new Pedido();

        Cliente c = new Cliente();
        c.saldo = 10000;
        c.tipo = "VIP";

        p.cliente = c;

        Producto pr = new Producto();
        pr.precio = 1000;

        ItemPedido item = new ItemPedido();
        item.producto = pr;
        item.cantidad = 2;

        p.items.add(item);

        Pedido res = service.procesar(p, null);

        assertNotNull(res);
        assertEquals("PAGADO", res.estado);
    }
}