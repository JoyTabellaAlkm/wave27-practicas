package co.mercadolibre.calorias.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Food {
    private String name;
    private int calories;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

}
