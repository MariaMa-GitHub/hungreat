package use_case.create;
public interface CreateOutputBoundary {
    void prepareSuccessView(CreateOutputData createOutputData);

    void prepareFailView(String error);
}