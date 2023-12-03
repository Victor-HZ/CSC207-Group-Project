package view;

import plan.service.main_view_models.StartUpState;
import plan.service.main_view_models.StartUpViewModel;
import user.service.logged_in.interface_adaper.*;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;
    private final StartUpViewModel startupViewModel;

    JLabel username;

    private final JTextField dateInputField = new JTextField(10);
    private final JTextField cityInputField = new JTextField(15);
    private final JTextField countryInputField = new JTextField(15);

    final JButton createPlan;
    final JButton loadPlan;
    final JButton logOut;

    /**
     * A window with a title and a JButton.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel, ViewManagerModel vMM, StartUpViewModel suVM) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);
        this.viewManagerModel = vMM;
        this.startupViewModel = suVM;

        JLabel title = new JLabel(loggedInViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel dateInfo = new LabelTextPanel(
                new JLabel(LoggedInViewModel.DATE_INPUT_LABEL), dateInputField);
        LabelTextPanel cityInfo = new LabelTextPanel(
                new JLabel(LoggedInViewModel.CITY_INPUT_LABEL), cityInputField);
        LabelTextPanel countryInfo = new LabelTextPanel(
                new JLabel(LoggedInViewModel.COUNTRY_INPUT_LABEL), countryInputField);

        JPanel buttons = new JPanel();
        createPlan = new JButton(loggedInViewModel.CREATE_PLAN_BUTTON_LABEL);
        buttons.add(createPlan);
        loadPlan = new JButton(loggedInViewModel.LOAD_PLAN_BUTTON_LABEL);
        buttons.add(loadPlan);
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        createPlan.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(createPlan)) {
//                            CreatePlanState createPlanState = createPlanViewModel.getState();
//                            createPlanViewModel.setState(createPlanState);
//                            createPlanViewModel.firePropertyChanged();
//
//                            createPlanController.execute();
                        }
                    }
                }
        );

        loadPlan.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(loadPlan)) {
//                            LoadPlanState loadPlanState = loadPlanViewModel.getState();
//                            loadPlanViewModel.setState(loadPlanState);
//                            loadPlanViewModel.firePropertyChanged();
//
//                            loadPlanController.execute();
                        }
                    }
                }
        );

        logOut.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logOut)) {
                            StartUpState startupState = startupViewModel.getState();
                            startupViewModel.setState(startupState);
                            startupViewModel.firePropertyChanged();

                            viewManagerModel.setActiveView(startupViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        dateInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        String text = usernameInputField.getText() + e.getKeyChar();
//                        currentState.setUsername(text);
//                        signupViewModel.setState(currentState);
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
        this.add(username);
        this.add(dateInfo);
        this.add(cityInfo);
        this.add(countryInfo);
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
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}