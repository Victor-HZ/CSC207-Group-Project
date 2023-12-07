package viewTest;

import org.junit.Test;
import plan.service.main_view_models.StartUpViewModel;
import user.service.clear_users.ClearInputBoundary;
import user.service.clear_users.interface_adapter.ClearController;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.signup.SignupInputBoundary;
import user.service.signup.interface_adapter.SignupController;
import user.service.signup.interface_adapter.SignupViewModel;
import view.SignupView;
import view.interface_adapter.ViewManagerModel;

import javax.swing.*;

public class signupViewTest {

    @Test
    public void testStartUpView() {
        SignupInputBoundary sib = null;
        SignupController signupController = new SignupController(sib);

        ClearInputBoundary cib = null;
        ClearController clearController = new ClearController(cib);

        SignupViewModel signupViewModel = new SignupViewModel();
        StartUpViewModel startUpViewModel = new StartUpViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();


        JPanel signupView = new SignupView(signupController, signupViewModel, clearController, clearViewModel, startUpViewModel, viewManagerModel);
        JFrame jf = new JFrame();
        jf.setContentPane(signupView);
        jf.pack();
        jf.setVisible(true);

    }
}
