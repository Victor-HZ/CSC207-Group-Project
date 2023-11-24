package user.entity;

import java.time.LocalDateTime;
import java.util.HashMap;

public class CommonUserFactory implements UserFactory {
    /**
     * Requires: password is valid.
     * @param name
     * @param password
     * @return
     */

    @Override
    public User create(String name, String password, LocalDateTime ltd, HashMap<User.API_TOKEN, String> apiTokens) {
        return new CommonUser(name, password, ltd, apiTokens);
    }
}
