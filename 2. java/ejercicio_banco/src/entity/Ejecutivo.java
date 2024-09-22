package entity;

import java.util.Random;

public class Ejecutivo {
    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo()
    {
        this.deposito = new Deposito();
        this.transferencia = new Transferencia();
    }

    public void realizarDeposito()
    {
        Random rand = new Random();
        int numero = rand.nextInt(2);
        if (numero == 0)
        {
            this.deposito.transaccionOk();
        }
        else
        {
            this.deposito.transaccionNoOk();
        }
    }

    public void realizarTransferencia()
    {
        Random rand = new Random();
        int numero = rand.nextInt(2);
        if (numero == 0)
        {
            this.transferencia.transaccionOk();
        }
        else
        {
            this.transferencia.transaccionNoOk();
        }
    }
}
