package app;

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

    public static BrowseController create(BrowseDataAccessInterface dataAccessObject) {

        try {
            BrowseController browseController = createBrowseUseCase(dataAccessObject);
            return browseController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open data file.");
        }

        return null;
    }

    private static BrowseController createBrowseUseCase(BrowseDataAccessInterface dataAccessObject) throws IOException {

        BrowseOutputBoundary browseOutputBoundary = new BrowsePresenter();

        BrowseInputBoundary browseInteractor = new BrowseInteractor(dataAccessObject, browseOutputBoundary);

        return new BrowseController(browseInteractor);
    }

}
