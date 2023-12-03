package plan.service.save_plan;

import user.entity.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SavePlanInteractor implements SavePlanInputBoundary{
    final SavePlanOutputBoundary savePlanPresenter;
    public SavePlanInteractor(SavePlanOutputBoundary savePlanPresenter) {
        this.savePlanPresenter = savePlanPresenter;
    }
    @Override
    public void execute(SavePlanInputData savePlanInputData) throws FileNotFoundException {
        // First adding the plan to the user
        User user = savePlanInputData.getCommonUser();
        user.


        Scanner scanner = new Scanner(savePlanInputData.getCsvFile());

    }
}
