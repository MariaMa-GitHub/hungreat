package interface_adapter.browse;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import entity.NutritionDataFactory;
import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import interface_adapter.DisplayViewModel;
import interface_adapter.browse.BrowseController;
import interface_adapter.browse.BrowsePresenter;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.browse.*;
import use_case.browse.BrowseOutputBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BrowsePresenterTest {
    @Test
    void successTest() {

        TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject(new ArrayList<>());
        BrowseDataAccessInterface dataAccessObject = new RecipeDataAccessObject();

        DisplayViewModel displayViewModel = new DisplayViewModel();
        BrowseOutputBoundary successPresenter = new BrowsePresenter(displayViewModel);


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
        assertEquals(6, displayViewModel.getRecipes().size());
        for (Integer id : displayViewModel.getRecipes().keySet()) {
            assertFalse(displayViewModel.getRecipes().get(id).isEmpty());
            assertTrue(temporaryRecipeDataAccessObject.existsByID(id));
        }


    }

}
