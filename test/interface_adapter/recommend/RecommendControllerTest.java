package interface_adapter.recommend;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionDataFactory;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.recommend.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RecommendControllerTest {

    @Test
    void successTest() {

        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        RecommendDataAccessInterface dataAccessObject = new RecipeDataAccessObject();

        RecommendOutputBoundary successPresenter = new RecommendOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendOutputData response) {
                assertEquals(6, response.getRecipes().size());
                for (Integer id : response.getRecipes().keySet()) {
                    assertFalse(response.getRecipes().get(id).isEmpty());
                    assertTrue(temporaryRecipeDataAccessObject.existsByID(id));
                }
            }
        };

        RecommendInputBoundary interactor = new RecommendInteractor(
                dataAccessObject,
                temporaryRecipeDataAccessObject,
                successPresenter
        );

        RecommendController controller = new RecommendController(interactor);

        controller.execute(
                new ArrayList<>(List.of("Asian")),
                new ArrayList<>(List.of("Thai")),
                new ArrayList<>(List.of("Vegetarian")),
                new ArrayList<>(List.of("Peanut")),
                new ArrayList<>(),
                new ArrayList<>(),
                Map.of(
                        "Carbs", new Float[]{1f, 100f}
                )
        );

    }

}