package use_case.browse;

import entity.Recipe;

import java.util.ArrayList;

public interface BrowseDataAccessInterface {

    ArrayList<Recipe> browse(BrowseInputData browseInputData);

}
