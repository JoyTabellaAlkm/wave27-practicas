package org.example;

public class ClienteService {

    private ClienteRepositorio repo;

    public ClienteService(ClienteRepositorio repo){
        this.repo = repo;
    }

    public void cantidadLocalizadoresVendidos() {
        System.out.println("Cantidad de localizadores vendidos: " + repo.getLocalizadores().size());
    }

    public void cantidadReservasVendidas(){
        Integer reservasTotales =  repo.getLocalizadores().stream()
                .mapToInt(localizador -> localizador.getServicio().size())
                .sum();

        System.out.println("Cantidad de reservas totales: " + reservasTotales);
    }

    public void totalDeVentas(){
        Double ventasTotales = repo.getLocalizadores().stream()
                .mapToDouble(Localizador::getTotal)
                .sum();

        System.out.println("Total de ventas: " + ventasTotales);
    }

    public void promedioVentas(){
        Double promedioVentas = repo.getLocalizadores().stream()
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0.0);

        System.out.println("Promedio de ventas: " + promedioVentas);
    }
}
