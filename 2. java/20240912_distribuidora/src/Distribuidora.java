public class Distribuidora {
    public static void main(String[] args) {
        Producto[] arrayProductos;
        double precioTotalPerecedero = 0;
        double precioTotalNoPerecedero = 0;
        Producto produ1 = new Perecedero("Carne", 30000, 1);
        Producto produ2 = new Perecedero("Leche", 14000, 2);
        Producto produ3 = new Perecedero("Yogurt", 10000, 3);
        Producto produ4 = new Perecedero("Manteca", 12200, 5);
        Producto produ5 = new Perecedero("Pollo", 12500, 3);
        Producto produ6 = new NoPerecedero("Atún", 2000, "Enlatados");
        Producto produ7 = new NoPerecedero("Cereal", 15000, "Cereales");
        Producto produ8 = new NoPerecedero("Arroz", 16000, "Cereales");
        Producto produ9 = new NoPerecedero("Maní", 5000, "Frutos secos");
        Producto produ10 = new NoPerecedero("Miel", 2000, "Jarabes");

        arrayProductos= new Producto[]{produ1, produ2, produ3, produ4, produ5, produ6, produ7, produ8, produ9, produ10};

        for(Producto produ : arrayProductos){
            if(produ instanceof Perecedero){
                precioTotalPerecedero = precioTotalPerecedero + produ.calcular(1);


            }else{
                precioTotalNoPerecedero = precioTotalNoPerecedero + produ.calcular(1);
            }


        }
        System.out.println("Precio total perecederos: " + precioTotalPerecedero);
        System.out.println("Precio total No perecederos: " + precioTotalNoPerecedero);
    }
}