package entity;

import java.util.Map;

public class RecommendFilter extends Filter{
    private final String ingredients;
    private final String cuisine;
    private final String excludeCuisine;
    private final String type;

    public RecommendFilter(String diet, String intolerance, String ingredients, String excludeIngredients,
                           String cuisine, String excludeCuisine, String type, Map<String, Float> nutrients) {
        super(diet, intolerance, excludeIngredients, nutrients);
        this.ingredients = ingredients;
        this.cuisine = cuisine;
        this.excludeCuisine = excludeCuisine;
        this.type = type;
    }

    public String getIngredients() {
        return ingredients;
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
