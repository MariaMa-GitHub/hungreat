package use_case.browse;

import entity.Recipe;

import java.util.ArrayList;
import java.util.Map;

public class BrowseOutputData {
    final Map<Integer, String>  id_title;
    public BrowseOutputData(Map<Integer, String> id_title){
        this.id_title = id_title;
    }
    public Map<Integer, String> getID_title(){
        return id_title;
    }

}
