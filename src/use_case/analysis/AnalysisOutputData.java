package use_case.analysis;

public class AnalysisOutputData {
    private final String nutritionToString;
    public AnalysisOutputData(String nutritionToString) {
        this.nutritionToString = nutritionToString;
    }
    public String getNutritionToString(){
        return nutritionToString;
    }
}
