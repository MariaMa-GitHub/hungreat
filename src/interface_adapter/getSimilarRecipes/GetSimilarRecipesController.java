package interface_adapter.getSimilarRecipes;

import use_case.getSimilarRecipes.GetSimilarRecipesInputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesInputData;

public class GetSimilarRecipesController {
    final GetSimilarRecipesInputBoundary getSimilarRecipesInteractor;

    public GetSimilarRecipesController(GetSimilarRecipesInputBoundary getSimilarRecipesInteractor){
        this.getSimilarRecipesInteractor = getSimilarRecipesInteractor;
    }

    public void execute(Integer recipeID) {
        GetSimilarRecipesInputData getSimilarRecipesInputData= new GetSimilarRecipesInputData(recipeID);
        getSimilarRecipesInteractor.execute(getSimilarRecipesInputData);
    }
}
