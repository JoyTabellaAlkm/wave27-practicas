package ClasesAbstractasLandas.Ejercicio1.Clientes;

public class Cobradores extends Cliente{

    public void RealizarDeposito(){
        deposito.TransaccioNoOK();
    }

    public void RealizarTransferencia(){
        transferencia.TransaccioNoOK();
    }

    public void ConsultarSaldo(){
        consultaSaldo.TransaccionOK();
    }

    public void PagarServicios(){
        pagoServicios.TransaccionOK();
    }

    public void RetirarEfectivo(){
        retiroEfectivo.TransaccionOK();
    }

}
