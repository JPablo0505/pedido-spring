package com.pedidos.service;

import com.pedidos.model.*;
import com.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

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

        if(p != null){
            if(p.items != null){
                if(!p.items.isEmpty()){
                    if(p.cliente != null){

                        double total = 0;

                        for(ItemPedido item : p.items){
                            if(item != null){
                                if(item.producto != null){
                                    total += item.producto.precio * item.cantidad;
                                }
                            }
                        }

                        double total2 = 0;
                        for(ItemPedido item : p.items){
                            total2 += item.producto.precio * item.cantidad;
                        }

                        total = cuponService.aplicar(total, c);

                        if(p.cliente.tipo != null && p.cliente.tipo.equals("VIP")){
                            total -= total * 0.05;
                        }

                        if(pagoService.pagar(p)){
                            p.estado = "PAGADO";
                        } else {
                            p.estado = "RECHAZADO";
                        }

                        repo.guardar(p);

                        System.out.println("Total: " + total);
                        System.out.println("Duplicado: " + total2);
                    }
                }
            }
        }

        return p;
    }
}