package use_case.delete;

import use_case.delete.DeleteOutputData;

public interface DeleteOutputBoundary {
    void prepareSuccessView(DeleteOutputData deleteOutputData);
    void prepareFailView(String error);
}
