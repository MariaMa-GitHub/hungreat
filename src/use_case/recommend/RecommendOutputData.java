package use_case.recommend;

import java.util.Map;

public class RecommendOutputData {

    private final Map<Integer, String> recipes;

    public RecommendOutputData(Map<Integer, String> recipes) {
        this.recipes = recipes;
    }

    public Map<Integer, String> getRecipes() {
        return recipes;
    }

}
