package app;

import entity.RecipeFactory;
import entity.RecipeInfoFactory;
import interface_adapter.SaveViewModel;
import interface_adapter.create.CreateController;
import interface_adapter.create.CreatePresenter;
import use_case.create.CreateDataAccessInterface;
import use_case.create.CreateInputBoundary;
import use_case.create.CreateInteractor;
import use_case.create.CreateOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class CreateUseCaseFactory {
    private CreateUseCaseFactory() {}

    public static CreateController create(CreateDataAccessInterface dataAccessObject, SaveViewModel saveViewModel) {

        try {
            CreateController createController = createCreateUseCase(dataAccessObject, saveViewModel);
            return createController;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to save the recipe.");
        }

        return null;
    }

    private static CreateController createCreateUseCase(CreateDataAccessInterface dataAccessObject, SaveViewModel saveViewModel) throws IOException{

        CreateOutputBoundary createOutputBoundary = new CreatePresenter(saveViewModel);

        RecipeFactory recipeFactory = new RecipeFactory();
        RecipeInfoFactory recipeInfoFactory = new RecipeInfoFactory();

        CreateInputBoundary createInteractor = new CreateInteractor(dataAccessObject, createOutputBoundary, recipeFactory, recipeInfoFactory);

        return new CreateController(createInteractor);
    }

}
