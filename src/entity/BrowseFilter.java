package entity;

import java.util.Map;

public class BrowseFilter extends Filter {
    private final String query;
//    private final String ingredients;
//    private final String cuisine;
//    private final String excludeCuisine;  //TODO: if keep, add to constructor and add getters

    public BrowseFilter(String diet, String intolerance, String excludeIngredients, Map<String, Float> nutrients,
    String query) {
        super(diet, intolerance, excludeIngredients, nutrients);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
