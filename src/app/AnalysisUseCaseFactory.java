package app;

import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.AnalysisViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.analysis.AnalysisPresenter;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.analysis.AnalysisInputBoundary;
import use_case.analysis.AnalysisInteractor;
import use_case.analysis.AnalysisOutputBoundary;


import javax.swing.*;
import java.io.IOException;

public class AnalysisUseCaseFactory {
    private AnalysisUseCaseFactory(){}
    public static AnalysisController create(TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject, AnalysisViewModel analysisViewModel) {

        try {
            AnalysisController analysisController = createAnalysisUseCase(temporaryRecipeDataAccessObject, analysisViewModel);
            return analysisController;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open recipe");
        }

        return null;
    }

    private static AnalysisController createAnalysisUseCase(TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject, AnalysisViewModel analysisViewModel) throws IOException{

        AnalysisOutputBoundary analysisOutputBoundary = new AnalysisPresenter(analysisViewModel);

        AnalysisInputBoundary analysisInteractor = new AnalysisInteractor(temporaryRecipeDataAccessObject, analysisOutputBoundary);

        return new AnalysisController(analysisInteractor);
    }
}
