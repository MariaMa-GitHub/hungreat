package data_access;

import entity.Recipe;

import java.io.*;
import java.util.ArrayList;

/**
 * Utilizing serialization to save recipes to a file
 */

public class SavedRecipeDataAccessObject {
    private ArrayList<Recipe> savedRecipes = new ArrayList<>();

    public SavedRecipeDataAccessObject() throws IOException, ClassNotFoundException {
        this.read();
    }

    public ArrayList<Recipe> getSavedRecipes() {
        return savedRecipes;
    }

    public void save(Recipe recipe) throws IOException, ClassNotFoundException {
        savedRecipes.add(recipe);

        // Serializing 'a'
        FileOutputStream fos = new FileOutputStream("SavedRecipes.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedRecipes);

        // closing streams
        oos.close();
    }

    public void read() {
        // De-serializing 'a'
        try {
            FileInputStream fis = new FileInputStream("SavedRecipes.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Recipe> previouslySavedRecipes = (ArrayList<Recipe>) ois.readObject(); // down-casting object
            savedRecipes = previouslySavedRecipes;

            // closing streams
            ois.close();
        } catch (IOException e) {
            System.out.println("No saved recipes found.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}