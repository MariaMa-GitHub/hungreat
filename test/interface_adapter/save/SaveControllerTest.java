package interface_adapter.save;

import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.Recipe;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.save.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveControllerTest {
    @Test
    void successtest() {
        new File("SavedRecipes.txt").delete();
        Recipe recipe = new Recipe(1, "title", "url", "imageurl", null, null);

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

        SaveController saveController = new SaveController(saveInteractor);
        saveController.execute(1);

    }
}
