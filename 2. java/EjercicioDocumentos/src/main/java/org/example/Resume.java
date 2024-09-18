package org.example;

import java.util.List;

public class Resume implements IPrintable {

    private String fullName;
    private int age;
    private List<String> habilities;

    public Resume(String fullName, int age, List<String> habilities) {
        this.fullName = fullName;
        this.age = age;
        this.habilities = habilities;
    }

    @Override
    public void printable() {

        System.out.println("Curriculum de: " + fullName);
        System.out.println("Edad: " + age);
        System.out.println("Habilidades:");
        habilities.stream()
                  .forEach(habilitie -> System.out.println("- " + habilitie));
    }
}
