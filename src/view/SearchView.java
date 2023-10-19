package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchView extends JFrame {

    final JTextField cuisineInput;
    final JTextField excludeCuisineInput;
    final JTextField dietInput;
    final JTextField intolerancesInput;
    final JTextField ingredientsInput;
    final JTextField excludeIngredientsInput;
    final JTextField nutrientsInput;

    public SearchView() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel searchWindow = new JPanel();
//        searchWindow.setPreferredSize(new Dimension(800, 600));
        searchWindow.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
//        gbc.weighty = 1d;

        // title

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.ipady = 50;

        JLabel title = new JLabel("Apply Search Filters", SwingConstants.CENTER);
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

        nutrientsInput = new PTextField("Separate fields (nutrient : value) by comma");
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

        JButton create = new JButton("Create Recipe");
        create.setFont(new Font("Arial", Font.PLAIN, 18));
        create.setPreferredSize(new Dimension(50, 10));
        searchWindow.add(create, gbc);

        create.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(create)) {

                            // TODO

                        }
                    }
                }
        );


        this.add(searchWindow);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


//        WindowListener listener = new WindowAdapter() {
//            public void windowClosing(WindowEvent evt) {
////                JFrame frame = (JFrame) evt.getSource();
//                JOptionPane.showMessageDialog(null, "Window Closing");
//            }
//        };
//
//
//        this.addWindowListener(listener);

    }

}