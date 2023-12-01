package plan.service.create_plan;

import plan.service.fetch_activities.FetchActivitiesOutputData;
import user.entity.User;
import user.entity.UserFactory;

import java.time.LocalDateTime;

public class CreatePlanInteractor implements CreatePlanInputBoundary{
    final CreatePlanOutputBoundary createPlanPresenter;

    public CreatePlanInteractor(CreatePlanOutputBoundary createPlanOutputBoundary) {
        this.createPlanPresenter = createPlanOutputBoundary;
    }

    public void execute() {
        LocalDateTime time = LocalDateTime.now();
        CreatePlanOutputData createPlanOutputData = new CreatePlanOutputData(time.toString(), false);

        try {
            createPlanPresenter.prepareEditorView(createPlanOutputData);
        } catch (Exception e) {
            createPlanPresenter.prepareFailView("An error has occured");
        }

    }
}
