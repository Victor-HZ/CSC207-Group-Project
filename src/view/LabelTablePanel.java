package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class LabelTablePanel extends JPanel {
    LabelTablePanel(JLabel label, JTable table) {
        this.add(label);
        this.add(table);
    }
}