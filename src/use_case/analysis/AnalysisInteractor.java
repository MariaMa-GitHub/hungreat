package use_case.analysis;

import entity.Recipe;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.analysis.AnalysisInputBoundary;
import use_case.analysis.AnalysisInputData;
import use_case.analysis.AnalysisOutputBoundary;
import use_case.analysis.AnalysisOutputData;

public class AnalysisInteractor implements AnalysisInputBoundary {
    final AnalysisOutputBoundary analysisPresenter;
    final TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject;


    public AnalysisInteractor(TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject,
                             AnalysisOutputBoundary analysisOutputBoundary){
        this.analysisPresenter = analysisOutputBoundary;
        this.temporaryRecipeDataAccessObject = temporaryRecipeDataAccessObject;
    }

    @Override
    public void execute(AnalysisInputData analysisInputData) {
        Integer recipeID =  analysisInputData.getRecipeID();
        try {
            Recipe recipe = temporaryRecipeDataAccessObject.getFromID(recipeID);
            AnalysisOutputData analysisOutputData = new AnalysisOutputData(recipe.nutritionToString());
            analysisPresenter.prepareView(analysisOutputData);
        } catch (Exception e) {
            AnalysisOutputData analysisOutputData = new AnalysisOutputData("Analysis not available for this recipe.");
            analysisPresenter.prepareView(analysisOutputData);
        }
    }
}
