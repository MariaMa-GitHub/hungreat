package view;

import javax.swing.*;

public class SaveView {
    // TODO: a popup window mention whether save successfully
    public void showSaveSuccess() {
        JOptionPane.showMessageDialog(null, "Successfully saved!");
    }

    public void showSaveFail(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
