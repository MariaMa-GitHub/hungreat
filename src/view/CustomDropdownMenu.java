package view;

import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.awt.*;
import java.awt.event.*;

public class CustomDropdownMenu {
    public JComboBox<String> dropdown;

    public CustomDropdownMenu(String[] options) {
//        setTitle("Custom Dropdown Menu");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());

        dropdown = new JComboBox<>(options);
        dropdown.setPreferredSize(new Dimension(150, 30));
        dropdown.setSize(new Dimension(150, 30));
        dropdown.setRenderer(new CustomListCellRenderer());
        dropdown.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = super.createArrowButton();
                button.setContentAreaFilled(false); // To remove the default arrow button background
                return button;
            }

            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popup = new BasicComboPopup(comboBox) {
                    @Override
                    protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
                        Rectangle bounds = super.computePopupBounds(px, py, pw, ph);
                        bounds.y += 10; // Increase the space between the textbox and the dropdown list
                        return bounds;
                    }
                };
                popup.getAccessibleContext().setAccessibleParent(comboBox);
                return popup;
            }
        });
//        add(dropdown);

//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
    }

    class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Customize background color of the dropdown list
            c.setBackground(UIManager.getColor("Panel.background"));
            c.setForeground(Color.DARK_GRAY);
            if (isSelected) {
                c.setBackground(Color.LIGHT_GRAY);
            }

            return c;
        }
    }
}

