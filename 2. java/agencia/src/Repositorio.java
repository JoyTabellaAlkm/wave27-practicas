import java.util.List;

public class Repositorio {

    private List<Localizador> listaLocalizadores;

    public Repositorio(List<Localizador> listaLocalizadores) {
        this.listaLocalizadores = listaLocalizadores;
    }

    public List<Localizador> getListaLocalizadores() {
        return listaLocalizadores;
    }

    public void setListaLocalizadores(List<Localizador> listaLocalizadores) {
        this.listaLocalizadores = listaLocalizadores;
    }

    public long contarCliente(Cliente cliente){
        return listaLocalizadores.stream().filter(p -> p.getCliente().getDni() == cliente.getDni()).count();
    }

    public void addLocalizador(Localizador localizador){
        listaLocalizadores.add(localizador);
    }

    public void localizadorCliente(Cliente cliente){
        listaLocalizadores.stream().filter(p->p.getCliente().getDni() == cliente.getDni()).forEach(System.out::println);
    }


}
