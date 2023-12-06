package use_case.save;

import data_access.TemporaryRecipeDataAccessObject;
import data_access.SavedRecipeDataAccessObject;
import entity.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveInteractorTest {
    @Test
    void successTest() {
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
        SaveOutputBoundary savePresenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData response) {
                assertEquals(1, response.getRecipeID());
                assertEquals("title", response.getTitle());
            }

            @Override
            public void prepareFailView(String errorMessage) {

                fail();
            }
        };
        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);
        saveInteractor.execute(saveInputData);

        assertEquals(1, saveDataAccessObject.getSavedRecipes().size());
    }

    @Test
    void successTest2(){
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);


        SaveInputData saveInputData = new SaveInputData(null);
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
        SaveOutputBoundary savePresenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData response) {
                assertEquals(1, response.getSavedRecipes().size());
            }
            @Override
            public void prepareFailView(String errorMessage) {
                fail();
            }
        };
        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);
        saveInteractor.execute(saveInputData);
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
        SaveOutputBoundary savePresenter = new SaveOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveOutputData response) {
                fail();
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Sorry an error has occurred. The recipe could not be saved. Please try again.", errorMessage);
            }
        };
        SaveInteractor saveInteractor = new SaveInteractor(savePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);
        saveInteractor.execute(saveInputData);

        assertEquals(0, saveDataAccessObject.getSavedRecipes().size());
    }
}
