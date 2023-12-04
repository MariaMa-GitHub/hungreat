package interface_adapter.create;

import use_case.create.CreateInputBoundary;
import use_case.create.CreateInputData;

import java.util.ArrayList;

public class CreateController {

    final CreateInputBoundary createInteractor;

    public CreateController(CreateInputBoundary createInteractor) {

        this.createInteractor = createInteractor;

    }

    public void execute(
            String title,
            int servings,
            int readyInMinutes,
            ArrayList<String> ingredients,
            ArrayList<String> instructions ) {

        CreateInputData createInputData =
                new CreateInputData(title, servings, readyInMinutes, ingredients, instructions);

        createInteractor.execute(createInputData);

    }
}
