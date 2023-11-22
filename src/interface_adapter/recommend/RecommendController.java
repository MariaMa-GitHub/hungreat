package interface_adapter.recommend;

import interface_adapter.SearchController;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecommendController implements SearchController {

    final RecommendInputBoundary recommendInteractor;

    public RecommendController(RecommendInputBoundary recommendInteractor) {
        this.recommendInteractor = recommendInteractor;
    }

    public void execute(ArrayList<String> cuisine, ArrayList<String> excludeCuisine, ArrayList<String> diet, ArrayList<String> intolerances, ArrayList<String> ingredients, ArrayList<String> excludeIngredients, Map<String, Float[]> nutrients) {

        RecommendInputData recommendInputData = new RecommendInputData(cuisine, excludeCuisine, diet, intolerances, ingredients, excludeIngredients, nutrients);

        recommendInteractor.execute(recommendInputData);

    }
    
}
