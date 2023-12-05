package view;

import interface_adapter.*;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.delete.DeleteController;
import interface_adapter.display.DisplayController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.recommend.RecommendController;
import interface_adapter.save.SaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecommendView extends JFrame implements ActionListener {
    final JTextField ingredientsInput;
    final JTextField excludeIngredientsInput;
    final JTextField nutrientsInput;
    private final JComboBox cuisineInputDropdown;
    private final JComboBox excludeCuisineInputDropdown;
    private final JComboBox dietInputDropdown;
    private final JComboBox intolerancesInputDropdown;
    private ArrayList<String> cuisine = new ArrayList<>();
    private ArrayList<String> excludeCuisine = new ArrayList<>();
    private ArrayList<String> diet = new ArrayList<>();
    private ArrayList<String> intolerances = new ArrayList<>();

    private final RecommendController recommendController;
    private final DisplayViewModel displayViewModel;
    private final DisplayController displayController;
    private final RecipeViewModel recipeViewModel;

    public RecommendView(RecommendController recommendController, DisplayViewModel displayViewModel, DisplayController displayController, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController, GetSimilarRecipesController getSimilarRecipesController, SaveViewModel saveViewModel, SaveController saveController, DeleteController deleteController) {

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

        String[] cuisineOptions = {"African", "Asian", "American", "British", "Cajun", "Caribbean", "Chinese", "Eastern European", "European", "French", "German", "Greek", "Indian", "Irish", "Italian", "Japanese", "Jewish", "Korean", "Latin American", "Mediterranean", "Mexican", "Middle Eastern", "Nordic", "Southern", "Spanish", "Thai", "Vietnamese"};
        cuisineInputDropdown = new CustomDropdownMenu(cuisineOptions).dropdown;

        cuisineInputDropdown.setEditable(true);
        cuisineInputDropdown.setSelectedItem("Select/unselect from list.");
        cuisineInputDropdown.setEditable(false);

        cuisineInputDropdown.addActionListener(this);

        JLabel cuisine = new JLabel("Include Cuisine", SwingConstants.CENTER);
        cuisine.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(cuisine, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 200;

        cuisineInputDropdown.setFont(new Font("Arial", Font.PLAIN, 18));
        cuisineInputDropdown.setForeground(Color.DARK_GRAY);
        cuisineInputDropdown.setOpaque(false);
        cuisineInputDropdown.setBorder(
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

        cuisineInputDropdown.setOpaque(false);
        cuisineInputDropdown.setEditable(true);
        JTextField boxField1 = (JTextField) cuisineInputDropdown.getEditor().getEditorComponent();
        boxField1.setBorder(BorderFactory.createEmptyBorder());
        boxField1.setBackground(new Color(0, 0, 0, 0));
        boxField1.setForeground(Color.DARK_GRAY);
        boxField1.setFocusable(false);

        searchWindow.add(cuisineInputDropdown, gbc);

        // excludeCuisine
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 20;

        String[] excludeCuisineOptions = {"African", "Asian", "American", "British", "Cajun", "Caribbean", "Chinese", "Eastern European", "European", "French", "German", "Greek", "Indian", "Irish", "Italian", "Japanese", "Jewish", "Korean", "Latin American", "Mediterranean", "Mexican", "Middle Eastern", "Nordic", "Southern", "Spanish", "Thai", "Vietnamese"};
        excludeCuisineInputDropdown = new CustomDropdownMenu(excludeCuisineOptions).dropdown;

        excludeCuisineInputDropdown.setEditable(true);
        excludeCuisineInputDropdown.setSelectedItem("Select/unselect from list.");
        excludeCuisineInputDropdown.setEditable(false);

        excludeCuisineInputDropdown.addActionListener(this);

        JLabel excludeCuisine = new JLabel("Exclude Cuisine", SwingConstants.CENTER);
        excludeCuisine.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(excludeCuisine, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 200;

        excludeCuisineInputDropdown.setFont(new Font("Arial", Font.PLAIN, 18));
        excludeCuisineInputDropdown.setForeground(Color.DARK_GRAY);
        excludeCuisineInputDropdown.setOpaque(false);
        excludeCuisineInputDropdown.setBorder(
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

        excludeCuisineInputDropdown.setOpaque(false);
        excludeCuisineInputDropdown.setEditable(true);
        JTextField boxField2 = (JTextField) excludeCuisineInputDropdown.getEditor().getEditorComponent();
        boxField2.setBorder(BorderFactory.createEmptyBorder());
        boxField2.setBackground(new Color(0, 0, 0, 0));
        boxField2.setForeground(Color.DARK_GRAY);
        boxField2.setFocusable(false);

        searchWindow.add(excludeCuisineInputDropdown, gbc);

        // diet

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 20;

        String[] dietOptions = {"Gluten Free", "Ketogenic", "Vegetarian", "Lacto-Vegetarian", "Ovo-Vegetarian", "Vegan", "Pescetarian", "Paleo", "Primal", "Low FODMAP", "Whole30"};
        dietInputDropdown = new CustomDropdownMenu(dietOptions).dropdown;

        dietInputDropdown.setEditable(true);
        dietInputDropdown.setSelectedItem("Select/unselect from list");
        dietInputDropdown.setEditable(false);

        dietInputDropdown.addActionListener(this);

        JLabel diet = new JLabel("Preferred Diet", SwingConstants.CENTER);
        diet.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(diet, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 200;

        dietInputDropdown.setFont(new Font("Arial", Font.PLAIN, 18));
        dietInputDropdown.setForeground(Color.DARK_GRAY);
        dietInputDropdown.setOpaque(false);
        dietInputDropdown.setBorder(
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

        dietInputDropdown.setOpaque(false);
        dietInputDropdown.setEditable(true);
        JTextField boxField3 = (JTextField) dietInputDropdown.getEditor().getEditorComponent();
        boxField3.setBorder(BorderFactory.createEmptyBorder());
        boxField3.setBackground(new Color(0, 0, 0, 0));
        boxField3.setForeground(Color.DARK_GRAY);
        boxField3.setFocusable(false);

        searchWindow.add(dietInputDropdown, gbc);

        // intolerances

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 20;

        String[] intolerancesOptions = {"Dairy", "Egg", "Gluten", "Grain", "Peanut", "Seafood", "Sesame", "Shellfish", "Soy", "Sulfite", "Tree Nut", "Wheat"};
        intolerancesInputDropdown = new CustomDropdownMenu(intolerancesOptions).dropdown;

        intolerancesInputDropdown.setEditable(true);
        intolerancesInputDropdown.setSelectedItem("Select/unselect from list.");
        intolerancesInputDropdown.setEditable(false);

        intolerancesInputDropdown.addActionListener(this);

        JLabel intolerances = new JLabel("Intolerances", SwingConstants.CENTER);
        intolerances.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(intolerances, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipadx = 200;

        intolerancesInputDropdown.setFont(new Font("Arial", Font.PLAIN, 18));
        intolerancesInputDropdown.setForeground(Color.DARK_GRAY);
        intolerancesInputDropdown.setOpaque(false);
        intolerancesInputDropdown.setBorder(
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

        intolerancesInputDropdown.setOpaque(false);
        intolerancesInputDropdown.setEditable(true);
        JTextField boxField4 = (JTextField) intolerancesInputDropdown.getEditor().getEditorComponent();
        boxField4.setBorder(BorderFactory.createEmptyBorder());
        boxField4.setBackground(new Color(0, 0, 0, 0));
        boxField4.setForeground(Color.DARK_GRAY);
        boxField4.setFocusable(false);

        searchWindow.add(intolerancesInputDropdown, gbc);

        // ingredients

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 20;

        JLabel ingredients = new JLabel("Include Ingredients", SwingConstants.CENTER);
        ingredients.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(ingredients, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipadx = 200;

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
        gbc.ipadx = 200;

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
        gbc.ipadx = 200;

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

                        DisplayView displayView = new DisplayView(displayController, displayViewModel.getRecipes(), recipeViewModel, analysisViewModel, analysisController, getSimilarRecipesController, saveViewModel, saveController, deleteController);

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

        search.requestFocusInWindow();
    }

    public ArrayList<String> getCuisineInput() {
        return cuisine;
    }

    public ArrayList<String> getExcludeCuisineInput() {
        return excludeCuisine;
    }

    public ArrayList<String> getDietInput() {
        return diet;
    }

    public ArrayList<String> getIntolerancesInput() {
        return intolerances;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String selectedItem = (String) cb.getSelectedItem();
        cb.setEditable(true);
        if (cb.equals(cuisineInputDropdown)) {
            if (cuisine.contains(selectedItem)) {
                cuisine.remove(selectedItem);
            }
            else {
                cuisine.add(selectedItem);
            }
            cb.setSelectedItem(String.join(", ", cuisine));
        }
        else if (cb.equals(excludeCuisineInputDropdown)) {
            if (excludeCuisine.contains(selectedItem)) {
                excludeCuisine.remove(selectedItem);
            }
            else {
                excludeCuisine.add(selectedItem);
            }
            cb.setSelectedItem(String.join(", ", excludeCuisine));
        }

        else if (cb.equals(dietInputDropdown)) {
            if (diet.contains(selectedItem)) {
                diet.remove(selectedItem);
            }
            else {
                diet.add(selectedItem);
            }
            cb.setSelectedItem(String.join(", ", diet));
        }
        else if (cb.equals(intolerancesInputDropdown)) {
            if (intolerances.contains(selectedItem)) {
                intolerances.remove(selectedItem);
            }
            else {
                intolerances.add(selectedItem);
            }
            cb.setSelectedItem(String.join(", ", intolerances));
        }
        cb.setEditable(false);

        cb.setOpaque(false);
        cb.setEditable(true);
        JTextField boxField = (JTextField) cb.getEditor().getEditorComponent();
        boxField.setBorder(BorderFactory.createEmptyBorder());
        boxField.setBackground(new Color(0, 0, 0, 0));
        boxField.setForeground(Color.DARK_GRAY);
        boxField.setFocusable(false);

    }
}
