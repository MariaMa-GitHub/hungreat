package entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RecipeInfoTest {
    private RecipeInfo info;
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
    void getRecipeID() {
    }

    @Test
    void getServings() {
    }

    @Test
    void getReadyInMinutes() {
    }

    @Test
    void getHealthScore() {
    }

    @Test
    void getIngredients() {
    }

    @Test
    void getInstructions() {
    }

    @Test
    void ingredientsToString() {
    }

    @Test
    void testToString() {
    }

    @Test
    void instructionsToString() {
    }
}
