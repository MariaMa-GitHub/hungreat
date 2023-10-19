package interface_adapter;

import entity.Recipe;
import view.SearchView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class DisplayViewModel {

    private ArrayList<JButton> recipeBtns = new ArrayList<>();

    public DisplayViewModel() {
    }

    public ArrayList<JButton> getRecipes() {
        return recipeBtns;
    }

    public void setRecipes(Collection<Recipe> recipes) {

        for (Recipe recipe : recipes) {

            JButton button = new JButton(recipe.getTitle());
            button.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(button)) {

                                // TODO (Everyone and Maria)

                            }
                        }
                    }
            );
            recipeBtns.add(button);


        }

    }

}
