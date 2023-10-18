package entity;

public class RecipeFactory {

    public Recipe create(int ID, String title, String url, String imageUrl, RecipeInfo info, NutritionData nutrition) {

        return new Recipe(ID, title, url, imageUrl, info, nutrition);

    }

}
