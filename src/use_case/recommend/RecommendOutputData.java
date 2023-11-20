package use_case.recommend;

import entity.Recipe;

import java.util.ArrayList;

public class RecommendOutputData {

    private final ArrayList<Recipe> recipes;

    public RecommendOutputData(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

}
