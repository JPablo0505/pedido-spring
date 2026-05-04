package com.pedidos.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items = new ArrayList<>();
    private Cliente cliente;
    private String estado;

    public List<ItemPedido> getItems() {
        return items;
    }

    public void setItems(List<ItemPedido> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}