package use_case.save;

public class SaveInputData {
    private final Integer recipeID;

    public SaveInputData(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

}
