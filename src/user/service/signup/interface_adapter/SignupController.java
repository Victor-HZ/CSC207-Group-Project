package user.service.signup.interface_adapter;

import user.entity.User;
import user.service.signup.SignupInputBoundary;
import user.service.signup.SignupInputData;

import java.util.HashMap;

public class SignupController {

    final SignupInputBoundary userSignupUseCaseInteractor;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2, HashMap<User.API_TOKEN, String> apiTokens) {
        SignupInputData signupInputData = new SignupInputData(username, password1, password2, apiTokens);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
