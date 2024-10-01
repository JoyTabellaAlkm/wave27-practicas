public interface IImpresora {

    default void imprimir(){
        System.out.println("Se imprime un tipo de documento: " + getTipoDeTexto());
    }

    String getTipoDeTexto();
}
