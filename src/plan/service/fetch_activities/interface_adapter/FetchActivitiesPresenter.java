package plan.service.fetch_activities.interface_adapter;

import plan.service.fetch_activities.FetchActivitiesOutputBoundary;
import plan.service.fetch_activities.FetchActivitiesOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FetchActivitiesPresenter implements FetchActivitiesOutputBoundary {
    // TODO implement this.
    @Override
    public void prepareSuccessView(FetchActivitiesOutputData response) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

    }

    @Override
    public void prepareFailView(String error) {

    }
}
