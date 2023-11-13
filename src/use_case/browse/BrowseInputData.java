package use_case.browse;

import java.util.HashMap;
import java.util.Map;

public class BrowseInputData {
    final private Map<String, Float> nutritionRequirements;
    final private String diet;
    final private String intolerances;
    final private String excludeIngredients;

    public BrowseInputData(String diet, String intolerances, String excludeIngredients, Map<String, Float> nutritionRequirements) {
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

