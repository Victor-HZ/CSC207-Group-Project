package view;

import plan.service.main_view_models.StartUpViewModel;
import user.service.login.interface_adapter.LoginState;
import user.service.login.interface_adapter.LoginViewModel;
import user.service.signup.interface_adapter.SignupState;
import user.service.signup.interface_adapter.SignupViewModel;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StartUpView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "planner startup";
    private final ViewManagerModel viewManagerModel;
    private final StartUpViewModel startupViewModel;
    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;

    private final JButton signUp;
    private final JButton login;

    public StartUpView(ViewManagerModel vmModel, StartUpViewModel suViewModel,
                       LoginViewModel logViewModel, SignupViewModel sigViewModel) {
        this.viewManagerModel = vmModel;
        this.startupViewModel = suViewModel;
        this.loginViewModel = logViewModel;
        this.signupViewModel = sigViewModel;

        JLabel title = new JLabel(startupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        login = new JButton(startupViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);
        signUp = new JButton(startupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignupState signupState = signupViewModel.getState();
                            signupViewModel.setState(signupState);
                            signupViewModel.firePropertyChanged();

                            viewManagerModel.setActiveView(signupViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(login)) {
                            LoginState loginState = loginViewModel.getState();
                            loginViewModel.setState(loginState);
                            loginViewModel.firePropertyChanged();

                            viewManagerModel.setActiveView(loginViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buttons.setBackground(Color.PINK);
        this.add(title);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
