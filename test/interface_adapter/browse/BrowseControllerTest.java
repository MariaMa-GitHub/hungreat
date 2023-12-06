package interface_adapter.browse;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionDataFactory;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import interface_adapter.browse.BrowseController;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.browse.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BrwoseControlerTest {
    @Test
    void successTest() {

        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        BrowseDataAccessInterface dataAccessObject = new RecipeDataAccessObject();

        BrowseOutputBoundary successPresenter = new BrowseOutputBoundary() {
            @Override
            public void prepareSuccessView(BrowseOutputData response) {
                assertEquals(6, response.getRecipes().size());
                for (Integer id : response.getRecipes().keySet()) {
                    assertFalse(response.getRecipes().get(id).isEmpty());
                    assertTrue(temporaryRecipeDataAccessObject.existsByID(id));
                }
            }


        };

        BrowseInputData inputData = new BrowseInputData(

                new ArrayList<>(List.of("Asian")),
                new ArrayList<>(List.of("")),
                new ArrayList<>(List.of("")),
                new ArrayList<>(List.of("")),
                Map.of("Carbs", new Float[]{1f, 100f}),
                ""

        );

        BrowseInputBoundary interactor = new BrowseInteractor(dataAccessObject, successPresenter, temporaryRecipeDataAccessObject);
        BrowseController controller = new BrowseController(interactor);

        controller.execute(new ArrayList<>(List.of("Asian")),
                new ArrayList<>(List.of("")),
                new ArrayList<>(List.of("")),
                new ArrayList<>(List.of("")),
                Map.of("Carbs", new Float[]{1f, 100f}),
                ""

        );


    }

}