public class Circuito {
    final Integer ID_CIRCUITO_CHICO = 0;
    final Integer ID_CIRCUITO_MEDIO = 1;
    final Integer ID_CIRCUITO_AVANZADO = 2;

    final Integer PRECIO_MENOR_CIRCUITO_CHICO = 1300;
    final Integer PRECIO_MAYOR_CIRCUITO_CHICO = 1500;
    final Integer PRECIO_MENOR_CIRCUITO_MEDIO = 2000;
    final Integer PRECIO_MAYOR_CIRCUITO_MEDIO = 2300;
    final Integer PRECIO_CIRCUITO_AVANZADO = 2800;

    private String nombre;
    private Integer idCircuito;
    private String descripcion;
    private Integer importeGeneradoTotal;
    private Integer precioDelCircuito;

    public Circuito(String nombre, Integer idCircuito, String descripcion) {
        this.nombre = nombre;
        this.idCircuito = idCircuito;
        this.descripcion = descripcion;
    }

    public void recaudacionTotal(Integer precioSegunCircuito) {
        this.importeGeneradoTotal += precioSegunCircuito;
    }

    public Integer precioSegunCircuito(Participante participante, Integer circuitoElegido) {
        switch (circuitoElegido) {
            case 0:
                if (participante.esMayorDeEdad()) {
                    this.precioDelCircuito += PRECIO_MAYOR_CIRCUITO_CHICO;
                }else {
                    this.precioDelCircuito += PRECIO_MENOR_CIRCUITO_CHICO;
                }
                break;
            case 1:
                if (participante.esMayorDeEdad()) {
                    this.precioDelCircuito += PRECIO_MAYOR_CIRCUITO_MEDIO;
                }else {
                    this.precioDelCircuito += PRECIO_MENOR_CIRCUITO_MEDIO;
                }
                break;
            default:
                this.precioDelCircuito += PRECIO_CIRCUITO_AVANZADO;
        }
        this.recaudacionTotal(this.precioDelCircuito);
        return this.precioDelCircuito;
    }

    public String toString() {
        return "Tipo de Circuito: " + nombre +  "\nDescripción: " + descripcion;
    }
}