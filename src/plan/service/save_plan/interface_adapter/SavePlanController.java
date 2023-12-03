package plan.service.save_plan.interface_adapter;

import plan.entity.plan.Plan;
import plan.service.save_plan.SavePlanInputBoundary;
import plan.service.save_plan.SavePlanInputData;
import user.entity.User;

import java.io.File;
import java.io.FileNotFoundException;

public class SavePlanController {
    final SavePlanInputBoundary savePlanInteractor;

    public SavePlanController(SavePlanInputBoundary savePlanInteractor) {
        this.savePlanInteractor = savePlanInteractor;
    }

    public void execute(Plan dateplan, File csvFile, User commonUser) throws FileNotFoundException {
        SavePlanInputData savePlanInputData = new SavePlanInputData(dateplan, csvFile, commonUser);
        savePlanInteractor.execute(savePlanInputData);
    }
}
