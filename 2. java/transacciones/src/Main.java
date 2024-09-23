public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivos = new Ejecutivos();
        Basic basic = new Basic();
        Cobradores cobradores = new Cobradores();

        ejecutivos.hacerDeposito();
        ejecutivos.hacerTransferencia();

        basic.consultarSaldo();
        basic.pagarServicios();
        basic.retirarEfectivo();

        cobradores.retirarEfectivo();
        cobradores.consultarSaldo();
    }
}