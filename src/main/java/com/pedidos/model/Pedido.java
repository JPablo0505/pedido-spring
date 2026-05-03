package com.pedidos.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public List<ItemPedido> items = new ArrayList<>();
    public Cliente cliente;
    public String estado;
}