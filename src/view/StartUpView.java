package view;

import plan.service.main_view_models.StartUpViewModel;
import user.service.login.interface_adapter.LoginController;
import user.service.login.interface_adapter.LoginViewModel;
import user.service.signup.interface_adapter.SignupController;
import user.service.signup.interface_adapter.SignupState;
import user.service.signup.interface_adapter.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StartUpView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "planner startup";
    private final StartUpViewModel startupViewModel;

    private final JButton signUp;
    private final JButton login;

    public StartUpView(StartUpViewModel startupViewModel) {
        this.startupViewModel = startupViewModel;

        JLabel title = new JLabel(StartUpViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        login = new JButton(StartUpViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);
        signUp = new JButton(StartUpViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {

                        }
                    }
                }
        );

        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
