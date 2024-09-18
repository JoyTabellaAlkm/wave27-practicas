package org.example;

import org.example.domain.Cliente;
import org.example.domain.Localizador;
import org.example.repository.LocalizadorRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1,"Antonella","Basalo", "38068706","antonella.basalo@gmail.com");
        Localizador localizador1 = new Localizador(cliente1,1524.0, List.of("Estadia","Comida","Boletos","Trasporte"));
        Localizador localizador2 = new Localizador(cliente1,120568.0,List.of("Estadia","Estadia","Boletos","Boletos"));
        Localizador localizador3 = new Localizador(cliente1,4584.23,List.of("Transporte"));

        LocalizadorRepository.addLocalizador(localizador1);
        LocalizadorRepository.addLocalizador(localizador2);
        LocalizadorRepository.addLocalizador(localizador3);
        List<Localizador> localizadores = LocalizadorRepository.getLocalizadores();
        localizadores.forEach(System.out::println);
    }

}