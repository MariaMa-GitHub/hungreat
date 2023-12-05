package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {
    private  Recipe recipe;
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
        Recipe giveRecipe = new Recipe(9, "title", "url", "imageUrl", info, nutrition);
        ArrayList<Recipe> savedRecipes = new ArrayList<>();
        savedRecipes.add(giveRecipe);
        recipe = giveRecipe;
    }
    @Test
    void getId() {
        assertEquals(9, recipe.getID());
    }

    @Test
    void getTitle() {
        assertEquals("title", recipe.getTitle());
    }

    @Test
    void getUrl() {
        assertEquals("url", recipe.getUrl());
    }

    @Test
    void getImageUrl() {
        assertEquals("imageUrl", recipe.getImageUrl());
    }

    @Test
    void getInfo() {
        assertEquals("Apple" + "\n", recipe.getInfo().ingredientsToString());
    }

    @Test
    void getNutrition() {
        assertEquals("value", recipe.getNutrition().getNutrients().get("key"));
    }

    @Test
    void testToString() {
        assertEquals( "title" + "\n" +
                "Servings:2" + "\n" +
                "ReadyInMinutes:3" + "\n" +
                "HealthScore:4" + "\n" +
                "Ingredients:" + "\n" +
                "Apple" + "\n" + "\n" +
                "Instructions:" + "\n" +
                "1: fried in pan." + "\n", recipe.toString());
    }

    @Test
    void nutritionToString() {
        assertEquals(
                "key: value" + "\n", recipe.nutritionToString());
    }
}
