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
    public void prepareView(GetSimilarRecipesOutputData title) {
        recipeViewModel.setTittle(title.getTitle());
    }

}