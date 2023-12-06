package use_case.recommend;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.TemporaryRecipeDataAccessInterface;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecommendInteractorTest {
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

       RecommendInputData inputData = new RecommendInputData(

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

       RecommendInputBoundary interactor = new RecommendInteractor(
               dataAccessObject,
               temporaryRecipeDataAccessObject,
               successPresenter
       );

       interactor.execute(inputData);


   }

}