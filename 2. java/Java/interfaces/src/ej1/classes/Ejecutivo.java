package ej1.classes;

import ej1.interfaces.Deposito;
import ej1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public boolean transaccionOk(){
        return true;
    }

    @Override
    public boolean transaccionNoOk(){
        return true;
    }
}
