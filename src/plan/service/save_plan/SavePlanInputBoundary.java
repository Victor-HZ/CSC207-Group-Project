package plan.service.save_plan;

import java.io.FileNotFoundException;

public interface SavePlanInputBoundary {
    void execute(SavePlanInputData savePlanInputData) throws FileNotFoundException;
}
