package use_case.browse;

import java.util.Map;

public interface BrowseOutputBoundary {
    void prepareSuccessView(BrowseOutputData id_title);

    void prepareFailView(String error);


}
