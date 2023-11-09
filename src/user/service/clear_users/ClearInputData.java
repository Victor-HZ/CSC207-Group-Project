package user.service.clear_users;

import java.util.ArrayList;

public class ClearInputData {

    final private ArrayList<String> usernames;

    public ClearInputData(ArrayList<String> usernames){
        this.usernames = usernames;
    }

    ArrayList<String> getUsernames(){
        return usernames;
    }

}
