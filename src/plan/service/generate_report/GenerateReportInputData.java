package plan.service.generate_report;

import user.entity.CommonUser;

public class GenerateReportInputData {
    private final CommonUser user;

    public GenerateReportInputData(CommonUser user) {
        this.user = user;
    }

    public CommonUser getUser() {
        return user;
    }
}