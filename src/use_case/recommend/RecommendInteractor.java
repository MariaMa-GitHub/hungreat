package use_case.recommend;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.TemporaryRecipeDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecommendInteractor implements RecommendInputBoundary {

    final RecommendDataAccessInterface dataAccessObject;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject;
    final RecommendOutputBoundary recommendPresenter;

    public RecommendInteractor(RecommendDataAccessInterface dataAccessInterface,
                               TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject,
                               RecommendOutputBoundary recommendOutputBoundary) {
        this.dataAccessObject = dataAccessInterface;
        this.temporaryRecipeDataAccessObject = temporaryRecipeDataAccessObject;
        this.recommendPresenter = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {

        RecommendFilter recommendFilter = new RecommendFilter(
                recommendInputData.getDiet(),
                recommendInputData.getIntolerances(),
                recommendInputData.getIngredients(),
                recommendInputData.getExcludeIngredients(),
                recommendInputData.getCuisine(),
                recommendInputData.getExcludeCuisine(),
                "",
                recommendInputData.getNutrients()
        );

        ArrayList<Recipe> recipes = this.dataAccessObject.recommend(recommendFilter);

        temporaryRecipeDataAccessObject.storeRecipes(recipes);

        Map<Integer, String> recipeIdAndTitle = new HashMap<>();

        for (Recipe recipe : recipes) {
            recipeIdAndTitle.put(recipe.getID(), recipe.getTitle());
        }

        RecommendOutputData recommendOutputData = new RecommendOutputData(recipeIdAndTitle);

        recommendPresenter.prepareSuccessView(recommendOutputData);

    }

}
