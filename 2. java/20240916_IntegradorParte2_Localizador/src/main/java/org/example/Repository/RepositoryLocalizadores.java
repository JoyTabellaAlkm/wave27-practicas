package org.example.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Localizador;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RepositoryLocalizadores {
    List<Localizador> listaDeLocalizadores;

    RepositoryCliente repositoryCliente;

    public RepositoryLocalizadores() {
        this.listaDeLocalizadores = new ArrayList<>();
        this.repositoryCliente = new RepositoryCliente();
    }

    public void addListaDeLocalizadores(Localizador localizador){
        listaDeLocalizadores.add(localizador);
    }

    public long localizadoresPorCliente(Localizador localizador){
       return  listaDeLocalizadores.stream().filter(l -> l.getCliente().equals(localizador.getCliente())).count();
    }

}
