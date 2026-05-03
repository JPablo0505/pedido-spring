package com.pedidos.service;

import com.pedidos.model.Cupon;
import org.springframework.stereotype.Service;

@Service
public class CuponService {

    public double aplicar(double total, Cupon c){
        if(c != null){
            if(c.codigo != null){
                if(c.codigo.equals("PROMO10")){
                    return total * 0.9;
                } else if(c.codigo.equals("PROMO20")){
                    return total * 0.8;
                }
            }
        }
        return total;
    }
}