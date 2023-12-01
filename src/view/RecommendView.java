package view;

import interface_adapter.AnalysisViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.DisplayViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.display.DisplayController;
import interface_adapter.recommend.RecommendController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecommendView extends JFrame {

    final JTextField cuisineInput;
    final JTextField excludeCuisineInput;
    final JTextField dietInput;
    final JTextField intolerancesInput;
    final JTextField ingredientsInput;
    final JTextField excludeIngredientsInput;
    final JTextField nutrientsInput;

    private final RecommendController recommendController;
    private final DisplayViewModel displayViewModel;
    private final DisplayController displayController;
    private final RecipeViewModel recipeViewModel;

    public RecommendView(RecommendController recommendController, DisplayViewModel displayViewModel, DisplayController displayController, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController) {

        this.recommendController = recommendController;
        this.displayViewModel = displayViewModel;
        this.displayController = displayController;
        this.recipeViewModel = recipeViewModel;

        this.setTitle("Search Recipes");

        JPanel searchWindow = new JPanel();
        searchWindow.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        // title

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.ipady = 50;

        JLabel title = new JLabel("Apply Recommend Filters", SwingConstants.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 24));
        searchWindow.add(title, gbc);

        // cuisine

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 20;
        gbc.ipady = 10;

        JLabel cuisine = new JLabel("Include Cuisine", SwingConstants.CENTER);
        cuisine.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(cuisine, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 350;

        cuisineInput = new PTextField("Separate fields by comma");
        cuisineInput.setFont(new Font("Arial", Font.PLAIN, 18));
        cuisineInput.setForeground(Color.DARK_GRAY);
        cuisineInput.setOpaque(false);
        cuisineInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(cuisineInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 20;

        // excludeCuisine

        JLabel excludeCuisine = new JLabel("Exclude Cuisine", SwingConstants.CENTER);
        excludeCuisine.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(excludeCuisine, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 350;

        excludeCuisineInput = new PTextField("Separate fields by comma");
        excludeCuisineInput.setFont(new Font("Arial", Font.PLAIN, 18));
        excludeCuisineInput.setForeground(Color.DARK_GRAY);
        excludeCuisineInput.setOpaque(false);
        excludeCuisineInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(excludeCuisineInput, gbc);

        // diet

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 20;

        JLabel diet = new JLabel("Preferred Diet", SwingConstants.CENTER);
        diet.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(diet, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 350;

        dietInput = new PTextField("Separate fields by comma");
        dietInput.setFont(new Font("Arial", Font.PLAIN, 18));
        dietInput.setForeground(Color.DARK_GRAY);
        dietInput.setOpaque(false);
        dietInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(dietInput, gbc);

        // intolerances

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 20;

        JLabel intolerances = new JLabel("Intolerances", SwingConstants.CENTER);
        intolerances.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(intolerances, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipadx = 350;

        intolerancesInput = new PTextField("Separate fields by comma");
        intolerancesInput.setFont(new Font("Arial", Font.PLAIN, 18));
        intolerancesInput.setForeground(Color.DARK_GRAY);
        intolerancesInput.setOpaque(false);
        intolerancesInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(intolerancesInput, gbc);

        // ingredients

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 20;

        JLabel ingredients = new JLabel("Include Ingredients", SwingConstants.CENTER);
        ingredients.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(ingredients, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipadx = 350;

        ingredientsInput = new PTextField("Separate fields by comma");
        ingredientsInput.setFont(new Font("Arial", Font.PLAIN, 18));
        ingredientsInput.setForeground(Color.DARK_GRAY);
        ingredientsInput.setOpaque(false);
        ingredientsInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(ingredientsInput, gbc);

        // excludeIngredients

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.ipadx = 20;

        JLabel excludeIngredients = new JLabel("Exclude Ingredients", SwingConstants.CENTER);
        excludeIngredients.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(excludeIngredients, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.ipadx = 350;

        excludeIngredientsInput = new PTextField("Separate fields by comma");
        excludeIngredientsInput.setFont(new Font("Arial", Font.PLAIN, 18));
        excludeIngredientsInput.setForeground(Color.DARK_GRAY);
        excludeIngredientsInput.setOpaque(false);
        excludeIngredientsInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(excludeIngredientsInput, gbc);

        // nutrients

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipadx = 20;

        JLabel nutrients = new JLabel("Nutrients", SwingConstants.CENTER);
        nutrients.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(nutrients, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipadx = 350;

        nutrientsInput = new PTextField("Separate fields (nutrient : range) by comma");
        nutrientsInput.setFont(new Font("Arial", Font.PLAIN, 18));
        nutrientsInput.setForeground(Color.DARK_GRAY);
        nutrientsInput.setOpaque(false);
        nutrientsInput.setBorder(
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createTitledBorder(
                                null, "",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new Font("Arial", Font.PLAIN, 18)
                        ),
                        javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)
                )
        );
        searchWindow.add(nutrientsInput, gbc);

        // search

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 0, 30, 0);

        JButton search = new JButton("Get Recommendations");
        search.setFont(new Font("Arial", Font.PLAIN, 18));
        search.setPreferredSize(new Dimension(50, 10));
        searchWindow.add(search, gbc);

        search.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(search)) {
                        recommendController.execute(
                                getCuisineInput(),
                                getExcludeCuisineInput(),
                                getDietInput(),
                                getIntolerancesInput(),
                                getIngredientsInput(),
                                getExcludeIngredientsInput(),
                                getNutrientsInput()
                        );

                        DisplayView displayView = new DisplayView(displayController, displayViewModel.getRecipes(), recipeViewModel, analysisViewModel, analysisController);

                        JComponent comp = (JComponent) evt.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();

                    }

                }
            }
        );


        this.add(searchWindow);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public ArrayList<String> getCuisineInput() {
        String text = cuisineInput.getText().strip();
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
        return inputs;
    }

    public ArrayList<String> getExcludeCuisineInput() {
        String text = excludeCuisineInput.getText().strip();
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
        return inputs;
    }

    public ArrayList<String> getDietInput() {
        String text = dietInput.getText().strip();
        if (text.equals("Separate fields by comma")) {
            text = "";
        }
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
        return inputs;
    }

    public ArrayList<String> getIntolerancesInput() {
        String text = intolerancesInput.getText().strip();
        if (text.equals("Separate fields by comma")) {
            text = "";
        }
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
        return inputs;
    }

    public ArrayList<String> getIngredientsInput() {
        String text = ingredientsInput.getText().strip();
        if (text.equals("Separate fields by comma")) {
            text = "";
        }
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
        return inputs;
    }

    public ArrayList<String> getExcludeIngredientsInput() {
        String text = excludeIngredientsInput.getText().strip();
        if (text.equals("Separate fields by comma")) {
            text = "";
        }
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
        return inputs;
    }

    public Map<String, Float[]> getNutrientsInput() {
        String text = nutrientsInput.getText().strip();
        if (text.equals("Separate fields (nutrient : range) by comma")) {
            Map<String, Float[]> nutrients = Map.of("Calories" , new Float[]{0f, 1000000f});
            return nutrients;
        } else {
            ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
            Map<String, Float[]> nutrients = new HashMap<>();
            for (String input : inputs) {
                ArrayList<String> nutrient = new ArrayList<>(Arrays.asList(input.split("[ ]*:[ ]*")));
                ArrayList<String> range = new ArrayList<>(Arrays.asList(nutrient.get(1).split("[ ]*-[ ]*")));
                Float[] values = {Float.valueOf(range.get(0)), Float.valueOf(range.get(1))};
                nutrients.put(nutrient.get(0), values);
            }
            return nutrients;
        }
    }
}
