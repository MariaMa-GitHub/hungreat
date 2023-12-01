package entity;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class Recipe {

    private int ID;
    private String title;
    private String url;
    private String imageUrl;
    private RecipeInfo info;
    private NutritionData nutrition;
    private Collection<Recipe> similarRecipes;

    public Recipe(int ID, String title, String url, String imageUrl, RecipeInfo info, NutritionData nutrition) {
        this.ID = ID;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.info = info;
        this.nutrition = nutrition;
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

    public Collection<Recipe> getSimilarRecipes() {
        return similarRecipes;
    }

    @Override
    public String toString(){
        return title + "\n" + info.toString();
    }
    // TODO Wright a toString method prepare for analysis.
    public String nutritionToString(){
        String nutritions = null;
       for (Map.Entry<String, String> entry : nutrition.getNutrients().entrySet()){
           String key = entry.getKey();
           String value = entry.getValue();
           nutritions = key + ":" + value;
       }
        return nutritions;
    }
}
