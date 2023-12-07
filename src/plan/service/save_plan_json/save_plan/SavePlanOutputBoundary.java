package plan.service.save_plan_json.save_plan;

public interface SavePlanOutputBoundary {
    void prepareSuccessView(SavePlanOutputData savePlanOutputData);

    void prepareFailView(String error);
}
