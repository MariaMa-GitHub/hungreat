package entity;

import java.util.Collection;

public class Recipe extends BaseRecipe{

    private final String url;
    private final String imageUrl;
    private final RecipeInfo info;
    private final NutritionData nutrition;
    private Collection<Recipe> similarRecipes;

    public Recipe(int ID, String title, String url, String imageUrl, RecipeInfo info, NutritionData nutrition) {
        super(ID, title);
        this.url = url;
        this.imageUrl = imageUrl;
        this.info = info;
        this.nutrition = nutrition;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeInfo getInfo() {
        return info;
    }

    public NutritionData getNutrition() {
        return nutrition;
    }

    public Collection<Recipe> getSimilarRecipes() {
        return similarRecipes;
    }
    //TODO Wright a toString method prepare for display.
    @Override
    public String toString(){
        return super.getTitle() + "\n" + info.toString();
    }
}
