package interface_adapter.browse;

import interface_adapter.SearchController;
import use_case.browse.BrowseInputBoundary;

public class BrowseController implements SearchController {

    final BrowseInputBoundary browseInteractor;

    public BrowseController(BrowseInputBoundary browseInteractor) {
        this.browseInteractor = browseInteractor;
    }

    public void execute() {
//        System.out.println("YESSSSSSSSS");
    }

}
