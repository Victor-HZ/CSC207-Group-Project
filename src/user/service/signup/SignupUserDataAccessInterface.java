package user.service.signup;

import user.entity.User;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
