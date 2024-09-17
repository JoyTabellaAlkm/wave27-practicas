package ClasesAbstractasLandas.Ejercicio1.Clientes;

import ClasesAbstractasLandas.Ejercicio1.Transacciones.*;

public abstract class Cliente {

    protected ConsultaSaldo consultaSaldo = new ConsultaSaldo();
    protected Deposito deposito = new Deposito();
    protected Transferencia transferencia = new Transferencia();
    protected PagoServicios pagoServicios = new PagoServicios();
    protected RetiroEfectivo retiroEfectivo = new RetiroEfectivo();

}
