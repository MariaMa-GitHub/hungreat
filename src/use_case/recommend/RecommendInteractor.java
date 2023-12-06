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
          // TODO: get actual TYPE input from user
          "type",
          recommendInputData.getNutrients()
        );

        ArrayList<Recipe> recipes = this.dataAccessObject.recommend(recommendFilter);

        temporaryRecipeDataAccessObject.storeRecipes(recipes);

        Map<Integer, String> recipeIdAndTitle = new HashMap<>();

        for (Recipe recipe : recipes) {
            recipeIdAndTitle.put(recipe.getID(), recipe.getTitle());
        }

        RecommendOutputData recommendOutputData = new RecommendOutputData(recipeIdAndTitle);

        // TODO: handle exception
        recommendPresenter.prepareSuccessView(recommendOutputData);











//        ArrayList<Recipe> recipes = new ArrayList<>();
//
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format(
//                        "https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&cuisine=%s&excludeCuisine=%s&diet=%s&intolerances=%s&includeIngredients=%s&excludeIngredients=%s&number=10",
//                        System.getenv("API_KEY"),
//                        recommendInputData.getCuisine(),
//                        recommendInputData.getExcludeCuisine(),
//                        recommendInputData.getDiet(),
//                        recommendInputData.getIntolerances(),
//                        recommendInputData.getIngredients(),
//                        recommendInputData.getExcludeIngredients()
//                        )
//                )
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            String body = response.body().string();
//            JSONObject responseBody = new JSONObject(body);
//            JSONArray results = responseBody.getJSONArray("results");
//
//            for (int i = 0; i < 10; i++) {
//
//                JSONObject recipeFromAPI = results.getJSONObject(i);
//                int recipeID = recipeFromAPI.getInt("id");
//                Recipe recipe = recipeFactory.create(
//                        recipeID,
//                        recipeFromAPI.getString("title"),
//                        recipeFromAPI.getString("image"),
//                        recipeFromAPI.getString("image"),
//                        getRecipeInfo(recipeID),
//                        nutritionDataFactory.create(recipeID, new HashMap<>())
//                );
//                recipes.add(recipe);
//
//            }
//
//
//        }
//        catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }
//
//        temporaryRecipeDataAccessObject.storeRecipes(recipes);
//
//        Map<Integer, String> recipeIdAndTitle = new HashMap<>();
//
//        for (Recipe recipe : recipes) {
//            recipeIdAndTitle.put(recipe.getID(), recipe.getTitle());
//        }
//
//        RecommendOutputData recommendOutputData = new RecommendOutputData(recipeIdAndTitle);
//        recommendPresenter.prepareSuccessView(recommendOutputData);

    }

//    private RecipeInfo getRecipeInfo(int recipeID) {
//
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format(
//                                "https://api.spoonacular.com/recipes/716429/information?apiKey=%s&includeNutrition=false",
//                                System.getenv("API_KEY")
//                        )
//                )
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            String body = response.body().string();
//            JSONObject responseBody = new JSONObject(body);
//
//            return recipeInfoFactory.create(
//                    recipeID,
//                    responseBody.getInt("servings"),
//                    responseBody.getInt("readyInMinutes"),
//                    responseBody.getInt("healthScore"),
//                    new ArrayList<>(),
//                    new ArrayList<>()
//                    );
//
//        }
//        catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }
//
////        RecommendOutputData recommendOutputData = new RecommendOutputData();
////        recommendPresenter.prepareSuccessView(recommendOutputData);
//
//    }

}
