package use_case.browse;

import entity.Recipe;

import java.util.ArrayList;

public class BrowseOutputData {
    final ArrayList<Recipe> recipes;
    public BrowseOutputData(ArrayList<Recipe> recipes){
        this.recipes = recipes;
    }
    public ArrayList<Recipe> getRecipes(){
        return recipes;
    }

}
