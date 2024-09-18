package clases;

import interfaces.ConsultaDeSaldo;
import interfaces.Retiro;

public class Cobrador implements Retiro, ConsultaDeSaldo {
    private Double saldo = Double.valueOf(500000);
    private Double valorARetirar = Double.valueOf(700000);

    public Cobrador(Double saldo, Double valorARetirar) {
        this.saldo = saldo;
        this.valorARetirar = valorARetirar;
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

    @Override
    public void consultarSaldo() {
        if(saldo != null){
            System.out.println("La cantidad de dinero es: " + saldo);
            transaccionOk("Consulta de Saldo");
        }else{
            transaccionNoOk("Consulta de Saldo");
        }
    }

    @Override
    public void retirar() {
        if(saldo >= valorARetirar ){
            saldo = saldo - valorARetirar;
            transaccionOk("Rettiro de dinero");
        }else{
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
