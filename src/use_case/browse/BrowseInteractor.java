package use_case.browse;

import entity.BrowseFilter;
import entity.Filter;
import entity.Recipe;
import use_case.recommend.RecommendInputData;

import java.util.ArrayList;
import java.util.Map;

public class BrowseInteractor implements BrowseInputBoundary {

    final BrowseDataAccessInterface dataAccessObject;
    final BrowseOutputBoundary browsePresenter;

    public BrowseInteractor(BrowseDataAccessInterface dataAccessInterface,
                           BrowseOutputBoundary browseOutputBoundary) {
        this.dataAccessObject = dataAccessInterface;
        this.browsePresenter = browseOutputBoundary;
    }

    @Override
    public void execute(BrowseInputData browseInputData) {
        String diet = browseInputData.getDiet();
        String intolerance = browseInputData.getIntolerance();
        String excludeIngredients = browseInputData.getExcludeIngredients();
        Map<String, Float> nutrients = browseInputData.getNutrients();
        String query = browseInputData.getQuery();

        BrowseFilter browseFilter = new BrowseFilter(diet, intolerance, excludeIngredients, nutrients, query);
        BrowseOutputData browseOutputData = new BrowseOutputData(this.dataAccessObject.browse(browseFilter));
        //if not arrylist then handle fail veiw.
        browseOutputData.getRecipes();


    }
}
