package entity;

import java.util.ArrayList;
import java.util.Map;

public class BrowseFilter extends Filter {
    private final String query;

    public BrowseFilter(ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> includeIngredients,
                        ArrayList<String> excludeIngredients, Map<String, Float[]> nutrients, String query) {
        super(diet, intolerances, includeIngredients, excludeIngredients, nutrients);
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
