package com.pedidos.repository;

import com.pedidos.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    private List<Pedido> pedidos = new ArrayList<>();

    public void guardar(Pedido p){
        pedidos.add(p);
    }

    public List<Pedido> listar(){
        return pedidos;
    }
}