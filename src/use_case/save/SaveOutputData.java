package use_case.save;

public class SaveOutputData {
    private final Integer recipeID;
    private final String title;

    public SaveOutputData(Integer recipeID, String title) {
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
