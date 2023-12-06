package use_case.browse;

import data_access.TemporaryRecipeDataAccessObject;
import entity.BrowseFilter;
import entity.Filter;
import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.recommend.RecommendInputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BrowseInteractor implements BrowseInputBoundary {

    final BrowseDataAccessInterface dataAccessObject;
    final BrowseOutputBoundary browsePresenter;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject;

    public BrowseInteractor(BrowseDataAccessInterface dataAccessInterface,
                           BrowseOutputBoundary browseOutputBoundary,TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject) {
        this.dataAccessObject = dataAccessInterface;
        this.browsePresenter = browseOutputBoundary;
        this.temporaryRecipeDataAccessObject = temporaryRecipeDataAccessObject;
    }

    @Override
    public void execute(BrowseInputData browseInputData) {
        ArrayList<String> diet = browseInputData.getDiet();
        ArrayList<String> intolerance = browseInputData.getIntolerance();
        ArrayList<String> excludeIngredients = browseInputData.getExcludeIngredients();
        Map<String, Float[]> nutrients = browseInputData.getNutrients();
        String query = browseInputData.getQuery();
        ArrayList<String> includeIngredients = browseInputData.getIncludeIngredients();

        BrowseFilter browseFilter = new BrowseFilter(diet, intolerance, includeIngredients, excludeIngredients, nutrients, query);
        ArrayList<Recipe> recipes = this.dataAccessObject.browse(browseFilter);
        //if not Arraylist then handle fail view. If yes, then give presenter an arraylist of recipes.
            temporaryRecipeDataAccessObject.storeRecipes(recipes);
            Map<Integer, String> idTitle = new HashMap<>();
            for (int i = 0; i < recipes.size(); i++) {
                Integer recipeID = recipes.get(i).getID();
                String recipeName = recipes.get(i).getTitle();
                idTitle.put(recipeID, recipeName);
            }
            BrowseOutputData browseOutputData = new BrowseOutputData(idTitle);
            browsePresenter.prepareSuccessView(browseOutputData);
            }

        }




