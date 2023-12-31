package app;

import apis.ActivitiesFetchInterface;
import apis.ticketmaster.TicketmasterAPI;
import apis.tripAdvisor.TripAdvisorAPI;
import plan.service.generate_report.interface_adapter.GenerateReportViewModel;
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
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static JPanel views;
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Planner StartUp");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.

        StartUpViewModel startUpViewModel = new StartUpViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        EditorViewModel editorViewModel = new EditorViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
    }

    public static void addNewView(JPanel view, String viewName){
        views.add(view, viewName);
    }
}