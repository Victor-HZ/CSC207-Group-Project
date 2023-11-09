package user.service.clear_users;

import java.util.ArrayList;

public class ClearOutputData {
    private final ArrayList<String> usernames;
    private boolean useCaseFaild;

    public ClearOutputData(ArrayList<String> usernames, boolean useCaseFaild){
        this.usernames = usernames;
        this.useCaseFaild = useCaseFaild;
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }
}
