package interface_adapter.save;

import entity.Recipe;
import interface_adapter.SearchController;
import use_case.save.SaveInputBoundary;
import use_case.save.SaveInputData;

import java.util.ArrayList;

public class SaveController implements SearchController {
    private final SaveInputBoundary saveInteractor;

    public SaveController(SaveInputBoundary saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    public void execute(Integer recipeID) {
        SaveInputData saveInputData = new SaveInputData(recipeID);
        saveInteractor.execute(saveInputData);
    }

    // TODO: Make the empty execute method call the execute empty method from SavedInteraction which read inside the SavedRecipeDAO
//    public void execute() {
//        saveInteractor.execute();
//    }
}
