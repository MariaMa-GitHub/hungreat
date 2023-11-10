package entity;

import java.util.HashMap;
import java.util.Map;

public class Filter {
    private final String diet;
    private final String intolerance;
    private final String excludeIngredients;
    private final Map<String, Float> nutrients;   //TODO:why nutrients has it own data type?
//    private String sort
//    private String sortDirection;
//    private boolean instructionsRequired;     //Todo: if keep, remember to add to constructor & add getters

    public Filter(String diet, String intolerance, String excludeIngredients, Map<String, Float> nutrients) {
        this.diet = diet;
        this.intolerance = intolerance;
        this.excludeIngredients = excludeIngredients;
        this.nutrients = nutrients;
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
}
