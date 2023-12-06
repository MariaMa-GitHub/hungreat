package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeInfoTest {
    public RecipeInfo info;
    @BeforeEach
    void init() {
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        Collection<String> instructions = new ArrayList<>();
        instructions.add("fried in pan.");
        Map<String, String> nutrients = new HashMap<>();
        nutrients.put("key", "value");
        NutritionData nutrition = new NutritionData(9, nutrients);
        info = new RecipeInfo(1, 2, 3, 4, ingredients, instructions);
    }
    @Test
    void getIdTest() {
        assertEquals(1, info.getRecipeID());
    }
    @Test
    void getServingsTest() {
        assertEquals(2, info.getServings());
    }

    @Test
    void getReadyInMinutesTest() {
        assertEquals(3, info.getReadyInMinutes());
    }

    @Test
    void getHealthScoreTest() {
        assertEquals(4, info.getHealthScore());
    }

    @Test
    void getIngredientsTest() {
        assertEquals("apple", info.getIngredients().toArray()[0]);
    }

    @Test
    void getInstructionsTest() {
        assertEquals("fried in pan.", info.getInstructions().toArray()[0]);
    }

    @Test
    void ingredientsToStringTest() {
        assertEquals("1:Apple" + "\n", info.ingredientsToString());
    }

    @Test
    void toStringTest() {
        assertEquals("Servings:2" + "\n" +
                "ReadyInMinutes:3" + "\n" +
                "HealthScore:4" + "\n" +
                "Ingredients:" + "\n" +
                "1:Apple" + "\n" + "\n" +

                "Instructions:" + "\n" +
                "1: fried in pan." + "\n", info.toString());
    }

    @Test
    void userCreatedRecipeToStringTest() {
        RecipeInfo info2 = new RecipeInfo(2, 3, info.getIngredients(), info.getInstructions());
        assertEquals("Servings:2" + "\n" +
                "ReadyInMinutes:3" + "\n" +
                "Ingredients:" + "\n" +
                "1:Apple" + "\n" + "\n" +

                "Instructions:" + "\n" +
                "1: fried in pan." + "\n", info2.toString());
    }

    @Test
    void instructionsToStringTest() {
        assertEquals("\n"+"1: fried in pan." + "\n", info.instructionsToString());
    }

    @Test
    void RecipeInfoTest() {
        RecipeInfo info = new RecipeInfo(1, 2, 3, 4, null, null);
        assertEquals(1, info.getRecipeID());
        assertEquals(2, info.getServings());
        assertEquals(3, info.getReadyInMinutes());
        assertEquals(4, info.getHealthScore());
        assertEquals(null, info.getIngredients());
    }

    @Test
    void RecipeInfoTest2() {
        RecipeInfo info2 = new RecipeInfo(2, 3, info.getIngredients(), info.getInstructions());
        assert (info2.getUserCreatedRecipeID() < 0);
        assertEquals(2, info2.getServings());
        assertEquals(3, info2.getReadyInMinutes());
        assertEquals(-1, info2.getHealthScore());
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        assertEquals(ingredients, info2.getIngredients());;
        assertEquals(true, info2.isUserCreatedRecipe());
    }

    @Test
    void isUserCreatedRecipeTest(){
        assertEquals(false, info.isUserCreatedRecipe());
    }

}
