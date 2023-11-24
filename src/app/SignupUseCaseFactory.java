package app;

import view.SignupView;
import view.interface_adapter.ViewManagerModel;
import user.entity.CommonUserFactory;
import user.entity.UserFactory;
import user.service.clear_users.ClearInputBoundary;
import user.service.clear_users.ClearInteractor;
import user.service.clear_users.ClearOutputBoundary;
import user.service.clear_users.ClearUserDataAccessInterface;
import user.service.clear_users.interface_adapter.ClearController;
import user.service.clear_users.interface_adapter.ClearPresenter;
import user.service.clear_users.interface_adapter.ClearViewModel;
import user.service.login.interface_adapter.LoginViewModel;
import user.service.signup.SignupInputBoundary;
import user.service.signup.SignupInteractor;
import user.service.signup.SignupOutputBoundary;
import user.service.signup.SignupUserDataAccessInterface;
import user.service.signup.interface_adapter.SignupController;
import user.service.signup.interface_adapter.SignupPresenter;
import user.service.signup.interface_adapter.SignupViewModel;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignupUserDataAccessInterface signupUserDataAccessObject, ClearUserDataAccessInterface clearUserDataAccessInterface, ClearViewModel clearViewModel) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, signupUserDataAccessObject);
            ClearController clearController = createClearUseCase(clearViewModel, viewManagerModel, clearUserDataAccessInterface);
            return new SignupView(signupController, signupViewModel, clearController, clearViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignupUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

    private static ClearController createClearUseCase(ClearViewModel clearViewModel, ViewManagerModel viewManagerModel, ClearUserDataAccessInterface userDataAccessObject) throws IOException {
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(clearViewModel, viewManagerModel);

        ClearInputBoundary clearInteractor = new ClearInteractor(userDataAccessObject, clearOutputBoundary);

        return new ClearController(clearInteractor);
    }
}
