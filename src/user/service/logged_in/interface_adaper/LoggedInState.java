package user.service.logged_in.interface_adaper;

public class LoggedInState {
    private String username = "";
    private String createPlanError = null;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public void setCreatePlanError(String createPlanError) {
        this.createPlanError = createPlanError;
    }

}
