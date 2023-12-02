package use_case.getSimilarRecipes;

public interface GetSimilarRecipesOutputBoundary {
    void prepareSuccessView(GetSimilarRecipesOutputData idTitle);

    void prepareFailView(String error);
}
