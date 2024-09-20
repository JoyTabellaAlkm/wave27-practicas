package Clases;

import Interfaces.IConsultarSaldo;
import Interfaces.IRetiroEfectivo;
import Interfaces.ITransferencia;

public class Cobradores implements IRetiroEfectivo, IConsultarSaldo {
    public void realizarTransaccion(String name, boolean estado){
        if(estado) {
            transacionOK(name);
        }else{
            transacionNoOK(name);
        }
    }
    @Override
    public void hacerConsultaSaldo(boolean estado) {
        System.out.print("Realizando:"+ IConsultarSaldo.name+". ");
        realizarTransaccion(IConsultarSaldo.name,estado);
    }

    @Override
    public void hacerRetiroEfectivo(boolean estado) {
        System.out.print("Realizando:"+ IRetiroEfectivo.name+". ");
        realizarTransaccion(IRetiroEfectivo.name,estado);
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
