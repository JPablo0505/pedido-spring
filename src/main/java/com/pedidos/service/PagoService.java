package com.pedidos.service;

import com.pedidos.model.Pedido;
import com.pedidos.model.ItemPedido;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    public boolean pagar(Pedido p){
        if (p == null || p.getItems() == null || p.getCliente() == null) {
            return false;
        }

        double total = 0;
        for(ItemPedido i : p.getItems()){
            if (i != null && i.getProducto() != null) {
                total += i.getProducto().getPrecio() * i.getCantidad();
            }
        }

        return p.getCliente().getSaldo() >= total;
    }
}