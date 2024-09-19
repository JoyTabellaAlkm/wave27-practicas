package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteService {
    ClienteRepositorio repo;

    public void mostrarLocalizadoresVendidos(){
        Integer total =  repo.listaLocalizadores.size();
        System.out.println("El total de localizadores vendidos fue: " + total);
    }

    public void mostrarReservasTotales(){
        Integer total = repo.listaLocalizadores.stream()
                .mapToInt(reserva -> reserva.getListaReserva().size())
                .sum();
        System.out.println("La cantidad total de reservas fue: " + total);
    }

    public void calcularTotal(){
        Double total = repo.listaLocalizadores.stream()
                .mapToDouble(Localizador::getTotal)
                .sum();
        System.out.println("La cantidad total fue: " + total);
    }

    public void calcularPromedioVenta(){
        Double total = repo.listaLocalizadores.stream()
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0);
        System.out.println("La cantidad total fue: " + total);
    }
}
