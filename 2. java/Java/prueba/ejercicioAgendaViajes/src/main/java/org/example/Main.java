package org.example;

import org.example.domain.Cliente;
import org.example.domain.Localizador;
import org.example.repository.LocalizadorRepository;
import org.example.services.DescuentosImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DescuentosImpl descuentosImpl = new DescuentosImpl();

        Cliente cliente1 = new Cliente(1,"Antonella","Basalo", "38068706","antonella.basalo@gmail.com");
        Localizador localizador1 = new Localizador(cliente1,100, List.of("Estadia","Comida","Boletos","Trasporte"));
        Localizador localizador2 = new Localizador(cliente1,100,List.of("Estadia","Estadia","Boletos","Boletos"));
        Localizador localizador3 = new Localizador(cliente1,100,List.of("Transporte"));


        descuentosImpl.agregarLocalizador(localizador1, cliente1);

        List<Localizador> localizadores1 = LocalizadorRepository.getLocalizadores();
        localizadores1.forEach(System.out::println);

        System.out.println("============");

        descuentosImpl.agregarLocalizador(localizador2, cliente1);

        List<Localizador> localizadores2 = LocalizadorRepository.getLocalizadores();
        localizadores2.forEach(System.out::println);

        System.out.println("===========");

        descuentosImpl.agregarLocalizador(localizador3, cliente1);

        List<Localizador> localizadores3 = LocalizadorRepository.getLocalizadores();
        localizadores3.forEach(System.out::println);
    }

}