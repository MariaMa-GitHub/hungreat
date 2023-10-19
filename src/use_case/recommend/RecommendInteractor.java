package use_case.recommend;

import entity.RecipeFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;

import java.io.IOException;

public class RecommendInteractor implements RecommendInputBoundary {

    final RecommendDataAccessInterface dataAccessObject;
    final RecommendOutputBoundary recommendPresenter;
//    final RecipeFactory recipeFactory;

    public RecommendInteractor(RecommendDataAccessInterface dataAccessInterface,
                            RecommendOutputBoundary recommendOutputBoundary) {
        this.dataAccessObject = dataAccessInterface;
        this.recommendPresenter = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format(
                        "https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&cuisine=%s&excludeCuisine=%s&diet=%s&intolerances=%s&includeIngredients=%s&excludeIngredients=%s&number=6",
                        System.getenv("API_KEY"),
                        recommendInputData.getCuisine(),
                        recommendInputData.getExcludeCuisine(),
                        recommendInputData.getDiet(),
                        recommendInputData.getIntolerances(),
                        recommendInputData.getIngredients(),
                        recommendInputData.getExcludeIngredients()
                        )
                )
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

//        RecommendOutputData recommendOutputData = new RecommendOutputData();
//        recommendPresenter.prepareSuccessView(recommendOutputData);

    }
    
}
