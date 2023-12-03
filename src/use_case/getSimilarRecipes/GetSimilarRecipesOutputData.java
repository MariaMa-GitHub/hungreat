package use_case.getSimilarRecipes;

import java.util.Map;

public class GetSimilarRecipesOutputData {
    private final String idTitle;
    public GetSimilarRecipesOutputData(String idTitle){
        this.idTitle = idTitle;
    }
    public String getTitle(){
        return idTitle;
    }


}
