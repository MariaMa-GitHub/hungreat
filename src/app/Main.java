package app;

import data_access.RecipeDataAccessObject;
import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.AnalysisViewModel;
import interface_adapter.DisplayViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.browse.BrowseController;
import interface_adapter.display.DisplayController;
import interface_adapter.recommend.RecommendController;
import use_case.TemporaryRecipeDataAccessInterface;
import view.HomeView;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DisplayViewModel displayViewModel = new DisplayViewModel();
        RecipeViewModel recipeViewModel = new RecipeViewModel();
        AnalysisViewModel analysisViewModel = new AnalysisViewModel();

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


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        AnalysisController analysisController = AnalysisUseCaseFactory.create(temporaryRecipeDataAccessObject,analysisViewModel);

        DisplayController displayController = DisplayUseCaseFactory.create(temporaryRecipeDataAccessObject, recipeViewModel);
        HomeView homeView = new HomeView(browseController, recommendController, displayViewModel, displayController,recipeViewModel, analysisViewModel, analysisController);


        application.add(homeView);


        application.pack();

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}