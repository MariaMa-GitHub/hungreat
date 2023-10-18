package entity;

import java.util.Map;

public class NutritionDataFactory {

    public NutritionData create(int recipeID, Map<String, Float> nutrients) {
        return new NutritionData(recipeID, nutrients);
    }

}
