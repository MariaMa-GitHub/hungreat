package use_case.create;

import data_access.SavedRecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.Recipe;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import interface_adapter.create.CreateController;
import use_case.TemporaryRecipeDataAccessInterface;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CreateInteractorTest {
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
//                assertTrue(temporaryRecipeDataAccessObject.existsByID(response.getId()));
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
                -1,
                30,
                new ArrayList<>(),
                new ArrayList<>()
        );

        controller.execute(
                "title",
                2,
                -1,
                new ArrayList<>(),
                new ArrayList<>()
        );

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

        CreateInputBoundary interactor2 = new CreateInteractor(
                dataAccessObject2,
                presenter,
                new RecipeFactory(),
                new RecipeInfoFactory(),
                temporaryRecipeDataAccessObject
        );

        CreateController controller2 = new CreateController(interactor2);

        controller2.execute(
                "title",
                1,
                30,
                new ArrayList<>(),
                new ArrayList<>()
        );

    }
}
