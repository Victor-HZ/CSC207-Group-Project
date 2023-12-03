package plan.service.save_plan;

public class SavePlanInteractor implements SavePlanInputBoundary{
    final SavePlanOutputBoundary savePlanPresenter;
    public SavePlanInteractor(SavePlanOutputBoundary savePlanPresenter) {
        this.savePlanPresenter = savePlanPresenter;
    }
    @Override
    public void execute(SavePlanInputData savePlanInputData) {

    }
}
