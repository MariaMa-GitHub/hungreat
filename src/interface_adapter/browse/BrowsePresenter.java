package interface_adapter.browse;

import use_case.browse.BrowseOutputBoundary;
import use_case.browse.BrowseOutputData;

public class BrowsePresenter implements BrowseOutputBoundary {
    @Override
    public void prepareSuccessView(BrowseOutputData recipes) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
