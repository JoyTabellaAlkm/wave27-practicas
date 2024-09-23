package ej1.classes;

import ej1.interfaces.ConsultaSaldo;
import ej1.interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {

    @Override
    public boolean transaccionOk(){
        return true;
    }

    @Override
    public boolean transaccionNoOk(){
        return true;
    }
}
