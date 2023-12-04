package user.service.logged_in.interface_adaper;

import user.entity.User;

public class LoggedInState {
    private User user = null;
    private String date = "";
    private String city = "";
    private String province = "";
    private String createPlanError = null;

    public LoggedInState(LoggedInState copy) {
        user = copy.user;
        date = copy.date;
        city = copy.city;
        province = copy.province;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setProvince(String province) {
        this.province = province;
    }


    public void setCreatePlanError(String createPlanError) {
        this.createPlanError = createPlanError;
    }

}
