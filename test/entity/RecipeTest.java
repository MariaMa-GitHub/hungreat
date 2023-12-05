package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private  Recipe recipe;
    public RecipeInfo info;
    private Recipe recipeU;
    @BeforeEach
    void init() {
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        Collection<String> instructions = new ArrayList<>();
        instructions.add("fried in pan.");
        Map<String, String> nutrients = new HashMap<>();
        nutrients.put("key", "value");
        NutritionData nutrition = new NutritionData(9, nutrients);
        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
        RecipeInfo info2 = new RecipeInfo(2, 3, info.getIngredients(), info.getInstructions());
        Recipe recipe2 = new Recipe(1, "title", info2);
        Recipe giveRecipe = new Recipe(9, "title", "url", "imageUrl", info, nutrition);
        ArrayList<Recipe> savedRecipes = new ArrayList<>();
        ArrayList<Recipe> savedRecipes2 = new ArrayList<>();
        savedRecipes.add(giveRecipe);
        recipe = giveRecipe;
        savedRecipes2.add(recipe2);
        recipeU = recipe2;
    }

    @Test
    void getIdTest() {
        assertEquals(9, recipe.getID());
        assertEquals(1, recipeU.getID());
    }

    @Test
    void getTitleTest() {
        assertEquals("title", recipe.getTitle());
        assertEquals("title", recipeU.getTitle());
    }

    @Test
    void getUrlTest() {
        assertEquals("url", recipe.getUrl());
        assertNull(recipeU.getUrl());
    }

    @Test
    void getImageUrlTest() {
        assertEquals("imageUrl", recipe.getImageUrl());
        assertNull(recipeU.getImageUrl());
    }

    @Test
    void getInfoTest() {
        assertEquals("1:Apple" + "\n", recipe.getInfo().ingredientsToString());
        assertEquals("1:Apple" + "\n", recipeU.getInfo().ingredientsToString());
    }

    @Test
    void getNutritionTest() {
        assertEquals("value", recipe.getNutrition().getNutrients().get("key"));
        assertNull(recipeU.getNutrition());
    }

    @Test
    void ToStringTest() {
        assertEquals( "title" + "\n" +
                "Servings:2" + "\n" +
                "ReadyInMinutes:3" + "\n" +
                "HealthScore:4" + "\n" +
                "Ingredients:" + "\n" +
                "1:Apple" + "\n" + "\n" +
                "Instructions:" + "\n" +
                "1: fried in pan." + "\n", recipe.toString());
        assertEquals( "title" + "\n" +
                "Servings:2" + "\n" +
                "ReadyInMinutes:3" + "\n" +
                "Ingredients:" + "\n" +
                "1:Apple" + "\n" + "\n" +
                "Instructions:" + "\n" +
                "1: fried in pan." + "\n", recipeU.toString());
    }

    @Test
    void nutritionToStringTest() {
        assertEquals(
                "key: value" + "\n", recipe.nutritionToString());
        assertEquals(
                "The analyzing option is not available for user-created recipes.", recipeU.nutritionToString());
    }

    @Test
    void isUserCreatedRecipeTest() {
        assertFalse(recipe.isUserCreatedRecipe());
    }

    @Test
    void getSimilarRecipesTest() {
        assertNull(recipe.getSimilarRecipes());
    }
}
