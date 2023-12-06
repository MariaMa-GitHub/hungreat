package interface_adapter.create;

import data_access.RecipeDataAccessObject;
import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionDataFactory;
import entity.Recipe;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import interface_adapter.DisplayViewModel;
import interface_adapter.SaveState;
import interface_adapter.SaveViewModel;
import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendPresenter;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.create.*;
import org.junit.jupiter.api.Test;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendOutputBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePresenterTest {
    @Test
    void successTest() {

        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        CreateDataAccessInterface dataAccessObject = null;
        try {
            dataAccessObject = new SavedRecipeDataAccessObject();
        } catch (Exception e) {

        }

        SaveViewModel saveViewModel = new SaveViewModel();
        CreateOutputBoundary presenter = new CreatePresenter(saveViewModel);

        CreateInputBoundary interactor = new CreateInteractor(
                dataAccessObject,
                presenter,
                new RecipeFactory(),
                new RecipeInfoFactory(),
                temporaryRecipeDataAccessObject
        );

        CreateController controller = new CreateController(interactor);

        controller.execute(
                "title",
                1,
                30,
                new ArrayList<>(),
                new ArrayList<>()
        );

        SaveState state = saveViewModel.getState();

        assertNotNull(state.getSavedRecipes());

    }

    @Test
    void failTest() {

        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject2 = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        CreateDataAccessInterface dataAccessObject2 = null;
        try {
            dataAccessObject2 = new SavedRecipeDataAccessObject() {
                @Override
                public void save(Recipe recipe) throws IOException, ClassNotFoundException{
                    throw new IOException();
                }
            };
        } catch (Exception e) {

        }

        SaveViewModel saveViewModel2 = new SaveViewModel();
        CreateOutputBoundary presenter2 = new CreatePresenter(saveViewModel2);

        CreateInputBoundary interactor2 = new CreateInteractor(
                dataAccessObject2,
                presenter2,
                new RecipeFactory(),
                new RecipeInfoFactory(),
                temporaryRecipeDataAccessObject2
        );

        CreateController controller2 = new CreateController(interactor2);

        controller2.execute(
                "title",
                1,
                30,
                new ArrayList<>(),
                new ArrayList<>()
        );

        SaveState state = saveViewModel2.getState();
        assertNotNull(state.getError());

    }
}
