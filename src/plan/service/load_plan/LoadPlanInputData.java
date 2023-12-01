package plan.service.load_plan;
import plan.entity.plan.Plan
import java.util.ArrayList;

public class LoadPlanInputData {
    private final Plan plan;

    public LoadPlanInputData(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }
}
