//package interface_adapter.save;
//
//import app.*;
//import data_access.RecipeDataAccessObject;
//import data_access.SavedRecipeDataAccessObject;
//import data_access.TemporaryRecipeDataAccessObject;
//import interface_adapter.AnalysisViewModel;
//import interface_adapter.DisplayViewModel;
//import interface_adapter.RecipeViewModel;
//import interface_adapter.SaveViewModel;
//import interface_adapter.analysis.AnalysisController;
//import interface_adapter.browse.BrowseController;
//import interface_adapter.create.CreateController;
//import interface_adapter.delete.DeleteController;
//import interface_adapter.display.DisplayController;
//import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
//import interface_adapter.recommend.RecommendController;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import use_case.getSimilarRecipes.GetSimilarRecipesDataAccessInterface;
//import use_case.save.SaveInputBoundary;
//import use_case.save.SaveInputData;
//import use_case.save.SaveInteractor;
//import view.SaveView;
//
//import java.io.IOException;
//
//public class SaveControllerTest {
//    private SaveInputBoundary saveInteractor;
//    private SaveController saveController;
//    private SavedRecipeDataAccessObject savedRecipeDataAccessObject;
//    private RecipeDataAccessObject dataAccessObject;
//    private TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject;
//    private RecipeDataAccessObject recipeDataAccessObject;
//
//    @BeforeEach
//    void setUp() {
//        DisplayViewModel displayViewModel = new DisplayViewModel();
//        RecipeViewModel recipeViewModel = new RecipeViewModel();
//        AnalysisViewModel analysisViewModel = new AnalysisViewModel();
//        SaveViewModel saveViewModel = new SaveViewModel();
//
//
//
//        RecipeDataAccessObject dataAccessObject = null;
//        TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject = null;
//        SavedRecipeDataAccessObject savedRecipeDataAccessObject = null;
//        GetSimilarRecipesDataAccessInterface recipeDataAccessObject = null;
//        try {
//            savedRecipeDataAccessObject = new SavedRecipeDataAccessObject();
//            dataAccessObject = new RecipeDataAccessObject();
//            temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(savedRecipeDataAccessObject.getSavedRecipes());
//            recipeDataAccessObject = new RecipeDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);
//
//        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);
//
//        AnalysisController analysisController = AnalysisUseCaseFactory.create(temporaryRecipeDataAccessObject,analysisViewModel);
//
//        DisplayController displayController = DisplayUseCaseFactory.create(temporaryRecipeDataAccessObject, recipeViewModel);
//
//        GetSimilarRecipesController getSimilarRecipesController = GetSimilarRecipesUseCaseFactory.create(recipeDataAccessObject, recipeViewModel);
//
//        CreateController createController = CreateUseCaseFactory.create(savedRecipeDataAccessObject, saveViewModel, temporaryRecipeDataAccessObject);
//
//        SaveController saveController = SaveUseCaseFactory.create(saveViewModel, temporaryRecipeDataAccessObject, savedRecipeDataAccessObject);
//
//        DeleteController deleteController = DeleteUseCaseFactory.create(saveViewModel, temporaryRecipeDataAccessObject, savedRecipeDataAccessObject);
//    }
//
//    @Test
//    void execute() {
//        SaveInputData saveInputData = new SaveInputData(1);
//        saveController.execute(1);
//    }
//}
//
