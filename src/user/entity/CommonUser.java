package user.entity;

import plan.entity.plan.Plan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final LocalDateTime creationTime;
    private final HashMap<API_TOKEN, String> apiTokens;
    private Plan plan;

    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password, LocalDateTime creationTime, HashMap<API_TOKEN, String> apiTokens) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
        this.apiTokens = apiTokens;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public String getAPIToken(API_TOKEN apiToken) {
        return apiTokens.getOrDefault(apiToken, "No Such Key");
    }


}
