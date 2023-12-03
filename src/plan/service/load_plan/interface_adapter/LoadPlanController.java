package plan.service.load_plan.interface_adapter;
import plan.service.load_plan.LoadPlanInputBoundary;
import plan.service.load_plan.LoadPlanInputData;

public class LoadPlanController {
    private final LoadPlanInputBoundary loadPlanInteractor;

    public LoadPlanController(LoadPlanInputBoundary loadPlanInteractor) {
        this.loadPlanInteractor = loadPlanInteractor;
    }

    public void execute(DatePlan datePlan) {
        LoadPlanInputData inputData = new LoadPlanInputData(datePlan);
        loadPlanInteractor.loadPlan(inputData);
    }
}
