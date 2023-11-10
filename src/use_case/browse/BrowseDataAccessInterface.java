package use_case.browse;

import entity.BrowseFilter;
import entity.Filter;
import entity.Recipe;

import java.util.ArrayList;

public interface BrowseDataAccessInterface {

    ArrayList<Recipe> browse(BrowseFilter browseFilter);

}
