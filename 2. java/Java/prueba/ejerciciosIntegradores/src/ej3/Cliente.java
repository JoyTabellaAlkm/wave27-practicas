package ej3;

import java.util.List;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;

    public Cliente(int dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static void getAllClients(List<Cliente> clienteList){
            System.out.println(clienteList);

    }

    public static void deleteClient(List<Cliente> clienteList, String nombre){
        for(int i = 0; i< clienteList.size(); i++){
            Cliente cliente = clienteList.get(i);
            if (cliente.getNombre().equals(nombre)){
                clienteList.remove(i);
            }
        }

    }

    public static void findByDni(List<Cliente> clienteList, int dni){
        boolean banderaEncontrado = false;
        for(int i = 0; i< clienteList.size(); i++){
            Cliente cliente = clienteList.get(i);
            if (cliente.getDni() == dni){
                System.out.println("Cliente encontrado: ");
                System.out.println(cliente);
                banderaEncontrado = true;
            }
        }

        if (!banderaEncontrado){
            System.out.println("Cliente no encontrado");
        }
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getDni(){
        return this.dni;
    }

    @Override
    public String toString(){
        return "Cliente:  " + "{Dni: " +
                this.dni + ", " + "Nombre: "
                + this.nombre + ", " +
                "Apellido: " + this.apellido + "}";
    }
}
