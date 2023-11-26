package interface_adapter.browse;

import use_case.browse.BrowseOutputBoundary;
import use_case.browse.BrowseOutputData;

import java.util.Map;

public class BrowsePresenter implements BrowseOutputBoundary {
    @Override
    public void prepareSuccessView(BrowseOutputData idTitle) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
