package viewTest;

import app.LoggedInUseCaseFactory;
import app.LoginUseCaseFactory;
import app.SignupUseCaseFactory;
import org.junit.Test;
import plan.service.main_view_models.EditorViewModel;
import plan.service.main_view_models.StartUpViewModel;
import user.data_access.FileUserDataAccessObject;
import user.entity.CommonUserFactory;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import user.service.login.interface_adapter.LoginViewModel;
import user.service.signup.interface_adapter.SignupViewModel;
import view.*;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class signupViewTest {
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

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LabelTextPanel labelTextPanel = (LabelTextPanel) signupView.getComponent(4);
        JPasswordField jPasswordField = (JPasswordField) labelTextPanel.getComponent(1);

        assertEquals("xbsv7k979hAXbFcLNdLoUTHBdQwQYPBL", new String(jPasswordField.getPassword()));

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        File csvFile = new File("./temp.csv");
        csvFile.delete();
    }
}
