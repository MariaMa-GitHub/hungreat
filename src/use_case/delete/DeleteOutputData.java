package use_case.delete;

import java.util.Map;

public class DeleteOutputData {
    private final Integer recipeID;
    private final String title;


    public DeleteOutputData(Integer recipeID, String title) {
        this.recipeID = recipeID;
        this.title = title;

    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public String getTitle() {
        return title;
    }

}