package interface_adapter.getSimilarRecipes;


import interface_adapter.RecipeViewModel;
import interface_adapter.RecipeViewModel;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputData;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputData;

public class GetSimilarRecipesPresenter implements GetSimilarRecipesOutputBoundary {

    private final RecipeViewModel recipeViewModel;

    public GetSimilarRecipesPresenter(RecipeViewModel recipeViewModel) {
        this.recipeViewModel = recipeViewModel;
    }

    @Override
    public void prepareSuccessView(GetSimilarRecipesOutputData response) {
        recipeViewModel.setIdTittle(response.getRecipes());
    }

    @Override
    public void prepareFailView(String error) {
        // Recipe error view with the provided error message
        System.err.println("Error occurred: " + error);
    }
}