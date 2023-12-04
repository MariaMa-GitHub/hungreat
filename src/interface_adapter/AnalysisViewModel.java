package interface_adapter;

public class AnalysisViewModel{
    private String analysisString;
    //cause we do not know what variable we need to pass in while we create AnalysisViewModel in main
    // so here initializer is empty , we use set method to initialize AnalysisViewModel.
    public AnalysisViewModel() {
    }

    public void setNutritionToString(String analysisString) {
        this.analysisString = analysisString;
    }

    public String getNutritionToString() {
        return analysisString;
    }
}
