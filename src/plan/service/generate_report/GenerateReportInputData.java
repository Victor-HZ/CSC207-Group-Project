package plan.service.generate_report;

import user.entity.User;

public class GenerateReportInputData {
    private final User user;

    public GenerateReportInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}