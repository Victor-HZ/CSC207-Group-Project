package plan.service.create_plan;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;
import user.entity.User;

public class CreatePlanOutputData {
    private String creationTime;
    private boolean useCaseFailed;
    private Plan plan;
    private Address address;
    public User user;

    public CreatePlanOutputData(String creationTime, boolean useCaseFailed, DayInfo dayInfo, Address address, User user){
        this.plan = new DatePlan(dayInfo, address);
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
        this.address = address;
        this.user = user;
    }

    public User getUser() {return user;}
    public String getCreationTime() {
        return creationTime;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Address getAddress() {
        return address;
    }
}
