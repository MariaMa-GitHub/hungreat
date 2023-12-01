package view;

import interface_adapter.DisplayViewModel;
import interface_adapter.browse.BrowseController;
import interface_adapter.recommend.RecommendController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends JPanel {

    final JButton create;
    final JButton browse;
    final JButton recommend;
    final JButton export;
    final JPanel savedRecipesList;

    public HomeView(BrowseController browseController, RecommendController recommendController, DisplayViewModel displayViewModel) {

        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(800, 600));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 100;
        JLabel appName = new JLabel("Hungreat", SwingConstants.CENTER);
        appName.setFont(new Font("Helvetica", Font.BOLD, 24));
        this.add(appName, gbc);

//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.ipady = 50;
//        JLabel slogan = new JLabel("Your Personalized Meal Planner", SwingConstants.CENTER);
//        slogan.setFont(new Font("Helvetica", Font.PLAIN, 16));
//        this.add(slogan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 50;
        create = new JButton("Create");
        this.add(create, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        browse = new JButton("Browse");
        this.add(browse, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        recommend = new JButton("View Recommendations");
        this.add(recommend, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        export = new JButton("Export");
        this.add(export, gbc);

        savedRecipesList = new JPanel(new GridLayout(0, 1));

//        for (int i = 1; i < 21; i++) {
//            JButton b = new JButton(String.format("Recipe %s", i));
//            b.setPreferredSize(new Dimension(490, 100));
//            savedRecipesList.add(b);
//        }

        JScrollPane scrPane = new JScrollPane(savedRecipesList);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.ipadx = 500;
        gbc.gridy = 0;
        gbc.gridheight = 6;
        this.add(scrPane, gbc);

        create.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(create)) {

                            // TODO (Michelle)

                        }
                    }
                }
        );

        browse.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(browse)) {

                            // TODO (Everyone)
                            BrowseView browseView = new BrowseView("browse", browseController, displayViewModel);
                        }
                    }
                }
        );

        recommend.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(recommend)) {

                            // TODO (Maria)

                            RecommendView recommendView = new RecommendView("recommend", recommendController, displayViewModel);

                        }
                    }
                }
        );

        export.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(export)) {

                            // TODO (Chloe)

                        }
                    }
                }
        );

    }

}
