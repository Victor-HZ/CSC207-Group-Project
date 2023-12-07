package plan.service.generate_report;

import plan.entity.plan.Plan;

public class GenerateReportInputData {
    private final Plan plan;

    public GenerateReportInputData(Plan plan) {
        this.plan = plan;
    }

    Plan getPlan() {
        return plan;
    } // get plan from editor state
}