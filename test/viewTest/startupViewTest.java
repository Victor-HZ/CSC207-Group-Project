package viewTest;

import org.junit.Test;
import plan.service.main_view_models.EditorViewModel;
import plan.service.main_view_models.StartUpViewModel;
import user.service.clear_users.ClearInputBoundary;
import user.service.clear_users.interface_adapter.ClearController;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import user.service.login.interface_adapter.LoginViewModel;
import user.service.signup.SignupInputBoundary;
import user.service.signup.interface_adapter.SignupController;
import user.service.signup.interface_adapter.SignupViewModel;
import view.SignupView;
import view.StartUpView;
import view.ViewManager;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

import static java.lang.Thread.sleep;

public class startupViewTest {
    private static JPanel views;

    @Test
    public void testStartUpView() {
        // Create the controllers first
        SignupInputBoundary sib = null;
        SignupController signupController = new SignupController(sib);
        ClearInputBoundary cib = null;
        ClearController clearController = new ClearController(cib);

        // Then the view manager model
        JFrame application = new JFrame("Planner StartUp");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        CardLayout cardLayout = new CardLayout();

        views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // After that the viewmodels
        StartUpViewModel startUpViewModel = new StartUpViewModel();
        views.add(startupView, startupView.viewName);


        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        EditorViewModel editorViewModel = new EditorViewModel();

        // Finally create the view
        JPanel startupView = new StartUpView(viewManagerModel, startUpViewModel, loginViewModel, signupViewModel);
        JFrame jf = new JFrame();
        jf.setContentPane(startupView);
        jf.pack();
        jf.setVisible(true);










        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JPanel panel = (JPanel) startupView.getComponent(1);
        JButton signup = (JButton) panel.getComponent(1);

        signup.doClick();

        // pause execution for a second
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
