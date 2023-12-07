package viewTest;

import apis.ActivitiesFetchInterface;
import apis.ticketmaster.TicketmasterAPI;
import apis.tripAdvisor.TripAdvisorAPI;
import app.*;
import org.junit.Test;
import plan.entity.address.Address;
import plan.entity.plan.Plan;
import plan.service.generate_report.interface_adapter.GenerateReportViewModel;
import plan.service.main_view_models.EditorViewModel;
import plan.service.main_view_models.StartUpViewModel;
import user.data_access.FileUserDataAccessObject;
import user.entity.CommonUserFactory;
import user.entity.User;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.logged_in.interface_adaper.LoggedInState;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import user.service.login.interface_adapter.LoginViewModel;
import user.service.signup.interface_adapter.SignupViewModel;
import view.*;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class editorViewTest {


    private static JPanel views;

    @Test
    public void testStartUpView() {
        // Essentially main in the beginning but this is a template that will be used for all views
        JFrame application = new JFrame("Planner StartUp");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        StartUpViewModel startUpViewModel = new StartUpViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        EditorViewModel editorViewModel = new EditorViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./temp.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Finally create the view
        StartUpView startupView = new StartUpView(viewManagerModel, startUpViewModel, loginViewModel, signupViewModel);
        views.add(startupView, startupView.viewName);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject, userDataAccessObject, clearViewModel, startUpViewModel);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject, startUpViewModel);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel, startUpViewModel, editorViewModel);
        views.add(loggedInView, loggedInView.viewName);

        viewManagerModel.setActiveView(startupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setSize(1000, 700);
        application.setVisible(true);

        JPanel panel = (JPanel) startupView.getComponent(1);
        JButton signup = (JButton) panel.getComponent(1);

        signup.doClick();

        JPanel panel1 = (JPanel) signupView.getComponent(7);
        JButton loadEnv = (JButton) panel1.getComponent(2);

        loadEnv.doClick();

        LabelTextPanel panel2 = (LabelTextPanel) signupView.getComponent(1);
        JTextField usernameField = (JTextField) panel2.getComponent(1);

        KeyEvent eventRight = new KeyEvent(
                usernameField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'y');
        panel2.dispatchEvent(eventRight);

        LabelTextPanel panel3 = (LabelTextPanel) signupView.getComponent(2);
        JPasswordField passwordField = (JPasswordField) panel3.getComponent(1);

        KeyEvent eventP = new KeyEvent(
                passwordField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'y');
        panel3.dispatchEvent(eventP);

        LabelTextPanel panel4 = (LabelTextPanel) signupView.getComponent(3);
        JPasswordField repeatPasswordField = (JPasswordField) panel4.getComponent(1);

        KeyEvent eventPP = new KeyEvent(
                repeatPasswordField,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'y');
        panel4.dispatchEvent(eventPP);

        JButton signupViewSign = (JButton) panel1.getComponent(0);

        signupViewSign.doClick();

        LabelTextPanel panel5 = (LabelTextPanel) loginView.getComponent(3);
        JPasswordField loginPassword = (JPasswordField) panel5.getComponent(1);

        KeyEvent loginPass = new KeyEvent(
                loginPassword,
                KeyEvent.KEY_TYPED,
                System.currentTimeMillis(),
                0,
                KeyEvent.VK_UNDEFINED,
                'y');
        panel5.dispatchEvent(loginPass);

        JPanel panel6 = (JPanel) loginView.getComponent(5);
        JButton login = (JButton) panel6.getComponent(0);

        login.doClick();

        LabelTextPanel panel7 = (LabelTextPanel) loggedInView.getComponent(3);
        JTextField date = (JTextField) panel7.getComponent(1);

        date.setText("14-12-2023");

        LoggedInState currentState = LoggedInViewModel.getState();
        String textDate = date.getText();
        currentState.setDate(textDate);

        LabelTextPanel panel8 = (LabelTextPanel) loggedInView.getComponent(4);
        JTextField city = (JTextField) panel8.getComponent(1);

        city.setText("Toronto");

        String textCity = city.getText();
        currentState.setCity(textCity);

        LabelTextPanel panel9 = (LabelTextPanel) loggedInView.getComponent(5);
        JTextField province = (JTextField) panel9.getComponent(1);

        province.setText("ON");

        String textProvince = province.getText();
        currentState.setProvince(textProvince);

        /*
        BOUNDARY OF WHERE WE LEFT OFF
         */

        JPanel panel10 = (JPanel) loggedInView.getComponent(6);
        JButton editorMode = (JButton) panel10.getComponent(0);

        editorMode.doClick();














        File csvFile = new File("./temp.csv");
        csvFile.delete();


    }

    public static void addNewView(JPanel view, String viewName){
        views.add(view, viewName);
    }
}
