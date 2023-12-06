package interface_adapter;

public class RecipeViewModel{
    private String recipeString;
    private String tittle;

    // because we do not know what variable we need to pass in while we create RecipeViewModel in main
    // so here initializer is empty , we use set method to initialize RecipeViewModel.
    public RecipeViewModel() {
    }

    public void setRecipeString(String recipeString) {
        this.recipeString = recipeString;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getRecipeString() {
            return recipeString;
    }

    public String getTitle() {
        return tittle;
    }
}
