package app;

import interface_adapter.SaveViewModel;
import interface_adapter.save.SaveController;
import interface_adapter.save.SavePresenter;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.browse.BrowseInputBoundary;
import use_case.browse.BrowseInteractor;
import use_case.save.*;

import javax.swing.*;

public class SaveUseCaseFactory {
    private SaveUseCaseFactory() {
    }

    public static SaveController createSaveUseCase(SaveViewModel saveViewModel, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface, SaveDataAccessInterface saveDataAccessInterface) {
        SaveOutputBoundary saveOutputBoundary = new SavePresenter(saveViewModel);

        SaveInputBoundary saveInteractor = new SaveInteractor(saveOutputBoundary, temporaryRecipeDataAccessInterface, saveDataAccessInterface);

        return new SaveController(saveInteractor);
    }

    public static SaveController create(SaveViewModel saveViewModel, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface, SaveDataAccessInterface saveDataAccessInterface) {
        try {
            SaveController saveController = createSaveUseCase(saveViewModel, temporaryRecipeDataAccessInterface, saveDataAccessInterface);
            return saveController;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }
}