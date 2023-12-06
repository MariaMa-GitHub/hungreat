package app;

import interface_adapter.DisplayViewModel;
import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendPresenter;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class RecommendUseCaseFactory {

    private RecommendUseCaseFactory() {}

    public static RecommendController create(RecommendDataAccessInterface dataAccessObject, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject, DisplayViewModel displayViewModel) {

        try {
            RecommendController recommendController = createRecommendUseCase(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);
            return recommendController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }

    private static RecommendController createRecommendUseCase(RecommendDataAccessInterface dataAccessObject, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessObject, DisplayViewModel displayViewModel) throws IOException {

        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter(displayViewModel);

        RecommendInputBoundary recommendInteractor = new RecommendInteractor(dataAccessObject, temporaryRecipeDataAccessObject, recommendOutputBoundary);

        return new RecommendController(recommendInteractor);
    }
    
}
