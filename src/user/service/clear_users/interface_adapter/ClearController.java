package user.service.clear_users.interface_adapter;


import user.service.clear_users.ClearInputBoundary;
import user.service.clear_users.ClearInputData;

import java.util.ArrayList;

public class ClearController {

    final ClearInputBoundary clearUseCaseInteractor;
    public ClearController(ClearInputBoundary clearUseCaseInteractor){
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute(ArrayList<String> usernames) {
        ClearInputData clearInputData = new ClearInputData(usernames);

        clearUseCaseInteractor.execute(clearInputData);
    }
}
