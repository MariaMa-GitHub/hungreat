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
            StringBuilder title = new StringBuilder();
            for (int i = 0; i < recipes.size(); i++) {
                String recipeName = recipes.get(i).getTitle();
                title.append(recipeName).append("\n");
            }
            GetSimilarRecipesOutputData getSimilarRecipesOutputData = new GetSimilarRecipesOutputData(title.toString());
            getSimilarRecipesPresenter.prepareView(getSimilarRecipesOutputData);
        }
        catch (Exception e){
            GetSimilarRecipesOutputData getSimilarRecipesOutputData = new GetSimilarRecipesOutputData("Get similar recipes is not available for user created recipes.");
                    getSimilarRecipesPresenter.prepareView(getSimilarRecipesOutputData);
        }
    }
}