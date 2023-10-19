package view;

import entity.Recipe;

import javax.swing.*;
import java.awt.*;

public class RecipeView extends JFrame {

    final JButton save;
    final JButton export;
    final JButton analyze;
    final JButton redirect;
    final JPanel recipeInfo;

    final private Recipe recipe;

    public RecipeView(Recipe recipe) {

        this.recipe = recipe;
        this.setTitle(recipe.getTitle());

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
        JLabel recipeName = new JLabel("<html><center>"+ recipe.getTitle() + "</html>", SwingConstants.CENTER);
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

        recipeInfo = new JPanel(new GridLayout(0, 1));

//        for (int i = 1; i < 21; i++) {
//            JButton b = new JButton(String.format("Recipe %s", i));
//            b.setPreferredSize(new Dimension(490, 100));
//            recipeInfo.add(b);
//        }

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

    }

}
