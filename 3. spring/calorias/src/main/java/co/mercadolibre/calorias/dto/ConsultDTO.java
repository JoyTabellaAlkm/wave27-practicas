package co.mercadolibre.calorias.dto;

import co.mercadolibre.calorias.entity.Food;
import co.mercadolibre.calorias.entity.Preparation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ConsultDTO {
    @JsonProperty("preparation_name")
    private String name;

    @JsonProperty("total_calories_preparation")
    private int totalCalorias;

    @JsonProperty("food_list")
    private List<Food> foodList;

    @JsonProperty("most_caloric_food")
    private Food foodSuperCaloric;

    public ConsultDTO(String name, int totalCalorias, List<Food> foodList, Food foodSuperCaloric) {
        this.name = name;
        this.totalCalorias = totalCalorias;
        this.foodList = foodList;
        this.foodSuperCaloric = foodSuperCaloric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Food getFoodSuperCaloric() {
        return foodSuperCaloric;
    }

    public void setFoodSuperCaloric(Food foodSuperCaloric) {
        this.foodSuperCaloric = foodSuperCaloric;
    }
}
