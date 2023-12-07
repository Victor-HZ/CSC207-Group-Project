package plan.service.fetch_activities;

import apis.ActivitiesFetchInterface;
import plan.entity.activity.Activity;
import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;
import user.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class FetchActivitiesInteractor implements FetchActivitiesInputBoundary {
    final FetchActivitiesOutputBoundary fetchActivitiesPresenter;
    final ArrayList<ActivitiesFetchInterface> activitiesFetchInterfacesCollections;

    public FetchActivitiesInteractor(FetchActivitiesOutputBoundary fetchActivitiesPresenter, ArrayList<ActivitiesFetchInterface> activitiesFetchInterfacesCollections){
        this.fetchActivitiesPresenter = fetchActivitiesPresenter;
        this.activitiesFetchInterfacesCollections = activitiesFetchInterfacesCollections;
    }

    @Override
    public ArrayList<Activity> execute(DayInfo date, Address addresss, HashMap<User.API_TOKEN, String> apiTokens) {
        ArrayList<Activity> activities = new ArrayList<>();
        for(ActivitiesFetchInterface fetcher : activitiesFetchInterfacesCollections){
            activities.addAll(fetcher.getEvents(addresss, date, apiTokens.get(fetcher.getApi())));
        }
        if(!activities.isEmpty()){
            LocalDateTime time = LocalDateTime.now();
            FetchActivitiesOutputData fetchActivitiesOutputData = new FetchActivitiesOutputData(activities, false, time.toString());
            fetchActivitiesPresenter.prepareSuccessView(fetchActivitiesOutputData);
        } else {
            fetchActivitiesPresenter.prepareFailView("No activity fetched!");
        }
        return activities;
    }
}
