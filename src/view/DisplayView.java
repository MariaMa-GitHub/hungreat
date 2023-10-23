package view;

import entity.Recipe;
import interface_adapter.recommend.RecommendController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayView extends JFrame {

    public DisplayView(ArrayList<Recipe> recipes) {

        this.setTitle("View Recommendations");

        JPanel displayWindow = new JPanel();
        displayWindow.setLayout(new GridLayout(2,3));

        for (int i = 0; i < 6; i++) {

            JButton button = getjButton(recipes, i);

            displayWindow.add(button);

        }

        this.add(displayWindow);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @NotNull
    private static JButton getjButton(ArrayList<Recipe> recipes, int i) {
        Recipe recipe = recipes.get(i);

        JButton button = new JButton(recipe.getTitle());
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(button)) {

                            // TODO (Everyone and Maria)
//                            RecipeView recipeView = new RecipeView(recipe);

                        }
                    }
                }
        );
        return button;
    }

}
