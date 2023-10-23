package use_case.recommend;

import java.util.ArrayList;
import java.util.HashMap;

public class RecommendInputData {

    final private ArrayList<String> cuisine;
    final private ArrayList<String> excludeCuisine;
    final private ArrayList<String> diet;
    final private ArrayList<String> intolerances;
    final private ArrayList<String> ingredients;
    final private ArrayList<String> excludeIngredients;
    final private HashMap<String, Float[]> nutrients;

    public RecommendInputData(ArrayList<String> cuisine, ArrayList<String> excludeCuisine, ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> ingredients, ArrayList<String> excludeIngredients, HashMap<String, Float[]> nutrients) {
        this.cuisine = cuisine;
        this.excludeCuisine = excludeCuisine;
        this.diet = diet;
        this.intolerances = intolerances;
        this.ingredients = ingredients;
        this.excludeIngredients = excludeIngredients;
        this.nutrients = nutrients;
    }

    public String getCuisine() {
        return String.join(",", cuisine);
    }

    public String getExcludeCuisine() {
        return String.join(",", excludeCuisine);
    }

    public String getDiet() {
        return String.join(",", diet);
    }

    public String getIntolerances() {
        return String.join(",", intolerances);
    }

    public String getIngredients() {
        return String.join(",", ingredients);
    }

    public String getExcludeIngredients() {
        return String.join(",", excludeIngredients);
    }

    public HashMap<String, Float[]> getNutrients() {
        return nutrients;
    }
}
