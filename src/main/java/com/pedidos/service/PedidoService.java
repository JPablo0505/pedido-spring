package com.pedidos.service;

import com.pedidos.model.*;
import com.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repo;
    private final PagoService pagoService;
    private final CuponService cuponService;

    public PedidoService(PedidoRepository repo, PagoService pagoService, CuponService cuponService) {
        this.repo = repo;
        this.pagoService = pagoService;
        this.cuponService = cuponService;
    }

    public Pedido procesar(Pedido p, Cupon c){
        if (p == null || p.getItems() == null || p.getItems().isEmpty() || p.getCliente() == null) {
            return p;
        }

        double total = calcularTotalItems(p.getItems());
        total = cuponService.aplicar(total, c);
        total = aplicarDescuentoVip(total, p.getCliente());

        p.setEstado(pagoService.pagar(p) ? "PAGADO" : "RECHAZADO");
        repo.guardar(p);

        return p;
    }

    private double calcularTotalItems(List<ItemPedido> items) {
        double total = 0;
        for (ItemPedido item : items) {
            if (item != null && item.getProducto() != null) {
                total += item.getProducto().getPrecio() * item.getCantidad();
            }
        }
        return total;
    }

    private double aplicarDescuentoVip(double total, Cliente cliente) {
        return "VIP".equals(cliente.getTipo()) ? total * 0.95 : total;
    }
}