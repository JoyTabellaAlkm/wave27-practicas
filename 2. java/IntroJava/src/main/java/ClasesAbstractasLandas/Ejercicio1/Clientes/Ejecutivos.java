package ClasesAbstractasLandas.Ejercicio1.Clientes;

public class Ejecutivos extends Cliente{

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
        pagoServicios.TransaccioNoOK();
    }

    public void RetirarEfectivo(){
        retiroEfectivo.TransaccionOK();
    }
}
