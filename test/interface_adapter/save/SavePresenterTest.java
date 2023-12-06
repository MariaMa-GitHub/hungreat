package interface_adapter.save;

import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.Recipe;
import interface_adapter.SaveState;
import interface_adapter.SaveViewModel;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.save.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SavePresenterTest {
    @Test
    void successtest1() {
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);

        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        temporaryRecipeDataAccessObject.storeRecipe(recipe);
        SaveDataAccessInterface saveDataAccessObject = null;
        try {
            saveDataAccessObject = new SavedRecipeDataAccessObject();
            saveDataAccessObject.save(recipe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        SaveViewModel saveViewModel = new SaveViewModel();

        SaveOutputBoundary savePresenter = new SavePresenter(saveViewModel);

        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);

        SaveController saveController = new SaveController(saveInteractor);
        saveController.execute(null);

        SaveState state = saveViewModel.getState();
        assertEquals(1, state.getSavedRecipes().size());
    }

    @Test
    void successtest2() {
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);

        SaveInputData saveInputData = new SaveInputData(1);
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        temporaryRecipeDataAccessObject.storeRecipe(recipe);
        SaveDataAccessInterface saveDataAccessObject = null;
        try {
            saveDataAccessObject = new SavedRecipeDataAccessObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        SaveViewModel saveViewModel = new SaveViewModel();

        SaveOutputBoundary savePresenter = new SavePresenter(saveViewModel);

        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);

        SaveController saveController = new SaveController(saveInteractor);
        saveController.execute(1);

        SaveState state = saveViewModel.getState();
        assertEquals(1, state.getSavedRecipes().size());
    }


    @Test
    void failTest() {
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);

        SaveInputData saveInputData = new SaveInputData(1);
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        temporaryRecipeDataAccessObject.storeRecipe(recipe);
        SaveDataAccessInterface saveDataAccessObject = null;
        try {
            saveDataAccessObject = new SavedRecipeDataAccessObject() {
                @Override
                public void save(Recipe recipe) throws IOException, ClassNotFoundException {
                    throw new IOException();
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        SaveViewModel saveViewModel = new SaveViewModel();

        SaveOutputBoundary savePresenter = new SavePresenter(saveViewModel);

        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);

        SaveController saveController = new SaveController(saveInteractor);
        saveController.execute(1);

        SaveState state = saveViewModel.getState();
        assertEquals(0, state.getSavedRecipes().size());
    }
}
