package app;

import data_access.RecipeDataAccessObject;
import data_access.SavedRecipeDataAccessObject;
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

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DisplayViewModel displayViewModel = new DisplayViewModel();

        RecipeDataAccessObject dataAccessObject = null;
        TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject = null;
        try {
            SavedRecipeDataAccessObject savedRecipeDataAccessObject = new SavedRecipeDataAccessObject();
            dataAccessObject = new RecipeDataAccessObject();
            temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(savedRecipeDataAccessObject.getSavedRecipes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        try {
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        DisplayController displayController = DisplayUseCaseFactory.create(temporaryRecipeDataAccessObject, recipeViewModel);
        HomeView homeView = new HomeView(browseController, recommendController, displayViewModel, displayController,recipeViewModel);


        application.add(homeView);


        application.pack();

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}