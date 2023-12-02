package use_case.getSimilarRecipes;

import java.util.Map;

public class GetSimilarRecipesOutputData {
    private final Map<Integer, String> idTitle;
    public GetSimilarRecipesOutputData(Map<Integer, String> idTitle){
        this.idTitle = idTitle;
    }
    public Map<Integer, String> getRecipes(){
        return idTitle;
    }
}
