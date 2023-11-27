package interface_adapter.browse;

import interface_adapter.SearchController;
import use_case.browse.BrowseInputBoundary;
import use_case.browse.BrowseInputData;
import use_case.recommend.RecommendInputData;

import java.util.ArrayList;
import java.util.Map;

public class BrowseController implements SearchController {
    private final use_case.browse.BrowseInputBoundary browseInteractor;

    public BrowseController(use_case.browse.BrowseInputBoundary browseInteractor) {
        this.browseInteractor = browseInteractor;
    }

    public void execute(ArrayList<String> diet, ArrayList<String> intolerance, ArrayList<String> includeIngredients,ArrayList<String> excludeIngredients, Map<String, Float[]> nutrients, String query) {

        BrowseInputData browseInputData = new BrowseInputData(diet, intolerance, includeIngredients,excludeIngredients, nutrients, query);

        browseInteractor.execute(browseInputData);
    }
}


