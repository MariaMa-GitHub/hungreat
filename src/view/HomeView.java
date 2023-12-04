package view;

import interface_adapter.AnalysisViewModel;
import interface_adapter.DisplayViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.SaveViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.browse.BrowseController;
import interface_adapter.create.CreateController;
import interface_adapter.display.DisplayController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.recommend.RecommendController;
import interface_adapter.save.SaveController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class HomeView extends JPanel {

    final JButton create;
    final JButton browse;
    final JButton recommend;
    final JButton export;
    final JPanel savedRecipesList;
    final DisplayController displayController;

    public HomeView(
            BrowseController browseController,
            RecommendController recommendController,
            CreateController createController,
            AnalysisViewModel analysisViewModel,
            AnalysisController analysisController,
            DisplayViewModel displayViewModel,
            DisplayController displayController,
            RecipeViewModel recipeViewModel,
            GetSimilarRecipesController getSimilarRecipesController,
            SaveController saveController,
            SaveViewModel saveViewModel)
    {
        saveController.execute(null);

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(800, 600));
        this.displayController = displayController;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 100;
        JLabel appName = new JLabel("Hungreat", SwingConstants.CENTER);
        appName.setFont(new Font("Helvetica", Font.BOLD, 24));
        this.add(appName, gbc);

//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.ipady = 50;
//        JLabel slogan = new JLabel("Your Personalized Meal Planner", SwingConstants.CENTER);
//        slogan.setFont(new Font("Helvetica", Font.PLAIN, 16));
//        this.add(slogan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        create = new JButton("Create");
        this.add(create, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        browse = new JButton("Browse");
        this.add(browse, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        recommend = new JButton("View Recommendations");
        this.add(recommend, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        export = new JButton("Export");
        this.add(export, gbc);

        savedRecipesList = new JPanel(new GridLayout(0, 1));

        if (saveViewModel.getSavedRecipes()== null) {
            JLabel noSavedRecipes = new JLabel("No Saved Recipes");
            noSavedRecipes.setHorizontalAlignment(SwingConstants.CENTER);
            noSavedRecipes.setVerticalAlignment(SwingConstants.CENTER);
            savedRecipesList.add(noSavedRecipes);
        } else {
        for (int i = 0; i < saveViewModel.getSavedRecipes().size(); i++) {

            JButton button = getjButton(new ArrayList<>(saveViewModel.getSavedRecipes().keySet()), saveViewModel.getSavedRecipes(), i, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController);
            button.setPreferredSize(new Dimension(490, 100));
            savedRecipesList.add(button);

        }
    }



        JScrollPane scrPane = new JScrollPane(savedRecipesList);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.ipadx = 500;
        gbc.gridy = 0;
        gbc.gridheight = 6;
        this.add(scrPane, gbc);

        create.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(create)) {
                            // TODO (Michelle)
                            CreateView createView = new CreateView(
                                    createController,
                                    displayViewModel,
                                    displayController,
                                    recipeViewModel,
                                    analysisController,
                                    analysisViewModel);
                        }
                    }
                }
        );

        browse.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(browse)) {

                            // TODO (Everyone)
                            BrowseView browseView = new BrowseView(browseController, displayViewModel, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController);
                        }
                    }
                }
        );

        recommend.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(recommend)) {

                            // TODO (Maria)

                            RecommendView recommendView = new RecommendView(recommendController, displayViewModel, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController);

                        }
                    }
                }
        );

        export.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(export)) {

                            // TODO (Chloe)

                        }
                    }
                }
        );

    }

    @NotNull
    private static JButton getjButton(ArrayList<Integer> recipeIDs, Map<Integer, String> recipes, int i, DisplayController displayController, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController, GetSimilarRecipesController getSimilarRecipesController) {
        Integer recipeID = recipeIDs.get(i);

        JButton button = new JButton(recipes.get(recipeID));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(button)) {

                            displayController.execute(recipeID);
                            RecipeView recipeView = new RecipeView(recipeID, recipes.get(recipeID), recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, null, null);


                        }
                    }
                }
        );
        return button;
    }

}
