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
    public void prepareView(DisplayOutputData recipe) {

    }

}