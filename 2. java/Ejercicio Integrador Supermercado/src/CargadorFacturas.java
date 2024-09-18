import java.util.ArrayList;
import java.util.List;

public class CargadorFacturas {

    public List<Factura> agregarFactura (Factura factura, List<Cliente> clientes) {
        List<Factura> facturas = new ArrayList<>();
        List<Cliente> filtrado = clientes.stream().filter(cli -> cli == factura.getCliente()).toList();
        if (filtrado.isEmpty()){
            clientes.add(factura.getCliente());
        } else {
            facturas.add(factura);
        }
        return facturas;
    }
}
