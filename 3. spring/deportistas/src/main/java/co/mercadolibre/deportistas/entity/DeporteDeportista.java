package co.mercadolibre.deportistas.entity;

import java.util.List;

public class DeporteDeportista {
    private Deportista deportista;
    private List<Deporte> deporte;

    public DeporteDeportista(Deportista deportista, List<Deporte> deporte) {
        this.deportista = deportista;
        this.deporte = deporte;
    }

    public Deportista getDeportista() {
        return deportista;
    }

    public void setDeportista(Deportista deportista) {
        this.deportista = deportista;
    }

    public List<Deporte> getDeporte() {
        return deporte;
    }

    public void setDeporte(List<Deporte> deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "DeporteDeportista{" +
                "deportista=" + deportista +
                ", deporte=" + deporte +
                '}';
    }
}
