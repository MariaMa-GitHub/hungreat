package data_access;

import entity.Recipe;
import use_case.create.CreateDataAccessInterface;
import use_case.delete.DeleteDataAccessInterface;
import use_case.save.SaveDataAccessInterface;

import java.io.*;
import java.util.ArrayList;

/**
 * Utilizing serialization to save recipes to a file
 */

public class SavedRecipeDataAccessObject implements SaveDataAccessInterface, CreateDataAccessInterface, DeleteDataAccessInterface {
    private ArrayList<Recipe> savedRecipes;
    private Recipe deletedRecipes;

    public SavedRecipeDataAccessObject() throws IOException, ClassNotFoundException {

        this.savedRecipes = new ArrayList<>();
        this.read();
    }

    public ArrayList<Recipe> getSavedRecipes() {
        return savedRecipes;
    }


    @Override
    public void delete(Recipe recipe) throws IOException, ClassNotFoundException {
        if (savedRecipes.contains(recipe)){
            savedRecipes.remove(recipe);

            // Serializing 'a'
            FileOutputStream fos = new FileOutputStream("SavedRecipes.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(savedRecipes);

            // closing streams
            oos.close();
        }
        else{
            throw new RuntimeException("Recipe not found");
        }
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}