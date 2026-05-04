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
        c.setSaldo(10000);
        c.setTipo("VIP");

        p.setCliente(c);

        Producto pr = new Producto();
        pr.setPrecio(1000);

        ItemPedido item = new ItemPedido();
        item.setProducto(pr);
        item.setCantidad(2);

        p.getItems().add(item);

        Pedido res = service.procesar(p, null);

        assertNotNull(res);
        assertEquals("PAGADO", res.getEstado());
    }
}