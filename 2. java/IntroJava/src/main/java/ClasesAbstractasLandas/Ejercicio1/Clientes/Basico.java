package ClasesAbstractasLandas.Ejercicio1.Clientes;

public class Basico extends Cliente{

    public void RealizarDeposito(){
        deposito.TransaccionOK();
    }

    public void RealizarTransferencia(){
        transferencia.TransaccionOK();
    }

    public void ConsultarSaldo(){
        consultaSaldo.TransaccioNoOK();
    }

    public void PagarServicios(){
        pagoServicios.TransaccioNoOK();
    }

    public void RetirarEfectivo(){
        retiroEfectivo.TransaccioNoOK();
    }

}
