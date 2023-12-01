package use_case.browse;

import entity.Recipe;

import java.util.ArrayList;
import java.util.Map;

public class BrowseOutputData {
    private final Map<Integer, String> idTitle;
    public BrowseOutputData(Map<Integer, String> idTitle){
        this.idTitle = idTitle;
    }
    public Map<Integer, String> getRecipes(){
        return idTitle;
    }

}
