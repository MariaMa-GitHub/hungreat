package interface_adapter.analysis;

import interface_adapter.AnalysisViewModel;
import use_case.analysis.AnalysisOutputBoundary;
import use_case.analysis.AnalysisOutputData;

public class AnalysisPresenter implements AnalysisOutputBoundary {
    private final AnalysisViewModel analysisViewModel;

    public AnalysisPresenter(AnalysisViewModel analysisViewModel) {
        this.analysisViewModel = analysisViewModel;
    }

    @Override
    public void prepareView(AnalysisOutputData nutritionToString) {
        //change data type from AnalysisOutputData to string when pass in to analysisViewModel's method
        analysisViewModel.setNutritionToString(nutritionToString.getNutritionToString());
    }

}
