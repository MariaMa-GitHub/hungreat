package data_access;

import entity.BrowseFilter;
import entity.Recipe;
import entity.RecipeInfo;
import entity.RecommendFilter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
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
        ArrayList<Recipe> recipes = new ArrayList<>();  //creating the list to store returned recipes later
        //TODO: Test the requesting section
        OkHttpClient client = new OkHttpClient().newBuilder().build();  //creating an HTTP client to make requests later
        String url = getBrowseUrl(browseFilter);

        //creating the request for searching recipes
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")  //TODO:[Q] delete? what is the porpuse of headers?
                .build();
        
        try{
            Response response = client.newCall(request).execute();
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @NotNull
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

    public RecipeInfo getRecipeInfo(int recipeID){
        return null;
    }

}
