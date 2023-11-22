package interface_adapter.browse;

import use_case.browse.BrowseOutputBoundary;
import use_case.browse.BrowseOutputData;

import java.util.Map;

public class BrowsePresenter implements BrowseOutputBoundary {
    @Override
    public void prepareSuccessView(Map<Integer, String> id_title) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
