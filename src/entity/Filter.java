package entity;

import java.util.HashMap;
import java.util.Map;

public class Filter {
    private final String diet;
    private final String intolerances;
    private final String includeIngredients;
    private final String excludeIngredients;
    private final Map<String, Float> nutritionRequirements;

    //TODO: data should be in the format of {"maxCarbs":150, "minFat": 10.5}, where the keys are parameters that the search recipe function allows
//    private String sort
//    private String sortDirection;
//    private boolean instructionsRequired;     //Todo: if keep, remember to add to constructor & DAO & add getters

    public Filter(String diet, String intolerances, String includeIngredients, String excludeIngredients, Map<String, Float> nutritionRequirements) {
        this.diet = diet;
        this.intolerances = intolerances;
        this.excludeIngredients = excludeIngredients;
        this.nutritionRequirements = nutritionRequirements;
        this.includeIngredients = includeIngredients;
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

    public String getIncludeIngredients() {
        return includeIngredients;
    }

    public Map<String, Float> getNutritionRequirements() {
        return nutritionRequirements;
    }
}
