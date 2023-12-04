package plan.service.create_plan;

import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

import java.time.LocalDateTime;

public class CreatePlanInteractor implements CreatePlanInputBoundary{
    final CreatePlanOutputBoundary createPlanPresenter;

    public CreatePlanInteractor(CreatePlanOutputBoundary createPlanOutputBoundary) {
        this.createPlanPresenter = createPlanOutputBoundary;
    }

    public void execute(DayInfo dayInfo, Address address) {
        LocalDateTime time = LocalDateTime.now();
        CreatePlanOutputData createPlanOutputData = new CreatePlanOutputData(time.toString(), false, dayInfo, address);

        try {
            createPlanPresenter.prepareEditorView(createPlanOutputData);
        } catch (Exception e) {
            createPlanPresenter.prepareFailView("An error has occured");
        }

    }
}
