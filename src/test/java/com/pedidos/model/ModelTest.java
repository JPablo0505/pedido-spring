package com.pedidos.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void testCliente() {
        Cliente c = new Cliente();
        c.setNombre("Juan");
        c.setTipo("VIP");
        c.setSaldo(100.0);
        
        assertEquals("Juan", c.getNombre());
        assertEquals("VIP", c.getTipo());
        assertEquals(100.0, c.getSaldo());
    }

    @Test
    void testCupon() {
        Cupon c = new Cupon();
        c.setCodigo("PROMO");
        assertEquals("PROMO", c.getCodigo());
    }

    @Test
    void testProducto() {
        Producto p = new Producto();
        p.setNombre("TV");
        p.setPrecio(1000.0);
        
        assertEquals("TV", p.getNombre());
        assertEquals(1000.0, p.getPrecio());
    }

    @Test
    void testItemPedido() {
        ItemPedido i = new ItemPedido();
        Producto p = new Producto();
        i.setProducto(p);
        i.setCantidad(2);
        
        assertEquals(p, i.getProducto());
        assertEquals(2, i.getCantidad());
    }

    @Test
    void testPedido() {
        Pedido p = new Pedido();
        Cliente c = new Cliente();
        List<ItemPedido> items = new ArrayList<>();
        
        p.setCliente(c);
        p.setItems(items);
        p.setEstado("PAGADO");
        
        assertEquals(c, p.getCliente());
        assertEquals(items, p.getItems());
        assertEquals("PAGADO", p.getEstado());
    }
}
