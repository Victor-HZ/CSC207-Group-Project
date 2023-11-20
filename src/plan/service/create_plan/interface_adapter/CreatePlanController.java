package plan.service.create_plan.interface_adapter;

import plan.service.create_plan.CreatePlanInputBoundary;

public class CreatePlanController {
    final CreatePlanInputBoundary planUseCaseInteractor;
    public CreatePlanController(CreatePlanInputBoundary planUseCaseInteractor) {
        this.planUseCaseInteractor = planUseCaseInteractor;
    }
    
    public void execute() {}
}
