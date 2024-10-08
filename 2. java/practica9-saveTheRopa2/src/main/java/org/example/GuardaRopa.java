package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardaRopa;
    private int idContador;


    public GuardaRopa() {
        this.guardaRopa = new HashMap<>();
        this.idContador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas){
        if(!listaPrendas.isEmpty()){
            idContador++;
            guardaRopa.put(idContador, listaPrendas);
        }
        return idContador;
    }

    public String mostrarPrendas(){
        StringBuilder sb = new StringBuilder();
        /*for(Map.Entry<Integer, List<Prenda>> valor:guardaRopa.entrySet()){
            sb.append("La clave es: "+valor.getKey()+" Las prendas son: "+valor.getValue());
        };*/
        guardaRopa.forEach((k,v) -> sb.append("Key: " + k + ": Value: " + v));
        return sb.toString();
    }

    public List<Prenda> devolverPrendas(Integer numero){
        if(guardaRopa.get(numero) != null){
            return guardaRopa.remove(numero);
        } else {
            return new ArrayList<>();
        }
    }
}
