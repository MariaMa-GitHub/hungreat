package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NutritionDataTest {
    public NutritionData nutrition;
    @BeforeEach
    void init() {
        Collection<String> ingredients = new ArrayList<>();
        ingredients.add("apple");
        Collection<String> instructions = new ArrayList<>();
        instructions.add("fried in pan.");
        Map<String, String> nutrients = new HashMap<>();
        nutrients.put("key", "value");
        nutrition = new NutritionData(9, nutrients);
    }

    @Test
    void getRecipeID() {
        assertEquals(9, nutrition.getRecipeID());
    }

    @Test
    void getNutrients() {
        assertEquals("value", nutrition.getNutrients().get("key"));
    }
}
