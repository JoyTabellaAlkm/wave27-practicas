package org.example.services;

import org.example.domain.Cliente;
import org.example.domain.Localizador;
import org.example.repository.LocalizadorRepository;

import java.util.List;

public class DescuentosImpl implements Descuentos {

    @Override
    public void agregarLocalizador(Localizador localizador, Cliente cliente) {

        int porcentajeDescuento = calcularPorcentajeDescuento(localizador, cliente);
        double precioDescontado = aplicarDescuento(porcentajeDescuento, localizador.getTotal());

        localizador.setTotal(precioDescontado);

        LocalizadorRepository.addLocalizador(localizador);
    }

    @Override
    public int calcularPorcentajeDescuento(Localizador localizador, Cliente cliente) {

        List<Localizador> localizadores =  LocalizadorRepository.localizadoresCliente(cliente);

        int descuento = 0;

        if(localizadores.size() >= 2) descuento += 5;

        //Terminar lógica

        return descuento;
    }

    @Override
    public double aplicarDescuento(int porcentajeDescuento, double total) {
        return total - total * porcentajeDescuento / 100;
    }

}
