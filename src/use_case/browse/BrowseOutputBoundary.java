package use_case.browse;

public interface BrowseOutputBoundary {
    void prepareSuccessView(BrowseOutputData recipes);

    void prepareFailView(String error);


}
