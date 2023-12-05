package interface_adapter.create;

import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.create.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CreateControllerTest {
    @Test
    void successTest() {
        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject
                = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        CreateDataAccessInterface dataAccessObject = null;
        try {
            dataAccessObject = new SavedRecipeDataAccessObject();
        } catch (Exception e) {

        }

        CreateOutputBoundary presenter = new CreateOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOutputData response) {
                assertNotNull(response.getId());
                assertTrue(response.getId() < 0);
                assertNotNull(response.getTitle());
                assertTrue(temporaryRecipeDataAccessObject.existsByID(response.getId()));
            }

            public void prepareFailView(String response) {
                assertFalse(response.isEmpty());
            }
        };


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
                2,
                30,
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
}
