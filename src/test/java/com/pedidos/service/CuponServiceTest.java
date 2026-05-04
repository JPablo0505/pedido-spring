package com.pedidos.service;

import com.pedidos.model.Cupon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuponServiceTest {

    @Test
    void aplicar_DebeRetornarTotalOriginal_SiCuponEsNulo() {
        CuponService service = new CuponService();
        double total = 100.0;
        double resultado = service.aplicar(total, null);
        assertEquals(100.0, resultado);
    }

    @Test
    void aplicar_DebeRetornarTotalOriginal_SiCodigoEsNulo() {
        CuponService service = new CuponService();
        Cupon cupon = new Cupon();
        double total = 100.0;
        double resultado = service.aplicar(total, cupon);
        assertEquals(100.0, resultado);
    }

    @Test
    void aplicar_DebeAplicarPromo10() {
        CuponService service = new CuponService();
        Cupon cupon = new Cupon();
        cupon.setCodigo("PROMO10");
        double total = 100.0;
        double resultado = service.aplicar(total, cupon);
        assertEquals(90.0, resultado);
    }

    @Test
    void aplicar_DebeAplicarPromo20() {
        CuponService service = new CuponService();
        Cupon cupon = new Cupon();
        cupon.setCodigo("PROMO20");
        double total = 100.0;
        double resultado = service.aplicar(total, cupon);
        assertEquals(80.0, resultado);
    }

    @Test
    void aplicar_DebeRetornarTotalOriginal_SiCodigoNoEsValido() {
        CuponService service = new CuponService();
        Cupon cupon = new Cupon();
        cupon.setCodigo("INVALIDO");
        double total = 100.0;
        double resultado = service.aplicar(total, cupon);
        assertEquals(100.0, resultado);
    }
}
