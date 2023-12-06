package view;

import app.*;
import data_access.RecipeDataAccessObject;
import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.AnalysisViewModel;
import interface_adapter.DisplayViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.SaveViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.browse.BrowseController;
import interface_adapter.create.CreateController;
import interface_adapter.delete.DeleteController;
import interface_adapter.display.DisplayController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.recommend.RecommendController;
import interface_adapter.save.SaveController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.getSimilarRecipes.GetSimilarRecipesDataAccessInterface;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    @Test
    void testBrowse() {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DisplayViewModel displayViewModel = new DisplayViewModel();
        RecipeViewModel recipeViewModel = new RecipeViewModel();
        AnalysisViewModel analysisViewModel = new AnalysisViewModel();
        SaveViewModel saveViewModel = new SaveViewModel();



        RecipeDataAccessObject dataAccessObject = null;
        TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject = null;
        SavedRecipeDataAccessObject savedRecipeDataAccessObject = null;
        GetSimilarRecipesDataAccessInterface recipeDataAccessObject = null;
        try {
            savedRecipeDataAccessObject = new SavedRecipeDataAccessObject();
            dataAccessObject = new RecipeDataAccessObject();
            temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(savedRecipeDataAccessObject.getSavedRecipes());
            recipeDataAccessObject = new RecipeDataAccessObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        AnalysisController analysisController = AnalysisUseCaseFactory.create(temporaryRecipeDataAccessObject,analysisViewModel);

        DisplayController displayController = DisplayUseCaseFactory.create(temporaryRecipeDataAccessObject, recipeViewModel);

        GetSimilarRecipesController getSimilarRecipesController = GetSimilarRecipesUseCaseFactory.create(recipeDataAccessObject, recipeViewModel);

        CreateController createController = CreateUseCaseFactory.create(savedRecipeDataAccessObject, saveViewModel, temporaryRecipeDataAccessObject);

        SaveController saveController = SaveUseCaseFactory.create(saveViewModel, temporaryRecipeDataAccessObject, savedRecipeDataAccessObject);

        DeleteController deleteController = DeleteUseCaseFactory.create(saveViewModel, temporaryRecipeDataAccessObject, savedRecipeDataAccessObject);
        HomeView homeView = new HomeView(
                browseController,
                recommendController,
                createController,
                analysisViewModel,
                analysisController,
                displayViewModel,
                displayController,
                recipeViewModel,
                getSimilarRecipesController,
                saveController,
                saveViewModel,
                deleteController);

        application.add(homeView);

        application.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screenSize.getWidth() / 2 - application.getWidth() / 2;
        int y = (int) screenSize.getHeight() / 2 - application.getHeight() / 2;
        application.setLocation(x, y);

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);

        new BrowseView(browseController, displayViewModel, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

        new CreateView(createController, displayViewModel, displayController, recipeViewModel, analysisController, analysisViewModel);

        new RecommendView(recommendController, displayViewModel, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

        new DisplayView(displayController, displayViewModel.getRecipes(), recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

        new RecipeView(1, "title", recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

    }

}
