//package view;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//
//public class EnterView extends JPanel implements ActionListener, PropertyChangeListener {
//    public final String viewName = "Enter";
//    private final EnterViewModel enterViewModel;
//    private final EnterViewController enterController;
//    private JButton Enter;
//
//    public EnterView(EnterViewController controller, EnterViewModel enterViewModel) {
//        this.EnterViewController = controller;
//        this.EnterViewModel = enterViewModel;
//        EnterViewModel.addPropertyChangeListener(this);
//
//        JLabel title = new JLabel(EnterViewModel.TITLE_LABEL);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        JPanel buttons = new JPanel();
//        Enter = new JButton(EnterViewModel.SIGNUP_BUTTON_LABEL);
//        buttons.add(Enter);
//
//
//        Enter.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(Enter)) {
//                            EnterViewController.execute();
//                            EnterViewState state = EnterViewModel.getState();
//                        }
//                    }
//                }
//        );
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        this.add(title);
//        this.add(buttons);
//
//    }
//    public void propertyChange(PropertyChangeEvent evt) {
//        EnterViewState state = (EnterViewState) evt.getNewValue();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent evt) {
//        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
//    }
//
//}
