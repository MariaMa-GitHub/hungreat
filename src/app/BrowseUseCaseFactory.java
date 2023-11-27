package app;

import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.DisplayViewModel;
import interface_adapter.browse.BrowseController;
import interface_adapter.browse.BrowsePresenter;
import use_case.browse.BrowseDataAccessInterface;
import use_case.browse.BrowseInputBoundary;
import use_case.browse.BrowseInteractor;
import use_case.browse.BrowseOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class BrowseUseCaseFactory {

    private BrowseUseCaseFactory() {}

    public static BrowseController create(BrowseDataAccessInterface dataAccessObject,TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject, DisplayViewModel displayViewModel) {

        try {
            BrowseController browseController = createBrowseUseCase(dataAccessObject,temporaryRecipeDataAccessObject, displayViewModel);
            return browseController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }

    private static BrowseController createBrowseUseCase(BrowseDataAccessInterface dataAccessObject,TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject, DisplayViewModel displayViewModel) throws IOException {

        BrowseOutputBoundary browseOutputBoundary = new BrowsePresenter(displayViewModel);

        BrowseInputBoundary browseInteractor = new BrowseInteractor(dataAccessObject, browseOutputBoundary, temporaryRecipeDataAccessObject);

        return new BrowseController(browseInteractor);
    }

}
