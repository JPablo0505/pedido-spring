package com.pedidos.service;

import com.pedidos.model.Cliente;
import com.pedidos.model.ItemPedido;
import com.pedidos.model.Pedido;
import com.pedidos.model.Producto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PagoServiceTest {

    @Test
    void pagar_DebeRetornarFalso_SiPedidoEsNulo() {
        PagoService service = new PagoService();
        assertFalse(service.pagar(null, 100.0));
    }

    @Test
    void pagar_DebeRetornarFalso_SiClienteNulo() {
        PagoService service = new PagoService();
        Pedido p = new Pedido();
        p.setItems(new ArrayList<>());
        p.setCliente(null);
        assertFalse(service.pagar(p, 100.0));
    }

    @Test
    void pagar_DebeRetornarFalso_SiSaldoInsuficiente() {
        PagoService service = new PagoService();
        Pedido p = new Pedido();
        
        Cliente c = new Cliente();
        c.setSaldo(50.0);
        p.setCliente(c);
        
        Producto pr = new Producto();
        pr.setPrecio(100.0);
        
        ItemPedido item = new ItemPedido();
        item.setProducto(pr);
        item.setCantidad(1);
        
        p.getItems().add(item);
        
        assertFalse(service.pagar(p, 100.0));
    }

    @Test
    void pagar_DebeRetornarVerdadero_SiSaldoSuficiente() {
        PagoService service = new PagoService();
        Pedido p = new Pedido();
        
        Cliente c = new Cliente();
        c.setSaldo(150.0);
        p.setCliente(c);
        
        Producto pr = new Producto();
        pr.setPrecio(100.0);
        
        ItemPedido item = new ItemPedido();
        item.setProducto(pr);
        item.setCantidad(1);
        
        p.getItems().add(item);
        
        assertTrue(service.pagar(p, 100.0));
    }
}
