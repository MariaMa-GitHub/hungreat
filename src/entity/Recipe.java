package entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class Recipe{

    private int ID;
    private String title;
    private String url;
    private String imageUrl;
    private RecipeInfo info;
    private NutritionData nutrition;
    private Collection<Recipe> similarRecipes;
    private boolean isUserCreatedRecipe;
    private static int userCreatedRecipeID = -1;

    public Recipe(int ID, String title, String url, String imageUrl, RecipeInfo info, NutritionData nutrition) {
        this.ID = ID;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.info = info;
        this.nutrition = nutrition;
        this.isUserCreatedRecipe = false;
    }

    public Recipe(String title, RecipeInfo info) {
        //This constructor is only for user-created recipes
        this.ID = userCreatedRecipeID;
        userCreatedRecipeID--;
        this.title = title;
        this.info = info;
        this.url = null;
        this.imageUrl = null;
        this.nutrition = null;
        this.isUserCreatedRecipe = true;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
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

    public boolean isUserCreatedRecipe() {return isUserCreatedRecipe; }

    public Collection<Recipe> getSimilarRecipes() {
        return similarRecipes;
    }

    @Override
    public String toString(){
        return title + "\n" + info.toString();
    }
    // TODO Wright a toString method prepare for analysis.
    // TODO: update toString for user-created recipes
    public String nutritionToString(){
        StringBuilder nutritions = new StringBuilder();
       for (Map.Entry<String, String> entry : nutrition.getNutrients().entrySet()){
           String key = entry.getKey();
           String value = entry.getValue();
           nutritions.append(key).append(": ").append(value).append("\n");
       }
        return nutritions.toString();
    }
}
