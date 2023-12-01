package app;

import data_access.RecipeDataAccessObject;
import data_access.TemporaryRecipeDataAccessObject;
import interface_adapter.DisplayViewModel;
import interface_adapter.browse.BrowseController;
import interface_adapter.recommend.RecommendController;
import view.HomeView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Hungreat");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        DisplayViewModel displayViewModel = new DisplayViewModel();

        RecipeDataAccessObject dataAccessObject = new RecipeDataAccessObject();
        TemporaryRecipeDataAccessObject temporaryRecipeDataAccessObject = new TemporaryRecipeDataAccessObject();


        BrowseController browseController = BrowseUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);

        RecommendController recommendController = RecommendUseCaseFactory.create(dataAccessObject, temporaryRecipeDataAccessObject, displayViewModel);
        HomeView homeView = new HomeView(browseController, recommendController, displayViewModel);


        application.add(homeView);


        application.pack();

        application.setSize(800, 600);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}