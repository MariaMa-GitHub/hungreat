package entity;

import java.util.ArrayList;
import java.util.Map;

public class BrowseFilter extends Filter {
    private final String query;

//    private final String cuisine;
//    private final String excludeCuisine;  //TODO: if keep, add to constructor and DAO and add getters

    public BrowseFilter(ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> includeIngredients,
                        ArrayList<String> excludeIngredients, Map<String, Float[]> nutrients, String query) {
        super(diet, intolerances, includeIngredients, excludeIngredients, nutrients);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
