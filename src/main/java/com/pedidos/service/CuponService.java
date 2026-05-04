package com.pedidos.service;

import com.pedidos.model.Cupon;
import org.springframework.stereotype.Service;

@Service
public class CuponService {

    public double aplicar(double total, Cupon c){
        if(c == null || c.getCodigo() == null){
            return total;
        }
        if("PROMO10".equals(c.getCodigo())){
            return total * 0.9;
        } 
        if("PROMO20".equals(c.getCodigo())){
            return total * 0.8;
        }
        return total;
    }
}