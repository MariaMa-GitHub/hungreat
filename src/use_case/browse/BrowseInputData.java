package use_case.browse;

import java.util.HashMap;
import java.util.Map;

public class BrowseInputData {
    final private Map<String, Float> nutritionRequirements;
    final private String diet;
    final private String intolerances;
    final private String excludeIngredients;
    private final String query;
    public BrowseInputData(String diet, String intolerances, String excludeIngredients, Map<String, Float> nutritionRequirements,String query) {
        this.diet = diet;
        this.intolerances = intolerances;
        this.excludeIngredients = excludeIngredients;
        this.nutritionRequirements = nutritionRequirements;
        this.query = query;
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
    public String getQuery() {
        return query;
    }
}

