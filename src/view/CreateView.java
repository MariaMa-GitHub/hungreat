package view;

import interface_adapter.AnalysisViewModel;
import interface_adapter.RecipeViewModel;
import interface_adapter.analysis.AnalysisController;
import interface_adapter.create.CreateController;
import interface_adapter.DisplayViewModel;
import interface_adapter.display.DisplayController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateView extends JFrame{
    final JTextField titleInput;
    final JTextField servingsInput;
    final JTextField readyInMinutesInput;
    final JTextArea ingredientsInput;
    final JTextArea instructionsInput;

    private final CreateController createController;
    private final DisplayViewModel displayViewModel;
    private final DisplayController displayController;
    private final RecipeViewModel recipeViewModel;
    private final AnalysisController analysisController;
    private final AnalysisViewModel analysisViewModel;

    public CreateView(
            CreateController createController,
            DisplayViewModel displayViewModel,
            DisplayController displayController,
            RecipeViewModel recipeViewModel,
            AnalysisController analysisController,
            AnalysisViewModel analysisViewModel) {

        this.createController = createController;
        this.displayViewModel = displayViewModel;
        this.displayController = displayController;
        this.recipeViewModel = recipeViewModel;
        this.analysisController = analysisController;
        this.analysisViewModel = analysisViewModel;

        this.setTitle("Create");

        JPanel createWindow = new JPanel();
        createWindow.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        // title of the creating recipe page
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.ipady = 50;

        JLabel pageTitle = new JLabel("Create a Customized Recipe", SwingConstants.CENTER);
        pageTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
        createWindow.add(pageTitle, gbc);

        // title (input field)
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 20;
        gbc.ipady = 10;

        JLabel title = new JLabel("Recipe Title", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.PLAIN, 18));
        createWindow.add(title, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 600;

        titleInput = new JTextField("");
        titleInput.setFont(new Font("Arial", Font.PLAIN, 18));
        titleInput.setForeground(Color.DARK_GRAY);
        titleInput.setOpaque(false);
        titleInput.setBorder(
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
        createWindow.add(titleInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 20;

        // servings (input field)
        JLabel servings = new JLabel("Servings", SwingConstants.CENTER);
        servings.setFont(new Font("Arial", Font.PLAIN, 18));
        createWindow.add(servings, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 600;

        servingsInput = new JTextField("");
        servingsInput.setFont(new Font("Arial", Font.PLAIN, 18));
        servingsInput.setForeground(Color.DARK_GRAY);
        servingsInput.setOpaque(false);
        servingsInput.setBorder(
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
        createWindow.add(servingsInput, gbc);

        // ready in minutes (input field)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 20;

        JLabel readyInMinutes = new JLabel("Cooking Time", SwingConstants.CENTER);
        readyInMinutes.setFont(new Font("Arial", Font.PLAIN, 18));
        createWindow.add(readyInMinutes, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 600;

        readyInMinutesInput = new JTextField("");
        readyInMinutesInput.setFont(new Font("Arial", Font.PLAIN, 18));
        readyInMinutesInput.setForeground(Color.DARK_GRAY);
        readyInMinutesInput.setOpaque(false);
        readyInMinutesInput.setBorder(
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
        createWindow.add(readyInMinutesInput, gbc);

        // ingredients (input field)
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 20;

        JLabel ingredients = new JLabel("Ingredients", SwingConstants.CENTER);
        ingredients.setFont(new Font("Arial", Font.PLAIN, 18));
        createWindow.add(ingredients, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipadx = 600;
        gbc.ipady = 200;

        ingredientsInput = new JTextArea("");
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
        JScrollPane ingredientsScrollPane = new JScrollPane(ingredientsInput);
        createWindow.add(ingredientsScrollPane, gbc);

        // instructions (input field)
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 20;
        gbc.ipady = 10;

        JLabel instructions = new JLabel("Instructions", SwingConstants.CENTER);
        instructions.setFont(new Font("Arial", Font.PLAIN, 18));
        createWindow.add(instructions, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipadx = 600;
        gbc.ipady = 500;

        instructionsInput = new JTextArea("");
        instructionsInput.setFont(new Font("Arial", Font.PLAIN, 18));
        instructionsInput.setForeground(Color.DARK_GRAY);
        instructionsInput.setOpaque(false);
        instructionsInput.setBorder(
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
        JScrollPane instructionsScrollPane = new JScrollPane(instructionsInput);
        createWindow.add(instructionsScrollPane, gbc);

        // save button
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.ipady = 30;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 400, 30, 400);

        JButton save = new JButton("Save");
        save.setFont(new Font("Arial", Font.PLAIN, 18));
        save.setPreferredSize(new Dimension(50, 10));
        createWindow.add(save, gbc);

        save.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(save)) {
                        //TODO
                        createController.execute(
//                                        getCuisineInput(),
//                                        getExcludeCuisineInput(),
//                                        getDietInput(),
//                                        getIntolerancesInput(),
//                                        getIngredientsInput(),
//                                        getExcludeIngredientsInput(),
//                                        getNutrientsInput()
                        );

                        DisplayView displayView = new DisplayView(
                                displayController,
                                displayViewModel.getRecipes(),
                                recipeViewModel,
                                analysisViewModel,
                                analysisController);    //TODO: analysis for self created recipes (Chloe)
                        JComponent comp = (JComponent) evt.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
                    }
                }
            }
        );


        this.add(createWindow);

        this.setSize(1000, 1100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //TODO
//    public ArrayList<String> getCuisineInput() {
//        String text = cuisineInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        return inputs;
//    }
//
//    public ArrayList<String> getExcludeCuisineInput() {
//        String text = excludeCuisineInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        return inputs;
//    }
//
//    public ArrayList<String> getDietInput() {
//        String text = dietInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        return inputs;
//    }
//
//    public ArrayList<String> getIntolerancesInput() {
//        String text = intolerancesInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        return inputs;
//    }
//
//    public ArrayList<String> getIngredientsInput() {
//        String text = ingredientsInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        return inputs;
//    }
//
//    public ArrayList<String> getExcludeIngredientsInput() {
//        String text = excludeIngredientsInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        return inputs;
//    }
//
//    public Map<String, Float[]> getNutrientsInput() {
//
//        String text = nutrientsInput.getText().strip();
//        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(text.split("[ ]*,[ ]*")));
//        Map<String, Float[]> nutrients = new HashMap<>();
//        for (String input : inputs) {
//            ArrayList<String> nutrient = new ArrayList<>(Arrays.asList(input.split("[ ]*:[ ]*")));
//            ArrayList<String> range = new ArrayList<>(Arrays.asList(nutrient.get(1).split("[ ]*-[ ]*")));
//            Float[] values = {Float.valueOf(range.get(0)), Float.valueOf(range.get(1))};
//            nutrients.put(nutrient.get(0), values);
//        }
//
//        return nutrients;
//    }
}
