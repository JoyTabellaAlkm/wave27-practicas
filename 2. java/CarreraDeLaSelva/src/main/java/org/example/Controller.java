package org.example;

import java.util.*;

public class Controller {

    private List<Category> categories;
    private Map<Integer, CategoryCost> costMap;
    private List<Participant> people;
    private Map<Integer,Registration> inscriptions;

    public Controller() {
        this.categories =
                List.of(new Category(1, "Circuito Chico", "2 km por selva y arroyos."),
                        new Category(2, "Circuito Medio", "5 km por selva, arroyos y barro."),
                        new Category(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));
        this.costMap = Map.of(1, new CategoryCost(1300, 1500),
                2, new CategoryCost(2000, 2300),
                3, new CategoryCost(0, 2800));
        this.people = new ArrayList<>();
        this.inscriptions = new HashMap<>();
    }

    private double calculateAmount(Participant participant, int categoryId) {

        if (participant.getAge() < 18) {
            return costMap.get(categoryId).getAmountUnder18();
        }
        return costMap.get(categoryId).getAmountOver18();
    }


    public Participant create(int participantNumber, int dni, String name, String lastName, int age, long cellNumber, long emergencyNumber, String bloodType) {
        //Creo un participante
        return new Participant(participantNumber, dni, name, lastName, age, cellNumber, emergencyNumber, bloodType);
    }

    public void register(Participant participant) {
        //Agrego el participante creado a la lista people
        this.people.add(participant);
    }

    public Optional<Registration> register(int participantId, int categoryId) {

        //Valido si el participante existe en la lista de participantes
        Optional<Participant> p = this.people.stream()
                .filter(person -> participantId == person.getParticipantId())
                .findFirst();

        if (p.isEmpty()) {
            return Optional.empty();
        }

        //Valido si un menor quiere registrarse en la categoria avanzada
        if (categoryId == 3 && p.get().getAge() < 18) {
            return Optional.empty();
        }
        //Valido si el participante ya se inscribio en alguna carrera
        if (inscriptions.containsKey(participantId)) {
            return Optional.empty();
        }

        //Instancio una nueva inscripcion y la guardo
        var newReg = new Registration(new Random().nextInt(),categoryId,participantId,calculateAmount(p.get(),categoryId));
        inscriptions.put(participantId,newReg);
        return Optional.of(newReg);

    }

    public List<Participation> getParticipantsByCategory(int categoryId) {
        //Me devuelve el conjunto de entradas(Clave Valor) del mapa el formato set (entrySet)
        return inscriptions.entrySet().stream()
                // Filtro para quedarme con las inscripciones de la categoria
                .filter(entry -> categoryId == entry.getValue().getCategoryId())
                //Transformo las entradas del mapa a una participacion
                .map(entry -> {
                    Optional<Participant> p = this.people.stream()
                            .filter(person -> entry.getKey() == person.getParticipantId())
                            .findFirst();
                    return new Participation(entry.getValue(),p.get());
                })
                .toList();
    }
    //el record son clases las cuales no se pueden modificar y que te dan metodos para acceder a los campos privados de la clase, pero no los setter
    public record Participation(Registration registration, Participant participant) {}

    public void remove(int participantId) {
        inscriptions.remove(participantId);
    }

    public Map<Integer,Double> calculateTotalAmountByCategory() {
        final Map<Integer,Double> amountsByCategory = new HashMap<>();
        amountsByCategory.put(1,0.0);
        amountsByCategory.put(2,0.0);
        amountsByCategory.put(3,0.0);
        inscriptions.values().forEach(registration ->
                amountsByCategory.put(registration.getCategoryId(), amountsByCategory.get(registration.getCategoryId()) + registration.getAmountReg()));
        return amountsByCategory;
    }

    public double getTotalRace(Map<Integer,Double> sumByCategory) {
        return sumByCategory.values().stream()
                .reduce((sum,totalByCategory) -> sum + totalByCategory)
                .orElse(0.0);
    }
}

