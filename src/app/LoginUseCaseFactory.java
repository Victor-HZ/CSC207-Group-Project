package app;

import view.interface_adapter.ViewManagerModel;
import user.entity.CommonUserFactory;
import user.entity.UserFactory;
import user.service.logged_in.interface_adaper.LoggedInViewModel;
import user.service.login.LoginInputBoundary;
import user.service.login.LoginInteractor;
import user.service.login.LoginOutputBoundary;
import user.service.login.LoginUserDataAccessInterface;
import user.service.login.interface_adapter.LoginController;
import user.service.login.interface_adapter.LoginPresenter;
import user.service.login.interface_adapter.LoginViewModel;

import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

//    public static LoginView create(
//            ViewManagerModel viewManagerModel,
//            LoginViewModel loginViewModel,
//            LoggedInViewModel loggedInViewModel,
//            LoginUserDataAccessInterface userDataAccessObject) {
//
//        try {
//            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//            return new LoginView(loginViewModel, loginController);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//
//        return null;
//    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}
