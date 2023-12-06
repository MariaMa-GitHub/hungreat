package view;

import interface_adapter.*;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.browse.BrowseController;
import interface_adapter.create.CreateController;
import interface_adapter.delete.DeleteController;
import interface_adapter.display.DisplayController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.recommend.RecommendController;
import interface_adapter.save.SaveController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Map;

public class HomeView extends JPanel implements PropertyChangeListener {

    private Map<Integer, String> savedRecipes;
    final JButton create;
    final JButton browse;
    final JButton recommend;
    final JButton exit;
    final JPanel savedRecipesList;
    final DisplayController displayController;
    private RecipeViewModel recipeViewModel;

    private AnalysisViewModel analysisViewModel;

    private AnalysisController analysisController;

    private GetSimilarRecipesController getSimilarRecipesController;
    private SaveController saveController;
    private SaveViewModel saveViewModel;
    private DeleteController deleteController;

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
            SaveViewModel saveViewModel,
            DeleteController deleteController)
    {

        this.recipeViewModel = recipeViewModel;
        this.analysisViewModel = analysisViewModel;
        this.analysisController = analysisController;
        this.getSimilarRecipesController = getSimilarRecipesController;
        this.saveController = saveController;
        this.saveViewModel = saveViewModel;

        SaveState state = saveViewModel.getState();
        this.savedRecipes = state.getSavedRecipes();

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(800, 600));
        this.displayController = displayController;
        this.deleteController = deleteController;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 100;
        JLabel appName = new JLabel("Hungreat", SwingConstants.CENTER);
        appName.setFont(new Font("Helvetica", Font.BOLD, 24));
        this.add(appName, gbc);

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
        exit = new JButton("Exit Program");
        this.add(exit, gbc);

        savedRecipesList = new JPanel();
        savedRecipesList.setLayout(new BoxLayout(savedRecipesList, BoxLayout.Y_AXIS));

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

                            BrowseView browseView = new BrowseView(browseController, displayViewModel, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

                        }
                    }
                }
        );

        recommend.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(recommend)) {

                            RecommendView recommendView = new RecommendView(recommendController, displayViewModel, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

                        }
                    }
                }
        );

        exit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(exit)) {
                            JComponent comp = (JComponent) evt.getSource();
                            Window win = SwingUtilities.getWindowAncestor(comp);
                            win.dispose();
                            System.exit(0);
                        }
                    }
                }
        );
        saveViewModel.addPropertyChangeListener(this);
        saveController.execute(null);
    }

    @NotNull
    private static JButton getjButton(ArrayList<Integer> recipeIDs, Map<Integer, String> recipes, int i, DisplayController displayController, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController, GetSimilarRecipesController getSimilarRecipesController, SaveController saveController, SaveViewModel saveViewModel, DeleteController deleteController) {
        Integer recipeID = recipeIDs.get(i);

        JButton button = new JButton(recipes.get(recipeID));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(button)) {

                            displayController.execute(recipeID);
                            RecipeView recipeView = new RecipeView(recipeID, recipes.get(recipeID), recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);


                        }
                    }
                }
        );
        return button;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {

            this.savedRecipes = ((SaveState) evt.getNewValue()).getSavedRecipes();

            this.savedRecipesList.removeAll();

            if (!this.savedRecipes.isEmpty()) {

                for (int i = 0; i < this.savedRecipes.size(); i++) {

                    JButton button = getjButton(new ArrayList<>(this.savedRecipes.keySet()), this.savedRecipes, i, displayController, recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveController, saveViewModel, deleteController);
                    button.setMinimumSize(new Dimension(500, 100));
                    button.setMaximumSize(new Dimension(500, 100));
                    button.setPreferredSize(new Dimension(500, 100));
                    savedRecipesList.add(button);

                }
            }
            this.repaint();
            this.revalidate();
        } else if (evt.getPropertyName().equals("error")) {

            JOptionPane.showMessageDialog(null, (String) evt.getNewValue());

        }
    }

}
