package interface_adapter;

import entity.Recipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class DisplayViewModel {

    private ArrayList<Recipe> recipes = new ArrayList<>();

    public DisplayViewModel() {
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {

        this.recipes = recipes;

    }

}
