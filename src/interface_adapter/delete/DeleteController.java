package interface_adapter.delete;

import interface_adapter.SearchController;
import use_case.delete.DeleteInputBoundary;
import use_case.delete.DeleteInputData;

import java.io.IOException;

public class DeleteController implements SearchController {
    private final DeleteInputBoundary deleteInteractor;

    public DeleteController(DeleteInputBoundary deleteInteractor) {
        this.deleteInteractor = deleteInteractor;
    }

    public void execute(Integer recipeID) throws IOException, ClassNotFoundException {
        DeleteInputData deleteInputData = new DeleteInputData(recipeID);
        deleteInteractor.execute(deleteInputData);
    }
}
