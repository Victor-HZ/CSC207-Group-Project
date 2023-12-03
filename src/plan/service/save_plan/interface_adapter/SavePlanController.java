package plan.service.save_plan.interface_adapter;

import plan.entity.plan.Plan;
import plan.service.save_plan.SavePlanInputBoundary;
import plan.service.save_plan.SavePlanInputData;

public class SavePlanController {
    final SavePlanInputBoundary savePlanInteractor;

    public SavePlanController(SavePlanInputBoundary savePlanInteractor) {
        this.savePlanInteractor = savePlanInteractor;
    }

    public void execute(Plan dateplan) {
        SavePlanInputData savePlanInputData = new SavePlanInputData(dateplan);
        savePlanInteractor.execute(savePlanInputData);
    }
}
