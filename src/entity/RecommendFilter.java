package entity;

import java.util.ArrayList;
import java.util.Map;

public class RecommendFilter extends Filter{
    private final String cuisine;
    private final String excludeCuisine;
    private final String type;

    public RecommendFilter(ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> includeIngredients,
                           ArrayList<String> excludeIngredients, ArrayList<String> cuisine, ArrayList<String> excludeCuisine,
                           String type, Map<String, Float> nutrients) {
        super(diet, intolerances, includeIngredients, excludeIngredients, nutrients);
        this.cuisine = String.join(",", cuisine);
        this.excludeCuisine = String.join(",", excludeCuisine);
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
