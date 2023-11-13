package plan.service.fetch_activities;

import plan.entity.activity.Activity;

import java.util.ArrayList;

public interface FetchActivitiesOutputBoundary {
    void prepareSuccessView(FetchActivitiesOutputData user);

    void prepareFailView(String error);
}
