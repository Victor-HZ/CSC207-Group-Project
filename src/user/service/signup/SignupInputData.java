package user.service.signup;

import user.entity.User;

import java.util.HashMap;

public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;
    final private HashMap<User.API_TOKEN, String> apiTokens;

    public SignupInputData(String username, String password, String repeatPassword, HashMap<User.API_TOKEN, String> apiTokens) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.apiTokens = apiTokens;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public HashMap<User.API_TOKEN, String> getAPIToken(){
        return apiTokens;
    }
}
