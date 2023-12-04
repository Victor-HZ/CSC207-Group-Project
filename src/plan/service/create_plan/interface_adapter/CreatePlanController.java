package plan.service.create_plan.interface_adapter;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import plan.service.create_plan.CreatePlanInputBoundary;
import user.entity.User;

public class CreatePlanController {
    final CreatePlanInputBoundary createPlanUseCaseInteractor;
    public CreatePlanController(CreatePlanInputBoundary planUseCaseInteractor) {
        this.createPlanUseCaseInteractor = planUseCaseInteractor;
    }

    // When executed as there is no input data, will switch view to editor view only
    public void execute(DayInfo dayInfo, Address address, User user) {createPlanUseCaseInteractor.execute(dayInfo, address, user);}
}
