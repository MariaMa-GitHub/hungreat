package use_case.delete;

public class DeleteInputData {
    private final Integer recipeID;

    public DeleteInputData(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Integer getRecipeID() {
        return recipeID;
    }
}
