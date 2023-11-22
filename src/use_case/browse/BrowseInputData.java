package use_case.browse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BrowseInputData {
    final private Map<String, Float[]> nutrients;
    final private ArrayList<String> diet;
    final private ArrayList<String> intolerance;
    final private ArrayList<String> excludeIngredients;
    private final String query;
    private final ArrayList<String> includeIngredients;
    public BrowseInputData(ArrayList<String> diet, ArrayList<String> intolerance, ArrayList<String> includeIngredients,ArrayList<String> excludeIngredients, Map<String, Float[]> nutrients, String query) {
        this.diet = diet;
        this.intolerance = intolerance;
        this.includeIngredients = includeIngredients;
        this.excludeIngredients = excludeIngredients;
        this.nutrients = nutrients;
        this.query = query;
        }

    public ArrayList<String> getDiet() {
        return diet;
    }

    public ArrayList<String> getIntolerance() {
        return intolerance;
    }
    public ArrayList<String> getIncludeIngredients(){
        return includeIngredients;
    }

    public ArrayList<String> getExcludeIngredients() {
        return excludeIngredients;
    }

    public Map<String, Float[]> getNutrients() {
        return nutrients;
    }
    public String getQuery() {
        return query;
    }
}

