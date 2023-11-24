package user.entity;

import java.time.LocalDateTime;

public interface User {

    enum API_TOKEN{
    Ticketmaster,
    Weather,
    TripAdvisor;
    }

    String getName();

    String getPassword();

    LocalDateTime getCreationTime();

    String getAPIToken(API_TOKEN apiToken);
}
