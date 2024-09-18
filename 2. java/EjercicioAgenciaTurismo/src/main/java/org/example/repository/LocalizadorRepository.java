package org.example.repository;

import org.example.domain.Cliente;
import org.example.domain.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {

    private static List<Localizador> localizadores = new ArrayList<>();

    public static void addLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public static void removeLocalizador(Localizador localizador) {
        if(localizadores.remove(localizador)) {
            System.out.println("Se pudo eliminar el localizador");
        } else {
            System.out.println("No se pudo eliminar el localizador");
        }
    }

    public static List<Localizador> getLocalizadores() {
        return localizadores;
    }


}
