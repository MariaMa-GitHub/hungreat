package app;

import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendPresenter;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class RecommendUseCaseFactory {

    private RecommendUseCaseFactory() {}

    public static RecommendController create(RecommendDataAccessInterface dataAccessObject) {

        try {
            RecommendController recommendController = createRecommendUseCase(dataAccessObject);
            return recommendController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }

    private static RecommendController createRecommendUseCase(RecommendDataAccessInterface dataAccessObject) throws IOException {

        RecommendOutputBoundary recommendOutputBoundary = new RecommendPresenter();

        RecommendInputBoundary recommendInteractor = new RecommendInteractor(dataAccessObject, recommendOutputBoundary);

        return new RecommendController(recommendInteractor);
    }
    
}
