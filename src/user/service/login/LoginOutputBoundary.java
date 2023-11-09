package user.service.login;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user);

    void prepareFailView(String error);
}