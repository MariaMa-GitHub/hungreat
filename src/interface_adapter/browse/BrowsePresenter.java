package interface_adapter.browse;

import java.util.Map;

import interface_adapter.DisplayViewModel;
import use_case.browse.BrowseOutputBoundary;
import use_case.browse.BrowseOutputData;

public class BrowsePresenter implements BrowseOutputBoundary {

    private final DisplayViewModel displayViewModel;

    public BrowsePresenter(DisplayViewModel displayViewModel) {
        this.displayViewModel = displayViewModel;
    }

    @Override
    public void prepareSuccessView(BrowseOutputData response) {
        displayViewModel.setRecipeIDs(response.getRecipes());
    }

    @Override
    public void prepareFailView(String error) {
        // Display error view with the provided error message
        System.err.println("Error occurred: " + error);
    }
}

