public enum DescripcionCategoria {
    CIRCUITOCHICO("Circuito chico", "2 km por selva y arroyos."),
    CIRCUITOMEDIO("Circuito medio", "5 km por selva, arroyos y barro."),
    CIRCUITOAVANZADO("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

    private final String descripcion;
    private final String nombre;

    DescripcionCategoria(String nombre, String descripcion) {
        this.descripcion = descripcion;
        this.nombre=nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }
}
