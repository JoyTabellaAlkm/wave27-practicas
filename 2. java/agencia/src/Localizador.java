import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> listaReservas;
    private double valorTotal;

    private Repositorio repositorio;

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean paqueteCompleto(List<Reserva> lista){

    }

    public void setValorTotal(int valorTotal) {
        long comprasAnteriores = repositorio.contarCliente(this.getCliente());
        double valor=0;

        if(comprasAnteriores >= 2){
            valor = (listaReservas.stream().mapToInt(Reserva::getPrecio).sum())*0.95;
        }
        if(paqueteCompleto(listaReservas)){
            valor = (listaReservas.stream().mapToInt(Reserva::getPrecio).sum())*0.90;
        }

        this.valorTotal = valor;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", listaReservas=" + listaReservas +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public Localizador(Cliente cliente, List<Reserva> listaReservas, double valorTotal) {
        this.cliente = cliente;
        this.listaReservas = listaReservas;
        this.valorTotal = valorTotal;
    }
}
