package use_case.getSimilarRecipes;

public class GetSimilarRecipesInputData {
    final private Integer recipeID;

    public GetSimilarRecipesInputData(Integer recipeID){
        this.recipeID = recipeID;
    }
    public Integer getRecipeID(){
        return recipeID;
    }
}
