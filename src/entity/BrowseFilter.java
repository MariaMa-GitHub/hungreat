package entity;

import java.util.Map;

public class BrowseFilter extends Filter {
    private final String query;

//    private final String cuisine;
//    private final String excludeCuisine;  //TODO: if keep, add to constructor and DAO and add getters

    public BrowseFilter(String diet, String intolerance, String includeIngredients, String excludeIngredients, Map<String, Float> nutrients,
    String query) {
        super(diet, intolerance, includeIngredients, excludeIngredients, nutrients);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
