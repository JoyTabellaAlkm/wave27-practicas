public class Curriculm implements IImpresora {

    public String tipoDeNombre = "Curriculum";

    public Curriculm() {
    }

    @Override
    public String getTipoDeTexto() {
        return tipoDeNombre;
    }
}
