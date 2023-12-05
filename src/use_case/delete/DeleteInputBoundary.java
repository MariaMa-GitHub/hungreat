package use_case.delete;

import use_case.delete.DeleteInputData;

import java.io.IOException;

public interface DeleteInputBoundary {
    void execute(DeleteInputData deleteInputData) throws IOException, ClassNotFoundException;
}
