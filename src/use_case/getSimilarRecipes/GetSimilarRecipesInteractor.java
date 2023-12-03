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
                System.out.println(recipeName);
                title.append(recipeName).append("\n");
            }
            System.out.println(title.toString());
            GetSimilarRecipesOutputData getSimilarRecipesOutputData = new GetSimilarRecipesOutputData(title.toString());
            getSimilarRecipesPresenter.prepareView(getSimilarRecipesOutputData);
        }
        catch (Exception e){
            String errorMessage = e.getMessage();
            GetSimilarRecipesOutputData getSimilarRecipesOutputData = new GetSimilarRecipesOutputData(errorMessage);

            getSimilarRecipesPresenter.prepareView(getSimilarRecipesOutputData);
        }
    }
}