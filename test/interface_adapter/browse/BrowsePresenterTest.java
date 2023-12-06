//package interface_adapter.browse;
//
//import app.MockRecipeDataAccessObject;
//import entity.NutritionData;
//import entity.Recipe;
//import entity.RecipeInfo;
//import interface_adapter.RecipeViewModel;
//import interface_adapter.browse.BrowseController;
//import interface_adapter.browse.BrowsePresenter;
//import org.junit.jupiter.api.Test;
//import use_case.browse.BrowseDataAccessInterface;
//import use_case.browse.BrowseInputBoundary;
//import use_case.browse.BrowseInteractor;
//import use_case.browse.BrowseOutputBoundary;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class BrowsePresenterTest {
//    @Test
//    void successTest() {
//        Collection<String> ingredients = new ArrayList<>();
//        ingredients.add("apple");
//        Collection<String> instructions = new ArrayList<>();
//        instructions.add("fried in pan.");
//        Map<String, String> nutrients = new HashMap<>();
//        nutrients.put("key", "value");
//        NutritionData nutrition = new NutritionData(9, nutrients);
//        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
//        Recipe giveRecipe = new Recipe(9, "title", "url", "imageUrl", info, nutrition);
//        ArrayList<Recipe> savedRecipes = new ArrayList<>();
//        savedRecipes.add(giveRecipe);
//        BrowseDataAccessInterface mockRecipeDataAccessObject = new MockRecipeDataAccessObject();
//
//
//        RecipeViewModel recipeViewModel = new RecipeViewModel();
//        BrowseOutputBoundary successPresenter = new BrowsePresenter(recipeViewModel);
//
//
//        BrowseInputBoundary interactor = new BrowseInteractor(mockRecipeDataAccessObject, successPresenter);
//        BrowseController controller = new BrowseController(interactor);
//        controller.execute(9);
//        assertEquals("title2"+"\n", recipeViewModel.getTittle());
//
//
//    }
//    @Test
//    void failTest() {
//        Collection<String> ingredients = new ArrayList<>();
//        ingredients.add("apple");
//        Collection<String> instructions = new ArrayList<>();
//        instructions.add("fried in pan.");
//        Map<String, String> nutrients = new HashMap<>();
//        nutrients.put("key", "value");
//        NutritionData nutrition = new NutritionData(9, nutrients);
//        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
//        Recipe recipe = new Recipe(0, "title", "url", "imageUrl", info, nutrition);
//        ArrayList<Recipe> savedRecipes = new ArrayList<>();
//        savedRecipes.add(recipe);
//        BrowseDataAccessInterface mockRecipeDataAccessObject = new MockRecipeDataAccessObject();
//
//
//        RecipeViewModel recipeViewModel = new RecipeViewModel();
//        BrowseOutputBoundary successPresenter = new BrowsePresenter(recipeViewModel);
//        BrowseInputBoundary interactor = new BrowseInteractor(mockRecipeDataAccessObject, successPresenter);
//        BrowseController controller = new BrowseController(interactor);
//        controller.execute(-1);
//        assertEquals("No similar recipes found.", recipeViewModel.getTittle());
//
//    }
//}
