package clases;

import interfaces.ConsultaDeSaldo;
import interfaces.PagoDeServicios;
import interfaces.Retiro;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, Retiro {
    private Double saldo = Double.valueOf(200000);
    private Double valorARetirar = Double.valueOf(100000);
    private Double valorServicios = Double.valueOf(30000);


    public Basic(Double saldo, Double valorARetirar, Double valorServicios) {
        this.saldo = saldo;
        this.valorARetirar = valorARetirar;
        this.valorServicios = valorServicios;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getValorARetirar() {
        return valorARetirar;
    }

    public void setValorARetirar(Double valorARetirar) {
        this.valorARetirar = valorARetirar;
    }

    public Double getValorServicios() {
        return valorServicios;
    }

    public void setValorServicios(Double valorServicios) {
        this.valorServicios = valorServicios;
    }

    @Override
    public void consultarSaldo() {
        if (saldo != null) {
            System.out.println("La cantidad de dinero es: " + saldo);
            transaccionOk("Consulta de Saldo");
        } else {
            transaccionNoOk("Consulta de Saldo");
        }
    }

    @Override
    public void pagarServicios() {
        if (saldo >= valorServicios) {
            saldo = saldo - valorServicios;
            transaccionOk("Pago de servicios");
        } else {
            transaccionNoOk("Pago de servicios");
        }
    }

    @Override
    public void retirar() {
        if (saldo >= valorARetirar) {
            saldo = saldo - valorARetirar;
            transaccionOk("Retiro de dinero");
        } else {
            transaccionNoOk("Retiro de dinero");
        }
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La transacción: " + tipoTransaccion + " se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción: " + tipoTransaccion + " no se realizó correctamente.");

    }
}
