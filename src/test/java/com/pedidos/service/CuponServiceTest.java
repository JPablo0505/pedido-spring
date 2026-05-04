package com.pedidos.service;

import com.pedidos.model.Cupon;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "PROMO10, 90.0",
            "PROMO20, 80.0",
            "INVALIDO, 100.0"
    })
    void aplicar_DebeAplicarCuponCorrectamente(String codigo, double esperado) {
        CuponService service = new CuponService();
        Cupon cupon = new Cupon();
        cupon.setCodigo(codigo);
        double total = 100.0;
        double resultado = service.aplicar(total, cupon);
        assertEquals(esperado, resultado);
    }
}
