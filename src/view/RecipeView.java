package view;

import interface_adapter.AnalysisViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.SaveState;
import interface_adapter.SaveViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.delete.DeleteController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.save.SaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class RecipeView extends JFrame {

    final JButton save;
    final JButton Unsave;
    final JButton analyze;
    final JPanel recipeInfo;
    final JButton similar;

    final private Integer recipeID;
    final RecipeViewModel recipeViewModel;
    final AnalysisViewModel analysisViewModel;

    final GetSimilarRecipesController getSimilarRecipesController;
    final DeleteController deleteController;


    public RecipeView(Integer recipeID, String recipeTitle, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController, GetSimilarRecipesController getSimilarRecipesController, SaveViewModel saveViewModel, SaveController saveController, DeleteController deleteController){

        this.recipeID = recipeID;
        this.recipeViewModel = recipeViewModel;
        this.setTitle(recipeTitle);
        this.analysisViewModel = analysisViewModel;
        this.getSimilarRecipesController = getSimilarRecipesController;
        this.deleteController = deleteController;

        JPanel recipeWindow = new JPanel();
        recipeWindow.setLayout(new GridBagLayout());
        recipeWindow.setPreferredSize(new Dimension(800, 600));


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 50;
        gbc.ipady = 90;
        JLabel recipeName = new JLabel("<html><center>"+ recipeTitle + "</html>", SwingConstants.CENTER);
        recipeName.setFont(new Font("Helvetica", Font.PLAIN, 18));
        recipeName.setPreferredSize(new Dimension(50, 50));
        recipeWindow.add(recipeName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        save = new JButton("Save Recipe");
        recipeWindow.add(save, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        Unsave = new JButton("Unsave Recipe");
        recipeWindow.add(Unsave, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        analyze = new JButton("Analyze Recipe");
        recipeWindow.add(analyze, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        similar = new JButton("Similar Recipes");
        recipeWindow.add(similar, gbc);


        recipeInfo = new JPanel(new GridLayout(0, 1));

        JTextArea b = new JTextArea(recipeViewModel.getRecipeString());
        b.setFocusable(false);
        b.setEditable(false);
        b.setLineWrap(true);
        b.setPreferredSize(new Dimension(490, 100));
        recipeInfo.add(b);


        JScrollPane scrPane = new JScrollPane(recipeInfo);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.ipadx = 500;
        gbc.gridy = 0;
        gbc.gridheight = 6;
        recipeWindow.add(scrPane, gbc);


        this.add(recipeWindow);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        analyze.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(analyze)) {

                            analysisController.execute(recipeID);
                            JOptionPane.showMessageDialog(analyze, analysisViewModel.getNutritionToString());
                        }
                    }
                }
        );
        similar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(similar)) {
                            if (recipeID < 0) {
                                JOptionPane.showMessageDialog(similar, "Similar recipes are not available for user-created recipes.");

                            }
                            else{
                                getSimilarRecipesController.execute(recipeID);
                                JOptionPane.showMessageDialog(similar, recipeViewModel.getTitle());}
                            }
                        }
                    }
                );

        save.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(save)) {
                            //need a message box here
                            saveController.execute(recipeID);
                            SaveState state = saveViewModel.getState();
                            JOptionPane.showMessageDialog(null, state.getSavedRecipes().get(recipeID) + " has been successfully saved.");
                        }
                    }
                }
        );
        Unsave.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(Unsave)) {

                            try {
                                deleteController.execute(recipeID);
                            } catch (IOException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            SaveState state = saveViewModel.getState();
                            if(state.getError().strip().equals("")) {
                                JOptionPane.showMessageDialog(null, "Successfully deleted.");
                            }
                            else{
                                String message = state.getError();
                                JOptionPane.showMessageDialog(null, message);
                                state.setError("");
                                saveViewModel.setState(state);
                            }
                        }
                    }
                }
        );


    }

}
