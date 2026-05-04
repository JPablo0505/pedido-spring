package com.pedidos.service;

import com.pedidos.model.*;
import com.pedidos.repository.PedidoRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    @Test
    void procesar_DebeAsignarEstadoRechazado_SiPagoServiceRetornaFalse() {
        // Arrange
        PedidoRepository repo = mock(PedidoRepository.class);
        PagoService pagoService = mock(PagoService.class);
        CuponService cuponService = mock(CuponService.class);

        PedidoService service = new PedidoService(repo, pagoService, cuponService);

        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        cliente.setTipo("REGULAR");
        cliente.setSaldo(100);
        pedido.setCliente(cliente);

        ItemPedido item = new ItemPedido();
        Producto producto = new Producto();
        producto.setPrecio(10);
        item.setProducto(producto);
        item.setCantidad(1);

        pedido.getItems().add(item);

        when(pagoService.pagar(pedido)).thenReturn(false);

        // Act
        Pedido resultado = service.procesar(pedido, null);

        // Assert
        assertEquals("RECHAZADO", resultado.getEstado());
        verify(repo, times(1)).guardar(pedido);
    }

    @Test
    void procesar_DebeRetornarPedidoOriginal_SiListaItemsVacia() {
        // Arrange
        PedidoRepository repo = mock(PedidoRepository.class);
        PagoService pagoService = mock(PagoService.class);
        CuponService cuponService = mock(CuponService.class);
        PedidoService service = new PedidoService(repo, pagoService, cuponService);

        Pedido pedidoVacio = new Pedido();
        pedidoVacio.setItems(new ArrayList<>());

        // Act
        Pedido resultado = service.procesar(pedidoVacio, null);

        // Assert
        assertEquals(pedidoVacio, resultado);
        verifyNoInteractions(repo, pagoService, cuponService);
    }
}
