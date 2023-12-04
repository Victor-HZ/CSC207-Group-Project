package user.entity;

import plan.entity.plan.Plan;

import java.time.LocalDateTime;

public interface User {

    enum API_TOKEN{
    Ticketmaster,
    Coordinate,
    TripAdvisor;
    }
    void updatePlan(Plan plan);

    Plan getPlan();

    String getName();

    String getPassword();

    LocalDateTime getCreationTime();

    String getAPIToken(API_TOKEN apiToken);

    Plan getPlan();
}
