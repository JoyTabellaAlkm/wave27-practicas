package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio implements IDescuentoAplicable{
    private List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    @Override
    public Float aplicarDescuento() {
        return 0f;
    }
}
