package user.service.clear_users.interface_adapter;

import java.util.ArrayList;

public class ClearState {
    private ArrayList<String> usernames;
    private String usernameError = null;

    public ClearState(ClearState copy){
        usernames = copy.usernames;
        usernameError = copy.usernameError;
    }

    public ClearState(){}

    public ArrayList<String> getUsernames(){return usernames;}

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernames(ArrayList<String> usernames){
        this.usernames = usernames;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }
}
