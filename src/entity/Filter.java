package entity;

import java.util.HashMap;
import java.util.Map;

public class Filter {
    private final String diet;
    private final String intolerances;
    private final String excludeIngredients;
    private final Map<String, Float> nutritionRequirements;   //TODO:why nutrients has it own data type?
//    private String sort
//    private String sortDirection;
//    private boolean instructionsRequired;     //Todo: if keep, remember to add to constructor & DAO & add getters

    public Filter(String diet, String intolerances, String excludeIngredients, Map<String, Float> nutritionRequirements) {
        this.diet = diet;
        this.intolerances = intolerances;
        this.excludeIngredients = excludeIngredients;
        this.nutritionRequirements = nutritionRequirements;
    }

    public String getDiet() {
        return diet;
    }

    public String getIntolerances() {
        return intolerances;
    }

    public String getExcludeIngredients() {
        return excludeIngredients;
    }

    public Map<String, Float> getNutritionRequirements() {
        return nutritionRequirements;
    }
}
