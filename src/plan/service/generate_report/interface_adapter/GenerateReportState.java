package plan.service.generate_report.interface_adapter;

import plan.entity.activity.Activity;

import java.util.ArrayList;

public class GenerateReportState {
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getSuccessMessage() {return "Report Generated! Please find PlanReport.pdf in your files.";}
}
