package interface_adapter.browse;

import java.util.Map;
import use_case.browse.BrowseOutputBoundary;
import use_case.browse.BrowseOutputData;

public class BrowsePresenter implements BrowseOutputBoundary {

    @Override
    public void prepareSuccessView(BrowseOutputData idTitleData) {
        // Process BrowseOutputData and display success view accordingly
        Map<Integer, String> idTitleMap = idTitleData.getID_title();
        for (Map.Entry<Integer, String> entry : idTitleMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("Successful view prepared");
    }

    @Override
    public void prepareFailView(String error) {
        // Display error view with the provided error message
        System.err.println("Error occurred: " + error);
    }
}

