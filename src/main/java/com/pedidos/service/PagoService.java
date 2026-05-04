package com.pedidos.service;

import com.pedidos.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    public boolean pagar(Pedido p, double totalAPagar){
        if (p == null || p.getCliente() == null) {
            return false;
        }

        return p.getCliente().getSaldo() >= totalAPagar;
    }
}