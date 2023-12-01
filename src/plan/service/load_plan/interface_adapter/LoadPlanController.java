package plan.service.load_plan.interface_adapter;

public class LoadPlanController {
    private final LoadPlanInputBoundary loadPlanInteractor;

    public LoadPlanController(LoadPlanInputBoundary loadPlanInteractor) {
        this.loadPlanInteractor = loadPlanInteractor;
    }

    public void execute(Plan plan) {

        LoadPlanInputData inputData = new LoadPlanInputData(plan);

        loadPlanInteractor.loadPlan(inputData);
    }
}
