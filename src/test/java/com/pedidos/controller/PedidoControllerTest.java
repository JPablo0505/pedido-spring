package com.pedidos.controller;

import com.pedidos.model.Cupon;
import com.pedidos.model.Pedido;
import com.pedidos.service.PedidoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoControllerTest {

    @Test
    void crear_DebeProcesarPedidoConPromo10() {
        PedidoService serviceMock = mock(PedidoService.class);
        PedidoController controller = new PedidoController(serviceMock);
        
        Pedido pedidoEntrada = new Pedido();
        Pedido pedidoSalida = new Pedido();
        pedidoSalida.setEstado("PAGADO");
        
        when(serviceMock.procesar(eq(pedidoEntrada), any(Cupon.class))).thenReturn(pedidoSalida);
        
        Pedido resultado = controller.crear(pedidoEntrada);
        
        assertEquals("PAGADO", resultado.getEstado());
        verify(serviceMock).procesar(eq(pedidoEntrada), argThat(c -> "PROMO10".equals(c.getCodigo())));
    }
}
