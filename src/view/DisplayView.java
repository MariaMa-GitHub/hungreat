package view;

import interface_adapter.RecipeViewModel;
import interface_adapter.display.DisplayController;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class DisplayView extends JFrame {

    public DisplayView(DisplayController displayController, Map<Integer, String> recipes, RecipeViewModel recipeViewModel) {

        this.setTitle("View Recommendations");

        JPanel displayWindow = new JPanel();
        displayWindow.setLayout(new GridLayout(2,3));

        for (int i = 0; i < Math.min(6, recipes.size()); i++) {

            JButton button = getjButton(new ArrayList<>(recipes.keySet()), recipes, i,displayController,recipeViewModel);

            displayWindow.add(button);

        }

        this.add(displayWindow);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @NotNull//getjButton is the process create and set a button this button will relate to the recipe id.
    private static JButton getjButton(ArrayList<Integer> recipeIDs, Map<Integer, String> recipes, int i, DisplayController displayController,RecipeViewModel recipeViewModel) {
        Integer recipeID = recipeIDs.get(i);

        JButton button = new JButton(recipes.get(recipeID));
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(button)) {

                            // TODO (Everyone and Maria)
                            displayController.execute(recipeID);
                            RecipeView recipeView = new RecipeView(recipeID, recipes.get(recipeID), recipeViewModel);
                      

                        }
                    }
                }
        );
        return button;
    }

}
