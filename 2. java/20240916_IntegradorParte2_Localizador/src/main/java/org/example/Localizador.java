package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Repository.RepositoryCliente;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double totalCompra;


    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.totalCompra = 0;
    }

    //total sin descuento
    public double calcularTotal(){
        totalCompra= reservas.stream().map(Reserva::getPrecio).reduce(0.0, Double::sum);
        System.out.println("imprimo total temporal");
        return totalCompra;
    }

    public void aplicarDescuentos(){


        //CASO 3
        long cantidadHotel= reservas.stream().filter(r->r.getTipo().equals(TipoDeReserva.HOTEL)).count();
        long cantidadBoletos= reservas.stream().filter(r->r.getTipo().equals(TipoDeReserva.BOLETOSDEVIAJE)).count();

        if(cantidadHotel>=2 || cantidadBoletos >=2){
            for(Reserva r: reservas){
                if(r.getTipo().equals(TipoDeReserva.BOLETOSDEVIAJE) && cantidadBoletos>=2)
                {
                    r.setPrecio(r.getPrecio()*0.95);
                    System.out.println("ENTRO EN BOLETOS +2");
                }
                else if(r.getTipo().equals(TipoDeReserva.HOTEL) && cantidadHotel>=2)
                {
                    r.setPrecio(r.getPrecio()*0.95);
                    System.out.println("ENTRO EN HOTEL +2");
                }
            }
            calcularTotal();
        }

        //CASO 2
        //Aplica 10% descuento al total
        if(isPaqueteCompleto()){
            totalCompra=  calcularTotal()*0.90;
            System.out.println("ENTRO EN PAQUETE COMPLETO");
        }
        if(!isPaqueteCompleto() && !(cantidadHotel>=2 || cantidadBoletos >=2)){
            totalCompra=  calcularTotal();
        }

    }


    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public boolean isPaqueteCompleto(){
        return  reservas.stream().anyMatch(r->r.getTipo().equals(TipoDeReserva.BOLETOSDEVIAJE))&&
                reservas.stream().anyMatch(r -> r.getTipo().equals(TipoDeReserva.HOTEL)) &&
                reservas.stream().anyMatch(r -> r.getTipo().equals(TipoDeReserva.COMIDA))&&
                reservas.stream().anyMatch(r->r.getTipo().equals(TipoDeReserva.TRANSPORTE));
    }


}
