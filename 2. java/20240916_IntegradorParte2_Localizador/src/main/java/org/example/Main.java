package org.example;

import org.example.Repository.RepositoryLocalizadores;

public class Main {
    public static void main(String[] args) {
        /*
        RepositoryLocalizadores repositorio = new RepositoryLocalizadores();
        Cliente cliente1 = new Cliente(23455566);
        Localizador localizador1 = new Localizador(cliente1);
        Localizador localizador2 = new Localizador(cliente1);
        Localizador localizador3 = new Localizador(cliente1);

        //PASO1
        localizador1.addReserva(new Reserva(TipoDeReserva.COMIDA, 39559));
        localizador1.addReserva(new Reserva(TipoDeReserva.BOLETOSDEVIAJE, 3566));
        localizador1.addReserva(new Reserva(TipoDeReserva.HOTEL, 66322));
        localizador1.addReserva(new Reserva(TipoDeReserva.TRANSPORTE, 345));

        repositorio.addListaDeLocalizadores(localizador1);
        localizador1.calcularTotal();

        localizador2.addReserva(new Reserva(TipoDeReserva.COMIDA, 456));
        localizador2.addReserva(new Reserva(TipoDeReserva.BOLETOSDEVIAJE, 3566));

        repositorio.addListaDeLocalizadores(localizador2);
        localizador2.calcularTotal();


        localizador3.addReserva(new Reserva(TipoDeReserva.COMIDA, 39559));
        localizador3.addReserva(new Reserva(TipoDeReserva.HOTEL, 3));

        repositorio.addListaDeLocalizadores(localizador2);
        localizador3.calcularTotal();


        System.out.println(repositorio);
        */
        RepositoryLocalizadores repositorio = new RepositoryLocalizadores();
        Cliente cliente1 = new Cliente(23455566);
        Cliente cliente2 = new Cliente(13456667);

        Localizador localizador1 = new Localizador(cliente1);
        Localizador localizador2 = new Localizador(cliente1);
        Localizador localizador3 = new Localizador(cliente1);

        //PASO1
        localizador1.addReserva(new Reserva(TipoDeReserva.COMIDA, 39559));
        localizador1.addReserva(new Reserva(TipoDeReserva.BOLETOSDEVIAJE, 3566));
        localizador1.addReserva(new Reserva(TipoDeReserva.HOTEL, 66322));
        localizador1.addReserva(new Reserva(TipoDeReserva.TRANSPORTE, 345));

        repositorio.addListaDeLocalizadores(localizador1);
        localizador1.aplicarDescuentos();
        //aplica descuento si tuvo compras anteriores
        if(repositorio.localizadoresPorCliente(localizador1)>=3){
            localizador1.setTotalCompra(localizador1.getTotalCompra()*0.95);
            System.out.println("ENTRO EN COMPRAS ANTERIORES");
        }

        System.out.println("El total con descuento es: " + localizador1.getTotalCompra());
        System.out.println("---------");


        localizador2.addReserva(new Reserva(TipoDeReserva.BOLETOSDEVIAJE, 456));
        localizador2.addReserva(new Reserva(TipoDeReserva.BOLETOSDEVIAJE, 3566));
        localizador2.addReserva(new Reserva(TipoDeReserva.HOTEL, 2456));
        localizador2.addReserva(new Reserva(TipoDeReserva.HOTEL, 10));


        repositorio.addListaDeLocalizadores(localizador2);
        localizador2.aplicarDescuentos();
        //aplica descuento si tuvo compras anteriores
        if(repositorio.localizadoresPorCliente(localizador2)>=3){
            localizador2.setTotalCompra(localizador2.getTotalCompra()*0.95);
            System.out.println("ENTRO EN COMPRAS ANTERIORES");
        }
        System.out.println("El total con descuenton HOTEL Y BOLETOS es: " + localizador2.getTotalCompra());
        System.out.println("---------");


        //CASO 3
        localizador3.addReserva(new Reserva(TipoDeReserva.COMIDA, 39559));

        repositorio.addListaDeLocalizadores(localizador3);
        localizador3.aplicarDescuentos();
        //aplica descuento si tuvo compras anteriores
        if(repositorio.localizadoresPorCliente(localizador3)>=3){
            localizador3.setTotalCompra(localizador3.getTotalCompra()*0.95);
            System.out.println("ENTRO EN COMPRAS ANTERIORES");
        }
        System.out.println("El total con es: " + localizador3.getTotalCompra());
        System.out.println("---------");


        System.out.println(repositorio);



       }
}