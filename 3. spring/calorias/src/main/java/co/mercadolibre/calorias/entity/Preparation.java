package co.mercadolibre.calorias.entity;

import java.util.List;

public class Preparation {
    private String name;
    private List<Food> foodList;
    private int totalCalories;

    @Override
    public String toString() {
        return "Preparation{" +
                "name='" + name + '\'' +
                ", foodList=" + foodList +
                ", totalCalories=" + totalCalories +
                '}';
    }

    public Preparation(String name, List<Food> foodList) {
        this.name = name;
        this.foodList = foodList;
        this.totalCalories = this.foodList.stream().mapToInt(Food::getCalories).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

}
