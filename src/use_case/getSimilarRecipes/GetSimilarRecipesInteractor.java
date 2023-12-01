package use_case.getSimilarRecipes;


import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesInputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesInputData;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputBoundary;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputData;


public class GetSimilarRecipesInteractor implements GetSimilarRecipesInputBoundary {
    final GetSimilarRecipesOutputBoundary getSimilarRecipesPresenter;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject;


    public GetSimilarRecipesInteractor(TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject,
                                      GetSimilarRecipesOutputBoundary getSimilarRecipesOutputBoundary){
        this.getSimilarRecipesPresenter = getSimilarRecipesOutputBoundary;
        this.temporaryRecipeDataAccessObject = temporaryRecipeDataAccessObject;
    }

    @Override
    public void execute(GetSimilarRecipesInputData getSimilarRecipesInputData) {
        Recipe recipe = null;
        try {
            Integer recipeID =  getSimilarRecipesInputData.getRecipeID();
            recipe = temporaryRecipeDataAccessObject.getFromID(recipeID);
            GetSimilarRecipesOutputData getSimilarRecipesOutputData = new GetSimilarRecipesOutputData(recipe.toString());
            getSimilarRecipesPresenter.prepareView(getSimilarRecipesOutputData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}