package use_case.browse;

import java.util.Map;

public interface BrowseOutputBoundary {
    void prepareSuccessView(Map<Integer, String> id_title);

    void prepareFailView(String error);


}
