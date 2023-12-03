package plan.service.load_plan;
import plan.entity.plan.Plan;

public interface LoadPlanOutputBoundary {
    void prepareSuccessView(LoadPlanOutputData outputData);

    void prepareFailView(String error);
}