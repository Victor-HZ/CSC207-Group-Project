package user.service.logged_in.interface_adaper;

public class LoggedInState {
    private String username = "";
    private String date = "";
    private String city = "";
    private String country = "";
    private String createPlanError = null;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
        date = copy.date;
        city = copy.city;
        country = copy.country;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public void setCreatePlanError(String createPlanError) {
        this.createPlanError = createPlanError;
    }

}
