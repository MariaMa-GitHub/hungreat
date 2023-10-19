package view;

import interface_adapter.recommend.RecommendController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayView extends JFrame {

    public DisplayView(ArrayList<JButton> recipeBtns) {
        
        this.setTitle("View Recommendations");

        JPanel displayWindow = new JPanel();
        displayWindow.setLayout(new GridLayout(2,3));

        for (int i = 0; i < 6; i++) {
            displayWindow.add(recipeBtns.get(i));
        }

        this.add(displayWindow);

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

}
