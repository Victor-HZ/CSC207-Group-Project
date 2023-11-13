package plan.service.fetch_activities;

import plan.entity.activity.Activity;
import plan.service.fetch_activities.interface_adapter.FetchActivitiesController;

public interface FetchActivitiesDataAccessInterface {
    void save (Activity activity);
}
