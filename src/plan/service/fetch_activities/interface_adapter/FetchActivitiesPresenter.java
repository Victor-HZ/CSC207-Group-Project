package plan.service.fetch_activities.interface_adapter;

import plan.service.fetch_activities.FetchActivitiesOutputBoundary;
import plan.service.fetch_activities.FetchActivitiesOutputData;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FetchActivitiesPresenter implements FetchActivitiesOutputBoundary {

    @Override
    public void prepareSuccessView(FetchActivitiesOutputData response) {
        LocalDateTime currentTime = LocalDateTime.now();
        response.setCreationTime(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        Integer activitySize = response.getActivities().size();
        String message = "Successfullly fetched " + activitySize.toString() + " Activities";
        JOptionPane.showMessageDialog(null, message);

    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
