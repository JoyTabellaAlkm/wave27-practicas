package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    private Double saldo = Double.valueOf(500000);
    private Double valorATransferir = Double.valueOf(100000);
    private Double valorADepositar = Double.valueOf(50000);

    public Ejecutivo(Double saldo, Double valorATransferir, Double valorADepositar) {
        this.saldo = saldo;
        this.valorATransferir = valorATransferir;
        this.valorADepositar = valorADepositar;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double dinero) {
        this.saldo = dinero;
    }

    public Double getValorATransferir() {
        return valorATransferir;
    }

    public void setValorATransferir(Double valorATransferir) {
        this.valorATransferir = valorATransferir;
    }

    public Double getValorADepositar() {
        return valorADepositar;
    }

    public void setValorADepositar(Double valorADepositar) {
        this.valorADepositar = valorADepositar;
    }

    @Override
    public void depositar() {
if(valorADepositar != null){
    saldo= saldo + valorADepositar;
    transaccionOk("Deposito de dinero");
}else{
    transaccionNoOk("Deposito de dinero");
}
    }
    @Override
    public void transferir() {
if(valorATransferir <= saldo){
    saldo = saldo - valorATransferir;
    transaccionOk("Transferencia de dinero");
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
