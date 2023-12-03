package view;

import plan.service.main_view_models.EditorState;
import plan.service.main_view_models.StartUpState;
import plan.service.main_view_models.StartUpViewModel;
import user.entity.User;
import user.service.clear_users.interface_adapter.ClearController;
import user.service.clear_users.interface_adapter.ClearState;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.signup.interface_adapter.*;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.PathIterator;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

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

    private final StartUpViewModel startupViewModel;

    private final ViewManagerModel viewManagerModel;

    private final JButton signUp;
    private final JButton cancel;
    private final JButton loadFromEnv;
    private final JButton clear;

    public SignupView(SignupController signupController, SignupViewModel signupViewModel,
                      ClearController clearController, ClearViewModel clearViewModel,
                      StartUpViewModel startUpViewModel, ViewManagerModel vManagerModel) {

        this.signupController = signupController;
        this.signupViewModel = signupViewModel;
        this.clearController = clearController;
        this.clearViewModel = clearViewModel;
        this.startupViewModel = startUpViewModel;
        this.viewManagerModel = vManagerModel;

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
                        if (e.getSource().equals(loadFromEnv)){
                            System.out.println("loadFromEnv clicked");
                            ticketMasterAPITokenInputField.setText(System.getenv("TICKETMASTER_API_TOKEN"));
                            tripAdvisorAPITokenInputField.setText(System.getenv("TRIPADVISOR_API_TOKEN"));
                            coordinateAPITokenInputField.setText(System.getenv("COORDINATE_API_TOKEN"));
                            usernameInputField.setText(System.getenv("NAME"));
                            passwordInputField.setText(System.getenv("PASSWORD"));
                            repeatPasswordInputField.setText(System.getenv("REPEAT_PASSWORD"));
                            SignupState currentState = signupViewModel.getState();
                            currentState.setUsername(usernameInputField.getText());
                            currentState.setPassword(passwordInputField.getText());
                            currentState.setRepeatPassword(repeatPasswordInputField.getText());

                            HashMap<User.API_TOKEN, String> apiTokens = new HashMap<>();
                            apiTokens.put(User.API_TOKEN.Ticketmaster, ticketMasterAPITokenInputField.getText());
                            apiTokens.put(User.API_TOKEN.TripAdvisor,tripAdvisorAPITokenInputField.getText());
                            apiTokens.put(User.API_TOKEN.Coordinate, coordinateAPITokenInputField.getText());

                            currentState.setApiTokens(apiTokens);
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            StartUpState startupState = startupViewModel.getState();
                            startupViewModel.setState(startupState);
                            startupViewModel.firePropertyChanged();
                            viewManagerModel.setActiveView(startupViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

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

        ticketMasterAPITokenInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(ticketMasterAPITokenInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });

        tripAdvisorAPITokenInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(tripAdvisorAPITokenInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        coordinateAPITokenInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(coordinateAPITokenInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buttons.setBackground(Color.PINK);
        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(ticketMasterAPITokenInfo);
        this.add(tripAdvisorAPITokenInfo);
        this.add(coordinateAPITokenInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}