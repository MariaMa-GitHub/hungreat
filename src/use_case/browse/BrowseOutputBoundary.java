package use_case.browse;

public interface BrowseOutputBoundary {
    void prepareSuccessView(BrowseOutputBoundary user);

    void prepareFailView(String error);


}
