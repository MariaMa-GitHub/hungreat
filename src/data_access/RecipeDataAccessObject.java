package data_access;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.browse.BrowseDataAccessInterface;
import use_case.recommend.RecommendDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeDataAccessObject implements BrowseDataAccessInterface, RecommendDataAccessInterface {

    private static final String API_KEY = System.getenv("API_KEY");     //load API key from environment variable
    private final Map<String, Recipe> savedRecipes = new HashMap<>();

    @Override
    public ArrayList<Recipe> browse(BrowseFilter browseFilter) {
        String url = getBrowseUrl(browseFilter);
        return searchRecipes(url);
    }

    @Nullable
    private ArrayList<Recipe> searchRecipes(String url) {
        ArrayList<Recipe> recipes = new ArrayList<>();  //creating the list to store returned recipes later
        OkHttpClient client = new OkHttpClient().newBuilder().build();  //creating an HTTP client to make requests later

        //creating the request for searching recipes
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")  //TODO:[Q] delete? what is the purpose of headers?
                .build();

        try{
            //handling data in the returned json-format recipes
            Response response = client.newCall(request).execute();  //make the request and get response from the api
            JSONObject responseBody = new JSONObject(response.body().string());     //get the response body in json format

            //Handle different status code. consult documentation (RecipesApi.md) to see response details.
            //For our api, responseBody does not contain object "code" when success, but response always contains code.
            //For failed status, responseBody contains "code" object.
            if (response.code() == 200) {    //success.
                JSONArray results = responseBody.getJSONArray("results");   //get the returned recipes
                for (int i = 0; i < results.length(); i++) {    //loop over each recipe object in results
                    JSONObject rawRecipe = results.getJSONObject(i);
                    int id = rawRecipe.getInt("id");
                    String title = rawRecipe.getString("title");
                    String imageUrl = rawRecipe.getString("image");
                    String recipeURL = rawRecipe.getString("sourceUrl");
                    RecipeInfo recipeInfo = getRecipeInfo(id);
                    // get the nutrition information TODO: test
                    Map<String[], Float> nutrients = new HashMap<>();
                    JSONArray rawNutrients = rawRecipe.getJSONObject("nutrition").getJSONArray("nutrients");
                    for (int j = 0; j < rawNutrients.length(); j++) {
                        JSONObject rawNutrient = rawNutrients.getJSONObject(j);
                        String nutrientName = rawNutrient.getString("name");
                        String nutrientUnit = rawNutrient.getString("unit");
                        Float nutrientAmount = rawNutrient.getFloat("amount");
                        String[] nameAndUnit = new String[2];
                        nameAndUnit[0] = nutrientName;
                        nameAndUnit[1] = nutrientUnit;
                        nutrients.put(nameAndUnit, nutrientAmount);
                    }
                    NutritionData nutritionData = new NutritionData(id, nutrients);
                    Recipe recipe = new Recipe(
                            id,
                            title,
                            recipeURL,
                            imageUrl,
                            recipeInfo,
                            nutrients
                    );

                }

            } else if (responseBody.getInt("code") == 401) {    //unauthorized.
                throw new RuntimeException(responseBody.getString("message"));
            } else if (responseBody.getInt("code") == 403) {    //forbidden
                throw new RuntimeException(responseBody.getString("message"));
            } else if (responseBody.getInt("code") == 404) {    //not found
                throw new RuntimeException(responseBody.getString("message"));
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public RecipeInfo getRecipeInfo(int recipeID){
        return null;
    }

    private String getBrowseUrl(BrowseFilter browseFilter) {
        //Accessing query parameters from the browse filter
        String query = browseFilter.getQuery();
        String diet = browseFilter.getDiet();
        String excludeIngredients = browseFilter.getExcludeIngredients();
        String intolerances = browseFilter.getIntolerances();
        Map<String, Float> nutritionRequirements = browseFilter.getNutritionRequirements();

        //creating the base request url for searching recipes
        StringBuilder urlBuilder
                = new StringBuilder("https://api.spoonacular.com/recipes/complexSearch");
        urlBuilder.append("?apiKey=").append(API_KEY);       //add api key to the request url to get authentication
        urlBuilder.append("&fillIngredients=true")
                .append("&addRecipeInformation=true").append("&addRecipeNutrition=true"); //make sure the response will contain ingredients, recipeInfo, and nutrition

        //add all user-defined query parameters to the request url
        //checking for null because the absence of some parameter values will cause 404 error
        if (query != null) {urlBuilder.append("&query=").append(query);}
        if (diet != null) {urlBuilder.append("&diet=").append(diet);}
        if (excludeIngredients != null) {urlBuilder.append("&excludeIngredients=").append(excludeIngredients);}
        if (intolerances != null) {urlBuilder.append("&intolerances=").append(intolerances);}
        for (Map.Entry<String, Float> nutritionRequirement : nutritionRequirements.entrySet()) {    //loop over every key-value pairs
            String nutrientRequirementName = nutritionRequirement.getKey();
            Float nutrientRequirementValue = nutritionRequirement.getValue();
            if (nutrientRequirementValue != null) {
                urlBuilder.append("&").append(nutrientRequirementName).append("=").append(nutrientRequirementValue);
            }
        }

        //return the url we built as a string
        return urlBuilder.toString();
    }

    public ArrayList<Recipe> recommend(RecommendFilter recommendFilter) {return null;}

}
