package plan.service.create_plan;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.DatePlan;
import plan.entity.plan.Plan;

public class CreatePlanOutputData {
    private String creationTime;
    private boolean useCaseFailed;
    private Plan plan;
    private Address address;

    public CreatePlanOutputData(String creationTime, boolean useCaseFailed, DayInfo dayInfo, Address address){
        this.plan = new DatePlan(dayInfo);
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
        this.address = address;
    }

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
