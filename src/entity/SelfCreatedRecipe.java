package entity;

import java.util.Collection;

public class SelfCreatedRecipe extends BaseRecipe{
    private final int servings;
    private final int readyInMinutes;
    private final Collection<String> ingredients;
    private final Collection<String> instructions;
    public SelfCreatedRecipe(int ID, String title, int servings, int readyInMinutes, Collection<String> ingredients, Collection<String> instructions) {
        super(ID, title);
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public Collection<String> getIngredients() {
        return ingredients;
    }

    public Collection<String> getInstructions() {
        return instructions;
    }

    public int getServings() {
        return servings;
    }

    public String toString() {
        return null;    //TODO
    }
}
