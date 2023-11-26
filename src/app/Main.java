package app;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.DisplayViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.browse.BrowseController;
import interface_adapter.display.DisplayController;
import interface_adapter.recommend.RecommendController;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.TemporaryRecipeDataAccessInterface;
import view.HomeView;
import view.RecipeView;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DisplayViewModel displayViewModel = new DisplayViewModel();

        RecipeDataAccessObject dataAccessObject;
        TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject;
        RecipeViewModel recipeViewModel;
//        try {
            dataAccessObject = new RecipeDataAccessObject();
            temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject();
            recipeViewModel = new RecipeViewModel();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject);

        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        DisplayController displayController = DisplayUseCaseFactory.create(temporaryRecipeDataAccessObject, recipeViewModel);
        HomeView homeView = new HomeView(browseController, recommendController, displayViewModel, displayController,recipeViewModel);


        application.add(homeView);


        application.pack();

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);




//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&number=%s", System.getenv("API_KEY"), "lobster", "1"))
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
//        }
//        catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }



////        Test api call - browse
//        OkHttpClient client = new OkHttpClient().newBuilder().build();  //creating an HTTP client to make requests later
//
//        String API_KEY = "73eb97ed01cc45afb92fce3c8c424418";
//        String query = "pasta";
//        String diet = "";
//        String excludeIngredients = "";
//        String intolerances = "";
//        Map<String, Float> nutritionRequirements = new HashMap<>();
//        nutritionRequirements.put("maxCarbs", 200F);
//        nutritionRequirements.put("minProtein", 10F);
//
//
//        StringBuilder urlBuilder
//                = new StringBuilder("https://api.spoonacular.com/recipes/complexSearch");
//        urlBuilder.append("?apiKey=").append(API_KEY);       //add api key to the request url to get authentication
//        urlBuilder.append("&fillIngredients=true")
//                .append("&addRecipeInformation=true").append("&addRecipeNutrition=true&number=2");
//
//        //add all user-defined query parameters to the request url
//        //checking for null because the absence of some parameter values will cause 404 error
//        if (query != null) {urlBuilder.append("&query=").append(query);}
//        if (diet != null) {urlBuilder.append("&diet=").append(diet);}
//        if (excludeIngredients != null) {urlBuilder.append("&excludeIngredients=").append(excludeIngredients);}
//        if (intolerances != null) {urlBuilder.append("&intolerances=").append(intolerances);}
//        for (Map.Entry<String, Float> nutritionRequirement : nutritionRequirements.entrySet()) {    //loop over every key-value pairs
//            String nutrientRequirementName = nutritionRequirement.getKey();
//            Float nutrientRequirementValue = nutritionRequirement.getValue();
//            if (nutrientRequirementValue != null) {
//                urlBuilder.append("&").append(nutrientRequirementName).append("=").append(nutrientRequirementValue);
//            }
//        }
//
//        String url = urlBuilder.toString();
//
//        //creating the request for searching recipes
//        Request request = new Request.Builder()
//                .url(url)
//                .addHeader("Content-Type", "application/json")
//                .build();
//
//        try{
//            //handling data in the returned json-format recipes
//            Response response = client.newCall(request).execute();  //make the request and get response from the api
//            //check the url and results
//            System.out.println(response);
//            System.out.println(response.code());
//            System.out.println(response.code() == 200);
//            System.out.println(response.message());
//
//            JSONObject responseBody = new JSONObject(response.body().string());
//            System.out.println(responseBody);
//            JSONArray results = responseBody.getJSONArray("results");
//            JSONObject rawRecipe = results.getJSONObject(0);
//            System.out.println(rawRecipe.getInt("readyInMinutes"));
////            System.out.println(responseBody.getInt("code"));
////            System.out.println(responseBody.getString("message"));
//
//        } catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }

    }

}