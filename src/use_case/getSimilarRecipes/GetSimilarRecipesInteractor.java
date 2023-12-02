package use_case.getSimilarRecipes;


import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.getSimilarRecipes.GetSimilarRecipesOutputData;
import use_case.recommend.RecommendDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GetSimilarRecipesInteractor implements GetSimilarRecipesInputBoundary {
    final GetSimilarRecipesOutputBoundary getSimilarRecipesPresenter;
    final GetSimilarRecipesDataAccessInterface recipeDataAccessObject;


    public GetSimilarRecipesInteractor(GetSimilarRecipesDataAccessInterface recipeDataAccessObject,
                                       GetSimilarRecipesOutputBoundary getSimilarRecipesInputData){
        this.getSimilarRecipesPresenter = getSimilarRecipesInputData;
        this.recipeDataAccessObject = recipeDataAccessObject;
    }

    @Override
    public void execute(GetSimilarRecipesInputData getSimilarRecipesInputData) {
        Recipe recipe = null;
        try{
            ArrayList<Recipe> recipes = this.recipeDataAccessObject.getSimilarRecipes(getSimilarRecipesInputData.getRecipeID());
            //if not Arrylist then handle failveiw.If yes, then give presenter an arrylist of recipes.
            Map<Integer, String> idTitle = new HashMap<>();
            for (int i = 0; i < recipes.size(); i++) {
                Integer recipeID = recipes.get(i).getID();
                String recipeName = recipes.get(i).getTitle();
                idTitle.put(recipeID, recipeName);
            }
            GetSimilarRecipesOutputData getSimilarRecipesOutputData = new GetSimilarRecipesOutputData(idTitle);
            getSimilarRecipesPresenter.prepareSuccessView(getSimilarRecipesOutputData);
        }
        catch (Exception e){
            String errorMessage = e.getMessage();
            getSimilarRecipesPresenter.prepareFailView(errorMessage);
        }
    }
}