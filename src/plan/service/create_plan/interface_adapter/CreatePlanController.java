package plan.service.create_plan.interface_adapter;

import plan.entity.day_info.DayInfo;
import plan.service.create_plan.CreatePlanInputBoundary;
import user.entity.User;

public class CreatePlanController {
    final CreatePlanInputBoundary planUseCaseInteractor;
    public CreatePlanController(CreatePlanInputBoundary planUseCaseInteractor) {
        this.planUseCaseInteractor = planUseCaseInteractor;
    }

    // When executed as there is no input data, will switch view to editor view only
    public void execute(DayInfo dayInfo, User user) {planUseCaseInteractor.execute(dayInfo, user);}
}
