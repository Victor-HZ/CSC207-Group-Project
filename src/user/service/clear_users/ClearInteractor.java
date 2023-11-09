package user.service.clear_users;

import java.util.ArrayList;

public class ClearInteractor implements ClearInputBoundary {
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessObject,
                           ClearOutputBoundary clearOutputBoundary){
        this.userDataAccessObject = userDataAccessObject;
        this.clearPresenter = clearOutputBoundary;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        ArrayList<String> usernames = clearInputData.getUsernames();
        usernames = userDataAccessObject.getUsernames();
        ArrayList<String> usernamesSuccessfullyDeleted = new ArrayList<>();
        for(String username : usernames){
            if(!userDataAccessObject.existsByName((String)username)){
                clearPresenter.prepareFailedView(username + ": Account does not exist.");
            } else {
                userDataAccessObject.delete((String) username);
                usernamesSuccessfullyDeleted.add(username);
            }
        }
        userDataAccessObject.finishDelete();
        ClearOutputData clearOutputData = new ClearOutputData(usernamesSuccessfullyDeleted, false);
        clearPresenter.prepareSuccessView(clearOutputData);
    }
}
