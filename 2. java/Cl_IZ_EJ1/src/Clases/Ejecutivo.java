package Clases;

import Interfaces.IConsultarSaldo;
import Interfaces.IDeposito;
import Interfaces.ITransaccion;
import Interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {
    public void realizarTransaccion(String name, boolean estado){
        if(estado) {
            transacionOK(name);
        }else{
            transacionNoOK(name);
        }
    }
    @Override
    public void hacerDeposito(boolean estado) {
        System.out.print("Realizando:"+IDeposito.name+". ");
        realizarTransaccion(IDeposito.name,estado);
    }

    @Override
    public void hacerTransferencia(boolean estado) {
        System.out.print("Realizando:"+ITransferencia.name+". ");
        realizarTransaccion(ITransferencia.name,estado);
    }

    @Override
    public void transacionOK(String tipo) {
        System.out.println("Se realizo el " + tipo+" correctamente");
    }

    @Override
    public void transacionNoOK(String tipo) {
        System.out.println("No se realizo el " + tipo+" correctamente");
    }
}
