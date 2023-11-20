package use_case.browse;

import java.util.HashMap;
import java.util.Map;

public class BrowseInputData {
    final private Map<String, Float> nutrients;
    final private String diet;
    final private String intolerance;
    final private String excludeIngredients;
    private final String query;
    public BrowseInputData(String diet, String intolerance, String excludeIngredients, Map<String, Float> nutrients,String query) {
        this.diet = diet;
        this.intolerance = intolerance;
        this.excludeIngredients = excludeIngredients;
        this.nutrients = nutrients;
        this.query = query;
        }

    public String getDiet() {
        return diet;
    }

    public String getIntolerance() {
        return intolerance;
    }

    public String getExcludeIngredients() {
        return excludeIngredients;
    }

    public Map<String, Float> getNutrients() {
        return nutrients;
    }
    public String getQuery() {
        return query;
    }
}

