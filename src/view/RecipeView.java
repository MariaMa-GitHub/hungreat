package view;

import interface_adapter.AnalysisViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.analysis.AnalysisController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RecipeView extends JFrame {

    final JButton save;
    final JButton export;
    final JButton analyze;
    final JButton redirect;
    final JPanel recipeInfo;
    final JButton similar;

    final private Integer recipeID;
    final RecipeViewModel recipeViewModel;
    private final AnalysisViewModel analysisViewModel;


    public RecipeView(Integer recipeID, String recipeTitle, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController) {

        this.recipeID = recipeID;
        this.recipeViewModel = recipeViewModel;
        this.setTitle(recipeTitle);
        this.analysisViewModel = analysisViewModel;

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
        export = new JButton("Export Recipe");
        recipeWindow.add(export, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        analyze = new JButton("Analyze Recipe");
        recipeWindow.add(analyze, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        redirect = new JButton("View Online");
        recipeWindow.add(redirect, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        similar = new JButton("Similar Receips");
        recipeWindow.add(similar, gbc);


        recipeInfo = new JPanel(new GridLayout(0, 1));

//        System.out.println(recipeViewModel);
//        System.out.println(recipeViewModel.getRecipeString());
            JTextArea b = new JTextArea(recipeViewModel.getRecipeString());
            b.setFocusable(false);
            b.setEditable(false);
            b.setLineWrap(true);
            b.setPreferredSize(new Dimension(490, 100));
            recipeInfo.add(b);

        //TODO put your text here, assign recipeinfor to recipe.toString
//        String recipeInfo = recipeViewModel.getRecipeString();
        JScrollPane scrPane = new JScrollPane(recipeInfo);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

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

                            // TODO chloe you need to pass in the nutrition data according to the corresponding id.
                            //need a message box here
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

                            // TODO chloe you need to pass in the nutrition data according to the corresponding id.
                            //need a message box here
                            similarController.execute(recipeID);
                            JOptionPane.showMessageDialog(analyze, analysisViewModel.getNutritionToString());
                        }
                    }
                }
        );

    }

}
