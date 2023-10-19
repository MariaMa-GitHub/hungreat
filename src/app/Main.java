package app;

import data_access.RecipeDataAccessObject;
import interface_adapter.browse.BrowseController;
import view.HomeView;
import view.SearchView;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        RecipeDataAccessObject dataAccessObject;
//        try {
            dataAccessObject = new RecipeDataAccessObject();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject);
        HomeView homeView = new HomeView(browseController);


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