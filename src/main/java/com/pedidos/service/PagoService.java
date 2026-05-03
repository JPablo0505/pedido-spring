package com.pedidos.service;

import com.pedidos.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    public boolean pagar(Pedido p){

        double total = 0;

        for(var i : p.items){
            total += i.producto.precio * i.cantidad;
        }

        if(p.cliente != null && p.cliente.saldo >= total){
            return true;
        }

        return false;
    }
}