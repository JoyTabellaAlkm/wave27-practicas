package ar.com.mercadolibre.dto.covid.repository;

import ar.com.mercadolibre.dto.covid.model.Person;
import ar.com.mercadolibre.dto.covid.model.Symptom;
import ar.com.mercadolibre.dto.covid.model.dto.RiskPersonDTO;

import java.util.ArrayList;
import java.util.List;

public class CovidRepository {
    private List<Symptom> symptomList = new ArrayList<>();
    private List<Person> people = new ArrayList<>();
    private List<RiskPersonDTO> riskPersonDTOS = new ArrayList<>();


    public CovidRepository(){
        symptomList.add(new Symptom("A", "Fever", 5));
        symptomList.add(new Symptom("A", "Cough", 3));
        symptomList.add(new Symptom("B", "Fatigue", 2));
        symptomList.add(new Symptom("B", "Loss of taste", 1));
        symptomList.add(new Symptom("C", "Shortness of breath", 5));

        // Adding 5 people
        people.add(new Person(1, "John", "Doe", 30));
        people.add(new Person(2, "Jane", "Doe", 25));
        people.add(new Person(3, "Jim", "Beam", 40));
        people.add(new Person(4, "Jack", "Daniels", 35));
        people.add(new Person(5, "Johnny", "Walker", 45));

        // Adding 4 people with symptoms and 1 without symptoms
        riskPersonDTOS.add(new RiskPersonDTO(people.get(0).getName(), people.get(0).getLastname(), 65, symptomList.subList(0, 2)));
        riskPersonDTOS.add(new RiskPersonDTO(people.get(1).getName(), people.get(1).getLastname(), 59, symptomList.subList(2, 4)));
        riskPersonDTOS.add(new RiskPersonDTO(people.get(2).getName(), people.get(2).getLastname(), 60, symptomList.subList(1, 3)));
        riskPersonDTOS.add(new RiskPersonDTO(people.get(3).getName(), people.get(3).getLastname(), 19, symptomList.subList(0, 1)));
        riskPersonDTOS.add(new RiskPersonDTO(people.get(4).getName(), people.get(4).getLastname(), 65, null));
    }

    public List<Symptom> getSymptomList(){
        return this.symptomList;
    }

    public Symptom getSymptomByName(String name){
        return this.symptomList.stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<RiskPersonDTO> getRiskPersonDTOS(){
        return this.riskPersonDTOS;
    }
}
