package view;

import javax.swing.*;
import java.awt.*;

/**
 * A panel containing a label and a text field.
 */
class LabelTablePanel extends JPanel {
    LabelTablePanel(JLabel label, JScrollPane table) {
        this.add(label);
        this.add(table);
    }
}