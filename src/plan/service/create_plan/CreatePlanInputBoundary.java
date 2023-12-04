package plan.service.create_plan;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import user.entity.User;

public interface CreatePlanInputBoundary {
    void execute(DayInfo dayInfo, Address address, User user);
}
