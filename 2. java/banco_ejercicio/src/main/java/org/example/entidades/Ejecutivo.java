package org.example.entidades;

public class Ejecutivo extends Cliente {
    public Ejecutivo() {
        this.nombre = "Ejecutivo";
    }

    @Override
    public String getNombre() {
        return "cliente ejecutivo";
    }
    public void realizarDeposito(){
        Deposito deposito = new Deposito();
        deposito.TransaccionOk();
    }

    public void realizarTransferencia(){
        Transferencia transferencia = new Transferencia();
        transferencia.TransaccionOk();
    }

}
