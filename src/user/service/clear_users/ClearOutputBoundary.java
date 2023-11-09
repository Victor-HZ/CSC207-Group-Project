package user.service.clear_users;

public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData users);

    void prepareFailedView(String error);
}
