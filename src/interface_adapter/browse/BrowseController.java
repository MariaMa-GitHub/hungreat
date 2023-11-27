package interface_adapter.browse;

import use_case.browse.BrowseInputBoundary;
import use_case.browse.BrowseInputData;

public class BrowseController implements BrowseInputBoundary {
    private final use_case.browse.BrowseInputBoundary browseInteractor;

    public BrowseController(use_case.browse.BrowseInputBoundary browseInteractor) {
        this.browseInteractor = browseInteractor;
    }

    @Override
    public void execute(BrowseInputData browseInputData) {
        browseInteractor.execute(browseInputData);
    }
}


