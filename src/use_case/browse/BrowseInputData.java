package use_case.browse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class BrowseInputData {

        final private ArrayList<String> cuisine;
        final private ArrayList<String> excludeCuisine;
        final private ArrayList<String> diet;
        final private ArrayList<String> intolerances;
        final private ArrayList<String> excludeIngredients;
        final private HashMap<String, Float[]> nutrients;
        final private String query;
        final private String type;
        final private ArrayList<String> includeIngredients;

        public BrowseInputData(ArrayList<String> cuisine, ArrayList<String> excludeCuisine, ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> excludeIngredients, HashMap<String, Float[]> nutrients, String query, String type, ArrayList<String> includeIngredients) {
            this.cuisine = cuisine;
            this.excludeCuisine = excludeCuisine;
            this.diet = diet;
            this.intolerances = intolerances;
            this.excludeIngredients = excludeIngredients;
            this.nutrients = nutrients;
            this.query = query;
            this.type = type;
            this.includeIngredients = includeIngredients;
        }

    public String getCuisine() {
        return String.join(",",cuisine);
    }

    public String getExcludeCuisine() {
        return String.join(",",excludeCuisine);
    }

    public String getDiet() {
        return String.join(",",diet);
    }

    public String getIntolerances() {
        return String.join(",",intolerances);
    }

    public String getExcludeIngredients() {
        return String.join(",",excludeIngredients);
    }

    public HashMap<String, Float[]> getNutrients() {
        return nutrients;
    }

    public String getQuery() {
        return query;
    }

    public String getType() {
        return type;
    }

    public String getIncludeIngredients() {
        return String.join(",",includeIngredients);
    }
}


