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



}
