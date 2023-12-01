package interface_adapter.getSimilarRecipes;


import interface_adapter.RecipeViewModel;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputData;

public class GetSimilarRecipesPresenter implements GetSimilarRecipesOutputBoundary {
    private final RecipeViewModel recipeViewModel;

    public GetSimilarRecipesPresenter(RecipeViewModel recipeViewModel) {
        this.recipeViewModel = recipeViewModel;
    }

    @Override
    public void prepareView(GetSimilarRecipesOutputData recipeString) {
        //change data type from GetSimilarRecipesOutputData to string when pass in to recipeViewModel's method
        recipeViewModel.setRecipeString(recipeString.getRecipeString());
    }

}