package ej1.classes;

import ej1.interfaces.ConsultaSaldo;
import ej1.interfaces.PagoServicio;
import ej1.interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {

    @Override
    public boolean transaccionOk(){
        return true;
    }

    @Override
    public boolean transaccionNoOk(){
        return true;
    }




}
