package org.example.services;

import org.example.domain.Cliente;
import org.example.domain.Localizador;

public interface Descuentos {

    int calcularPorcentajeDescuento(Localizador localizador, Cliente cliente);

    double aplicarDescuento(int descuento, double valor);

    void agregarLocalizador(Localizador localizador, Cliente cliente);
}
