package app;

import interface_adapter.SaveViewModel;
import interface_adapter.delete.DeleteController;
import interface_adapter.delete.DeletePresenter;
import use_case.TemporaryRecipeDataAccessInterface;
import use_case.delete.DeleteDataAccessInterface;
import use_case.delete.DeleteInputBoundary;
import use_case.delete.DeleteInteractor;
import use_case.delete.DeleteOutputBoundary;

import javax.swing.*;

public class DeleteUseCaseFactory {
    private DeleteUseCaseFactory() {
    }

    public static DeleteController createDeleteUseCase(SaveViewModel saveViewModel, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface, DeleteDataAccessInterface deleteDataAccessInterface) {
        DeleteOutputBoundary deleteOutputBoundary = new DeletePresenter(saveViewModel);

        DeleteInputBoundary deleteInteractor = new DeleteInteractor(deleteOutputBoundary, temporaryRecipeDataAccessInterface, deleteDataAccessInterface);

        return new DeleteController(deleteInteractor);
    }

    public static DeleteController create(SaveViewModel saveViewModel, TemporaryRecipeDataAccessInterface temporaryRecipeDataAccessInterface, DeleteDataAccessInterface deleteDataAccessInterface) {
        try {
            DeleteController deleteController = createDeleteUseCase(saveViewModel, temporaryRecipeDataAccessInterface, deleteDataAccessInterface);
            return deleteController;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }
}
