package view;

import user.service.clear_users.interface_adapter.ClearController;
import user.service.clear_users.interface_adapter.ClearState;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.signup.interface_adapter.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;

    private final JPasswordField ticketMasterAPITokenInputField = new JPasswordField(15);
    private final JPasswordField tripAdvisorAPITokenInputField = new JPasswordField(15);
    private final JPasswordField coordinateAPITokenInputField = new JPasswordField(15);

    private final ClearViewModel clearViewModel;
    private final ClearController clearController;


    private final JButton signUp;
    private final JButton cancel;

    private final JButton loadFromEnv;

    // TODO Note: this is the new JButton for clearing the users file
    private final JButton clear;

    public SignupView(SignupController signupController, SignupViewModel signupViewModel, ClearController clearController, ClearViewModel clearViewModel) {

        this.signupController = signupController;
        this.signupViewModel = signupViewModel;
        this.clearController = clearController;
        this.clearViewModel = clearViewModel;
        signupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        LabelTextPanel ticketMasterAPITokenInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.TICKETMAST_API_TOKEN_LABEL), ticketMasterAPITokenInputField);
        LabelTextPanel tripAdvisorAPITokenInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.TRIPADVISOR_API_TOKEN_LABEL), tripAdvisorAPITokenInputField);
        LabelTextPanel coordinateAPITokenInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.COORDINATE_API_TOKEN_LABEL), coordinateAPITokenInputField);


        JPanel buttons = new JPanel();
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        cancel = new JButton(SignupViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        loadFromEnv = new JButton(SignupViewModel.LOAD_FROM_ENVIRONMENT);
        buttons.add(loadFromEnv);



        // TODO Note: the following line instantiates the "clear" button; it uses
        //      a CLEAR_BUTTON_LABEL constant which is defined in the SignupViewModel class.
        //      You need to add this "clear" button to the "buttons" panel.
        clear = new JButton(SignupViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignupState currentState = signupViewModel.getState();

                            SignupView.this.signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword(),
                                    currentState.getApiTokens()
                            );
                        }
                    }
                }
        );

        // TODO Add the body to the actionPerformed method of the action listener below
        //      for the "clear" button. You'll need to write the signupController before
        //      you can complete this.
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(clear)){
                            ClearState currentState = clearViewModel.getState();
                            SignupView.this.clearController.execute(currentState.getUsernames());
                            String message = "";
                            for(String user : currentState.getUsernames()){
                                message = message + user + '\n';
                            }
                            JOptionPane.showMessageDialog(null, message);
                        }

                    }
                }
        );

        loadFromEnv.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(clear)){
                            ticketMasterAPITokenInputField.setText(System.getenv("TICKETMAST_API_TOKEN"));
                            tripAdvisorAPITokenInputField.setText(System.getenv("TRIPADVISOR_API_TOKWN"));
                            coordinateAPITokenInputField.setText(System.getenv("COORDINATE_API_TOKEN"));
                            usernameInputField.setText(System.getenv("NAME"));
                            passwordInputField.setText(System.getenv("PASSWORD"));
                            repeatPasswordInputField.setText(System.getenv("REPEATPASSWORD"));
                        }
                    }
                }
        );

        cancel.addActionListener(this);

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}