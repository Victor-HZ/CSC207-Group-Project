package plan.service.fetch_activities.interface_adapter;

import plan.service.fetch_activities.FetchActivitiesOutputBoundary;
import plan.service.fetch_activities.FetchActivitiesOutputData;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FetchActivitiesPresenter implements FetchActivitiesOutputBoundary {
    // TODO implement this.
    @Override
    public void prepareSuccessView(FetchActivitiesOutputData response) {
        LocalDateTime currentTime = LocalDateTime.now();
        response.setCreationTime(currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        JOptionPane.showMessageDialog(null, response.getActivities().size());

    }

    @Override
    public void prepareFailView(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
