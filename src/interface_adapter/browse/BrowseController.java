package interface_adapter.browse;

import use_case.browse.BrowseInputBoundary;

public class BrowseController {

    final BrowseInputBoundary browseInteractor;

    public BrowseController(BrowseInputBoundary browseInteractor) {
        this.browseInteractor = browseInteractor;
    }

    public void execute() {

    }

}
