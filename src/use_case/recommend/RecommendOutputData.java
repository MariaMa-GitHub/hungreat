package use_case.recommend;

import entity.Recipe;

import java.util.Collection;

public class RecommendOutputData {

    private final Collection<Recipe> recipes;

    public RecommendOutputData(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }

}
