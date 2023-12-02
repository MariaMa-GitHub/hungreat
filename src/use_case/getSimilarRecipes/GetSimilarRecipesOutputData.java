package use_case.getSimilarRecipes;

public class GetSimilarRecipesOutputData {
    private final String recipeString;
    public GetSimilarRecipesOutputData(String recipeString) {
        this.recipeString = recipeString;
    }
    public String getRecipeString(){
        return recipeString;
    }
}
