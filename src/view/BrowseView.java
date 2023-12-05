package view;

import interface_adapter.*;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.browse.BrowseController;
import interface_adapter.delete.DeleteController;
import interface_adapter.display.DisplayController;
import interface_adapter.getSimilarRecipes.GetSimilarRecipesController;
import interface_adapter.save.SaveController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalComboBoxButton;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrowseView extends JFrame implements ActionListener {
//    final JTextField dietInput;
    final JComboBox dietInputDropdown;
    final JComboBox intolerancesInputDropdown;
    final JTextField ingredientsInput;
    final JTextField excludeIngredientsInput;
    final JTextField nutrientsInput;
    final JTextField queryInput;
    private ArrayList<String> diet = new ArrayList<>();
    private ArrayList<String> intolerances = new ArrayList<>();

    private final BrowseController controller;
    private final DisplayViewModel displayViewModel;

    public BrowseView(BrowseController controller, DisplayViewModel displayViewModel, DisplayController displayController, RecipeViewModel recipeViewModel, AnalysisViewModel analysisViewModel, AnalysisController analysisController, GetSimilarRecipesController getSimilarRecipesController, SaveViewModel saveViewModel, SaveController saveController, DeleteController deleteController) {

        this.controller = controller;
        this.displayViewModel = displayViewModel;

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

        JLabel title = new JLabel("Apply Search Filters", SwingConstants.CENTER);
        title.setFont(new Font("Helvetica", Font.BOLD, 24));
        searchWindow.add(title, gbc);

        // diet

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 20;
        gbc.ipady = 10;

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
        JTextField boxField1 = (JTextField) dietInputDropdown.getEditor().getEditorComponent();
        boxField1.setBorder(BorderFactory.createEmptyBorder());
        boxField1.setBackground(new Color(0, 0, 0, 0));
        boxField1.setForeground(Color.DARK_GRAY);
        boxField1.setFocusable(false);

        searchWindow.add(dietInputDropdown, gbc);

        // intolerances

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 20;

        String[] intolerancesOptions = {"Dairy", "Egg", "Gluten", "Grain", "Peanut", "Seafood", "Sesame", "Shellfish", "Soy", "Sulfite", "Tree Nut", "Wheat"};
        intolerancesInputDropdown = new CustomDropdownMenu(intolerancesOptions).dropdown;

        intolerancesInputDropdown.setEditable(true);
        intolerancesInputDropdown.setSelectedItem("Select/unselect from list");
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
        JTextField boxField2 = (JTextField) intolerancesInputDropdown.getEditor().getEditorComponent();
        boxField2.setBorder(BorderFactory.createEmptyBorder());
        boxField2.setBackground(new Color(0, 0, 0, 0));
        boxField2.setForeground(Color.DARK_GRAY);
        boxField2.setFocusable(false);

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

        // query
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.ipadx = 20;

        JLabel query = new JLabel("Query", SwingConstants.CENTER);
        query.setFont(new Font("Arial", Font.PLAIN, 18));
        searchWindow.add(query, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.ipadx = 200;

        queryInput = new PTextField("Enter a keyword");
        queryInput.setFont(new Font("Arial", Font.PLAIN, 18));
        queryInput.setForeground(Color.DARK_GRAY);
        queryInput.setOpaque(false);
        queryInput.setBorder(
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
        searchWindow.add(queryInput, gbc);

        // search

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 0, 30, 0);

        JButton search = new JButton("Search Recipe");
        search.setFont(new Font("Arial", Font.PLAIN, 18));
        search.setPreferredSize(new Dimension(50, 10));
        searchWindow.add(search, gbc);

        search.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(search)) {
                                // for the browse one, we need to get the input from the text fields
                                controller.execute(
                                        getDietInput(),
                                        getIntolerancesInput(),
                                        getIngredientsInput(),
                                        getExcludeIngredientsInput(),
                                        getNutrientsInput(),
                                        getQueryInput()
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

    public String getQueryInput() {
        String text = queryInput.getText().strip();
        if (text.equals("Enter a keyword")) {
            text = "";
        }
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String selectedItem = (String) cb.getSelectedItem();
        cb.setEditable(true);
        if (cb.equals(dietInputDropdown)) {
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

