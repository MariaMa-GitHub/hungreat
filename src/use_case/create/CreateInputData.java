package use_case.create;

import java.util.ArrayList;

public class CreateInputData {
    private final String title;
    private final int servings;
    private final int readyInMinutes;
    private final ArrayList<String> ingredients;
    private final ArrayList<String> instructions;

    public CreateInputData(String title,
                           int servings,
                           int readyInMinutes,
                           ArrayList<String> ingredients,
                           ArrayList<String> instructions) {
        this.title = title;
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public int getServings() {
        return servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }
}