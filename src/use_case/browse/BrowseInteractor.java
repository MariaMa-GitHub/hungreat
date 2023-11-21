package use_case.browse;

import entity.BrowseFilter;
import entity.Filter;
import entity.Recipe;
import use_case.recommend.RecommendInputData;

import java.util.ArrayList;
import java.util.HashMap;
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
        ArrayList<String> diet = browseInputData.getDiet();
        ArrayList<String> intolerance = browseInputData.getIntolerance();
        ArrayList<String> excludeIngredients = browseInputData.getExcludeIngredients();
        Map<String, Float[]> nutrients = browseInputData.getNutrients();
        String query = browseInputData.getQuery();
        ArrayList<String> includeIngredients = browseInputData.getIncludeIngredients();

        BrowseFilter browseFilter = new BrowseFilter(diet, intolerance, includeIngredients,excludeIngredients, nutrients, query);
        try{ArrayList<Recipe> recipes = this.dataAccessObject.browse(browseFilter);
        //if not Arrylist then handle failveiw.If yes, then give presenter an arrylist of recipes.

            Map<Integer, String> id_title = new HashMap<>();
            for (int i = 0; i < recipes.size(); i++) {
                Integer recipeID = recipes.get(i).getID();
                String recipeName = recipes.get(i).getTitle();
                id_title.put(recipeID, recipeName);
            }

            browsePresenter.prepareSuccessView(id_title);
            }
            catch (Exception e){
                String errorMessage = e.getMessage();
                browsePresenter.prepareFailView(errorMessage);
            }

        }


}

