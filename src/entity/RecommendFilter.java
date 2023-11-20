package entity;

import java.util.Map;

public class RecommendFilter extends Filter{
    private final String cuisine;
    private final String excludeCuisine;
    private final String type;

    public RecommendFilter(String diet, String intolerance, String includeIngredients, String excludeIngredients,
                           String cuisine, String excludeCuisine, String type, Map<String, Float> nutrients) {
        super(diet, intolerance, includeIngredients, excludeIngredients, nutrients);
        this.cuisine = cuisine;
        this.excludeCuisine = excludeCuisine;
        this.type = type;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getExcludeCuisine() {
        return excludeCuisine;
    }

    public String getType() {
        return type;
    }
}
