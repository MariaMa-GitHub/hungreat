package interface_adapter.analysis;

import use_case.analysis.AnalysisInputData;
import use_case.analysis.AnalysisInteractor;
import use_case.analysis.AnalysisInputBoundary;
import use_case.analysis.AnalysisInputData;

public class AnalysisController {
    final AnalysisInputBoundary analysisInteractor;

    public AnalysisController(AnalysisInputBoundary analysisInteractor){
        this.analysisInteractor = analysisInteractor;
    }

    public void execute(Integer recipeID) {
        AnalysisInputData analysisInputData= new AnalysisInputData(recipeID);
        analysisInteractor.execute(analysisInputData);
    }
}