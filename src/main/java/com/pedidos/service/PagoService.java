package com.pedidos.service;

import com.pedidos.model.Pedido;
import com.pedidos.model.ItemPedido;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    public boolean pagar(Pedido p, double totalA_Pagar){
        if (p == null || p.getCliente() == null) {
            return false;
        }

        return p.getCliente().getSaldo() >= totalA_Pagar;
    }
}