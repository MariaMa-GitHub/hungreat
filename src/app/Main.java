package app;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.DisplayViewModel;
import interface_adapter.browse.BrowseController;
import interface_adapter.recommend.RecommendController;
import view.HomeView;
import view.RecipeView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DisplayViewModel displayViewModel = new DisplayViewModel();

        RecipeDataAccessObject dataAccessObject;
        TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject;
//        try {
            dataAccessObject = new RecipeDataAccessObject();
            temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject);

        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);
        HomeView homeView = new HomeView(browseController, recommendController, displayViewModel);


        application.add(homeView);








        application.pack();

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);




//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url(String.format("https://api.spoonacular.com/recipes/complexSearch?apiKey=%s&query=%s&number=%s", System.getenv("API_KEY"), "lobster", "1"))
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response.body().string());
//        }
//        catch (IOException | JSONException e) {
//            throw new RuntimeException(e);
//        }

    }

}