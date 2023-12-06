package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Filter {
    private final String diet;
    private final String intolerances;
    private final String includeIngredients;
    private final String excludeIngredients;
    private final Map<String, Float[]> nutritionRequirements;

    public Filter(ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> includeIngredients, ArrayList<String> excludeIngredients, Map<String, Float[]> nutritionRequirements) {
        this.diet = String.join(",", diet);
        this.intolerances = String.join(",", intolerances);
        this.includeIngredients = String.join(",", includeIngredients);
        this.excludeIngredients = String.join(",", excludeIngredients);
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

    public String getIncludeIngredients() {
        return includeIngredients;
    }

    public Map<String, Float[]> getNutritionRequirements() {
        return nutritionRequirements;
    }
}
