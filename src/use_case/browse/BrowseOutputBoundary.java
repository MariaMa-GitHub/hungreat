package use_case.browse;

import java.util.Map;

public interface BrowseOutputBoundary {
    void prepareSuccessView(BrowseOutputData idTitle);

    void prepareFailView(String error);


}
