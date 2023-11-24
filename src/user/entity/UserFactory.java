package user.entity;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface UserFactory {
    /** Requires: password is valid. */
    User create(String name, String password, LocalDateTime ltd, HashMap<User.API_TOKEN, String> apiTokens);
}
