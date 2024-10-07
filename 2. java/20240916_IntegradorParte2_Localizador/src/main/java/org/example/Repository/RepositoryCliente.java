package org.example.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Cliente;
import org.example.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class RepositoryCliente {
    private List<Cliente> clienteList;


    public RepositoryCliente() {
        this.clienteList = new ArrayList<>();
    }




}
