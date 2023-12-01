package interface_adapter.recommend;

import interface_adapter.DisplayViewModel;
import use_case.recommend.RecommendOutputBoundary;
import use_case.recommend.RecommendOutputData;

public class RecommendPresenter implements RecommendOutputBoundary {

    private final DisplayViewModel displayViewModel;

    public RecommendPresenter(DisplayViewModel displayViewModel) {
        this.displayViewModel = displayViewModel;
    }

    public void prepareSuccessView(RecommendOutputData response) {

        displayViewModel.setRecipeIDs(response.getRecipes());

    }

}
