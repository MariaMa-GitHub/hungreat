package interface_adapter.display;


import interface_adapter.RecipeViewModel;
import use_case.display.DisplayOutputBoundary;
import use_case.display.DisplayOutputData;

public class DisplayPresenter implements DisplayOutputBoundary {
    private final RecipeViewModel recipeViewModel;

    public DisplayPresenter(RecipeViewModel recipeViewModel) {
        this.recipeViewModel = recipeViewModel;
    }

    @Override
    public void prepareView(DisplayOutputData recipeString) {
        //change data type from DisplayOutputData to string when pass in to recipeViewModel's method
        recipeViewModel.setRecipeString(recipeString.getRecipeString());
    }

}