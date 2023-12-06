package use_case.delete;

import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.Recipe;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.save.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DeleteInteractorTest {
    @Test
    void successTest() {
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);

        DeleteInputData deleteInputData = new DeleteInputData(1);
        DeleteDataAccessInterface savedDataAccessObject = null;
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        temporaryRecipeDataAccessObject.storeRecipe(recipe);
        try {
            SavedRecipeDataAccessObject object = new SavedRecipeDataAccessObject();
            object.save(recipe);
            savedDataAccessObject = object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        DeleteOutputBoundary deletePresenter = new DeleteOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteOutputData response) {
                assertEquals(1, response.getRecipeID());
                assertEquals("title", response.getTitle());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail();
            }
        };
        DeleteInteractor deleteInteractor = new DeleteInteractor(deletePresenter, temporaryRecipeDataAccessObject, savedDataAccessObject);
        deleteInteractor.execute(deleteInputData);
    }

    @Test
    void successTest2(){
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);


        DeleteInputData deleteInputData = new DeleteInputData(null);
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        temporaryRecipeDataAccessObject.storeRecipe(recipe);
        DeleteDataAccessInterface saveDataAccessObject = null;
        try {
            saveDataAccessObject = new SavedRecipeDataAccessObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        DeleteOutputBoundary deletePresenter = new DeleteOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteOutputData response) {
                assertEquals(1, response.getRecipeID());
            }
            @Override
            public void prepareFailView(String errorMessage) {

            }
        };
        DeleteInteractor deleteInteractor = new DeleteInteractor(deletePresenter, temporaryRecipeDataAccessObject, saveDataAccessObject);
        try{
            deleteInteractor.execute(deleteInputData);
        } catch (Exception e) {
            fail();
        }
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
