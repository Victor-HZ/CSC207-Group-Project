package plan.service.create_plan.interface_adapter;

import plan.service.create_plan.CreatePlanInputBoundary;

public class CreatePlanController {
    final CreatePlanInputBoundary planUseCaseInteractor;
    public CreatePlanController(CreatePlanInputBoundary planUseCaseInteractor) {
        this.planUseCaseInteractor = planUseCaseInteractor;
    }

    // When executed as there is no input data, will switch view to editor view only
    public void execute() {planUseCaseInteractor.execute();}
}
