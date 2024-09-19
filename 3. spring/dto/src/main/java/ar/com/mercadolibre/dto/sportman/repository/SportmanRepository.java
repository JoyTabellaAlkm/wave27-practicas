package ar.com.mercadolibre.dto.sportman.repository;

import ar.com.mercadolibre.dto.sportman.model.Sport;
import ar.com.mercadolibre.dto.sportman.model.SportmanDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SportmanRepository {
    private List<Sport> sportList = new ArrayList<>();
    private List<SportmanDTO> sportmanDTOS = new ArrayList<>();

    public SportmanRepository() {
        sportList.add(new Sport("Futbol", "A"));
        sportList.add(new Sport("Basketball", "B"));
        sportList.add(new Sport("Tennis", "C"));
        sportList.add(new Sport("Natacion", "B"));
        sportList.add(new Sport("Running", "C"));

        sportmanDTOS.add(new SportmanDTO("Juan", "Perez", sportList.get(0).getName()));
        sportmanDTOS.add(new SportmanDTO("Maria", "Gomez", sportList.get(0).getName()));
        sportmanDTOS.add(new SportmanDTO("Carlos", "Lopez", sportList.get(3).getName()));
        sportmanDTOS.add(new SportmanDTO("Ana", "Martinez", sportList.get(2).getName()));
        sportmanDTOS.add(new SportmanDTO("Luis", "Garcia", sportList.get(1).getName()));
    }

    public List<Sport> getSportList() {
        return sportList;
    }

    public Sport getSport(String name){
        return this.sportList.stream()
                .filter(sport1 -> sport1.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<SportmanDTO> getSportmanDTOS(){
        return sportmanDTOS;
    }



}
