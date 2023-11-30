package data_access;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
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
    private final RecipeFactory recipeFactory = new RecipeFactory();
    private final RecipeInfoFactory recipeInfoFactory = new RecipeInfoFactory();
    private final NutritionDataFactory nutritionDataFactory = new NutritionDataFactory();


    public ArrayList<Recipe> browse(BrowseFilter browseFilter) {
        String url = getBrowseUrl(browseFilter);
        return searchRecipes(url);
    }

    public ArrayList<Recipe> recommend(RecommendFilter recommendFilter) {
        String url = getRecommendUrl(recommendFilter);
        return searchRecipes(url);
    }

    public ArrayList<Recipe> getSimilarRecipes(int id) {
        String getSimilarRecipesUrl = getSimilarRecipesUrl(id);
        return null;
    }

    @Nullable
    private ArrayList<Recipe> searchRecipes(String url) {
        ArrayList<Recipe> recipes = new ArrayList<>();  //creating the list to store returned recipes later
        OkHttpClient client = new OkHttpClient().newBuilder().build();  //creating an HTTP client to make requests later

        //creating the request for searching recipes
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
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

                    //get the recipeInfo information
                    RecipeInfo recipeInfo = getRecipeInfo(id, rawRecipe);

                    // get the nutritionData information
                    Map<String, String> nutrients = new HashMap<>();
                    JSONArray rawNutrients = rawRecipe.getJSONObject("nutrition").getJSONArray("nutrients");
                    for (int j = 0; j < rawNutrients.length(); j++) {
                        JSONObject rawNutrient = rawNutrients.getJSONObject(j);
                        String nutrientName = rawNutrient.getString("name");
                        String nutrientUnit = rawNutrient.getString("unit");
                        Float nutrientAmount = Float.valueOf(rawNutrient.getFloat("amount"));
                        String amountAndUnit = nutrientAmount + nutrientUnit;
                        nutrients.put(nutrientName, amountAndUnit);
                    }
                    NutritionData nutritionData = nutritionDataFactory.create(id, nutrients);

                    // create a recipe and put into the recipes list
                    Recipe recipe = recipeFactory.create(
                            id,
                            title,
                            recipeURL,
                            imageUrl,
                            recipeInfo,
                            nutritionData
                    );
                    recipes.add(recipe);
                }
                //return the searched recipes
                return recipes;
            } else if (response.code() == 401) {    //unauthorized.
                throw new RuntimeException(responseBody.getString("message"));
            } else if (response.code() == 403) {    //forbidden
                throw new RuntimeException(responseBody.getString("message"));
            } else if (response.code() == 404) {    //not found
                throw new RuntimeException(responseBody.getString("message"));
            }

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private RecipeInfo getRecipeInfo(int id, JSONObject rawRecipe){
        int servings = rawRecipe.getInt("servings");
        int readyInMinutes = rawRecipe.getInt("readyInMinutes");
        int healthScore = (int) rawRecipe.getFloat("healthScore");

        // get the ingredients information
        ArrayList<String> ingredients = new ArrayList<>();
        JSONArray rawIngredients = rawRecipe.getJSONArray("extendedIngredients");
        for (int i = 0; i < rawIngredients.length(); i++){
            JSONObject rawIngredient = rawIngredients.getJSONObject(i);
            String ingredientName = rawIngredient.getString("name");
            String ingredientUnit = rawIngredient.getString("unit");
            Float ingredientAmount = Float.valueOf(rawIngredient.getFloat("amount"));
            //get the descriptions for ingredients
            JSONArray rawDescriptions = rawIngredient.getJSONArray("meta");
            ArrayList<String> descriptionsList = new ArrayList<>();
            for (int j = 0; j < rawDescriptions.length(); j++){
                descriptionsList.add(rawDescriptions.getString(j));
            }
            String description = String.join(", ", descriptionsList);
            String ingredient = ": " + ingredientAmount + " " + ingredientUnit;
            if (description.isEmpty()){
                ingredient = ingredientName + ingredient;
            } else {    //description non-empty
                ingredient = ingredientName + " (" + description + ")" + ingredient;
            }
            ingredients.add(ingredient);    //name (description1, description2): amount unit; name: amount unit
        }

        //get the instructions
        ArrayList<String> instructions = new ArrayList<>();
        JSONArray rawInstructions = rawRecipe.getJSONArray("analyzedInstructions");
        for (int i = 0; i < rawInstructions.length(); i++) {
            JSONObject rawInstruction = rawInstructions.getJSONObject(i);
            //The api sometimes accidentally put steps of the instructions as name. Otherwise, name will be an empty string.
            String name = rawInstruction.getString("name");
            if (!name.isEmpty()) {
                instructions.add(name);
            }
            //get the steps of the instructions
            JSONArray rawSteps = rawInstruction.getJSONArray("steps");
            for (int j = 0; j < rawSteps.length(); j++) {
                JSONObject rawStep = rawSteps.getJSONObject(j);
                String step = rawStep.getString("step");
                instructions.add(step);
            }

        }

        //create the recipeInfo
        RecipeInfo recipeInfo = recipeInfoFactory.create(
                id,
                servings,
                readyInMinutes,
                healthScore,
                ingredients,
                instructions
        );
        return recipeInfo;
    }

    private String getBrowseUrl(BrowseFilter browseFilter) {
        //Accessing query parameters from the browse filter
        String query = browseFilter.getQuery();
        String diet = browseFilter.getDiet();
        String includeIngredients = browseFilter.getIncludeIngredients();
        String excludeIngredients = browseFilter.getExcludeIngredients();
        String intolerances = browseFilter.getIntolerances();
        Map<String, Float[]> nutritionRequirements = browseFilter.getNutritionRequirements();

        //creating the base request url for searching recipes
        StringBuilder urlBuilder
                = new StringBuilder("https://api.spoonacular.com/recipes/complexSearch");
        urlBuilder.append("?apiKey=").append(API_KEY);       //add api key to the request url to get authentication
        urlBuilder.append("&fillIngredients=true").append("&addRecipeInformation=true")
                .append("&addRecipeNutrition=true").append("number=6"); //make sure the response will contain ingredients, recipeInfo, and nutrition

//        add all user-defined query parameters to the request url
//        checking for empty because the absence of some parameter values will cause 404 error
        if (!query.isEmpty()) {urlBuilder.append("&query=").append(query);}
        if (!diet.isEmpty()) {urlBuilder.append("&diet=").append(diet);}
        if (!includeIngredients.isEmpty()) {urlBuilder.append("&includeIngredients=").append(includeIngredients);}
        if (!excludeIngredients.isEmpty()) {urlBuilder.append("&excludeIngredients=").append(excludeIngredients);}
        if (!intolerances.isEmpty()) {urlBuilder.append("&intolerances=").append(intolerances);}
        for (Map.Entry<String, Float[]> nutritionRequirement : nutritionRequirements.entrySet()) {    //loop over every key-value pairs
            String nutrientRequirementName = nutritionRequirement.getKey();
            Float minRequirementValue = nutritionRequirement.getValue()[0];
            Float maxRequirementValue = nutritionRequirement.getValue()[1];
            urlBuilder.append("&").append("min").append(nutrientRequirementName).append("=").append(minRequirementValue);
            urlBuilder.append("&").append("max").append(nutrientRequirementName).append("=").append(maxRequirementValue);
        }

        //return the url we built as a string
        return urlBuilder.toString();
    }

    private String getRecommendUrl(RecommendFilter recommendFilter) {
        //Accessing query parameters from the browse filter
        String diet = recommendFilter.getDiet();
        String includeIngredients = recommendFilter.getIncludeIngredients();
        String excludeIngredients = recommendFilter.getExcludeIngredients();
        String intolerances = recommendFilter.getIntolerances();
        String includeCuisine = recommendFilter.getCuisine();
        String excludeCuisine = recommendFilter.getExcludeCuisine();
        String type = recommendFilter.getType();
        Map<String, Float[]> nutritionRequirements = recommendFilter.getNutritionRequirements();

        //creating the base request url for searching recipes
        StringBuilder urlBuilder
                = new StringBuilder("https://api.spoonacular.com/recipes/complexSearch");
        urlBuilder.append("?apiKey=").append(API_KEY);       //add api key to the request url to get authentication
        urlBuilder.append("&fillIngredients=true").append("&addRecipeInformation=true")
                .append("&addRecipeNutrition=true").append("&number=6"); //make sure the response will contain ingredients, recipeInfo, and nutrition

//        add all user-defined query parameters to the request url
//        checking for empty because the absence of some parameter values will cause 404 error
        if (!diet.isEmpty()) {urlBuilder.append("&diet=").append(diet);}
        if (!includeIngredients.isEmpty()) {urlBuilder.append("&includeIngredients=").append(includeIngredients);}
        if (!excludeIngredients.isEmpty()) {urlBuilder.append("&excludeIngredients=").append(excludeIngredients);}
        if (!intolerances.isEmpty()) {urlBuilder.append("&intolerances=").append(intolerances);}
        if (!includeCuisine.isEmpty()) {urlBuilder.append("&cuisine=").append(includeCuisine);}
        if (!excludeCuisine.isEmpty()) {urlBuilder.append("&excludeCuisine=").append(excludeCuisine);}
        if (!type.isEmpty()) {urlBuilder.append("&type=").append(type);}
        for (Map.Entry<String, Float[]> nutritionRequirement : nutritionRequirements.entrySet()) {    //loop over every key-value pairs
            String nutrientRequirementName = nutritionRequirement.getKey();
            Float minRequirementValue = nutritionRequirement.getValue()[0];
            Float maxRequirementValue = nutritionRequirement.getValue()[1];
            urlBuilder.append("&").append("min").append(nutrientRequirementName).append("=").append(minRequirementValue);
            urlBuilder.append("&").append("max").append(nutrientRequirementName).append("=").append(maxRequirementValue);
        }

        //return the url we built as a string
        return urlBuilder.toString();
    }

    private String getSerchRecipesInfoBulkUrl(ArrayList<String> ids) {
        StringBuilder urlBuilder
                = new StringBuilder("https://api.spoonacular.com/recipes/informationBulk");
        urlBuilder.append("?apiKey=").append(API_KEY);       //add api key to the request url to get authentication
        urlBuilder.append("&fillIngredients=true").append("&addRecipeInformation=true")
                .append("&addRecipeNutrition=true"); //make sure the response will contain ingredients, recipeInfo, and nutrition

        //add the recipe ids we want to search for to the link
        String stringOfIds = "&ids=" + String.join(",", ids);
        urlBuilder.append(stringOfIds);

        //return the url we built as a string
        return urlBuilder.toString();
    }

    private JSONArray makeGetRecipeInfoBulkApiCall (String url) {
        return null;
    }

    private JSONArray makeGetSimilarRecipesApiCall (String url) {
        //make API call using the url we build to get a list of recipes
        OkHttpClient client = new OkHttpClient().newBuilder().build();  //creating an HTTP client to make requests later

        //creating the request for searching recipes
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            //handling data in the returned json-format recipes
            Response response = client.newCall(request).execute();  //make the request and get response from the api
            JSONObject responseBody = new JSONObject(response.body().string());     //get the response body in json format

            //Handle different status code. consult documentation (RecipesApi.md) to see response details.
            //For our api, responseBody does not contain object "code" when success, but response always contains code.
            //For failed status, responseBody contains "code" object.
            if (response.code() == 200) {

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

    @NotNull
    private String getSimilarRecipesUrl(int id) {
        //build the url request of getting similar recipe from the API
        StringBuilder urlBuilder
                = new StringBuilder("https://api.spoonacular.com/recipes/" + id + "/similar");
        urlBuilder.append("?apiKey=").append(API_KEY);       //add api key to the request url to get authentication
        urlBuilder.append("&number=6");     //make sure the response will return at most 6 recipes

        //return the url we built as a string
        return urlBuilder.toString();
    }


}
