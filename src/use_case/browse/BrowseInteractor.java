package use_case.browse;

import use_case.recommend.RecommendInputData;

import java.util.ArrayList;

public class BrowseInteractor implements BrowseInputBoundary {

    final BrowseDataAccessInterface dataAccessObject;
    final BrowseOutputBoundary browsePresenter;

    public BrowseInteractor(BrowseDataAccessInterface dataAccessInterface,
                           BrowseOutputBoundary browseOutputBoundary) {
        this.dataAccessObject = dataAccessInterface;
        this.browsePresenter = browseOutputBoundary;
    }

}
