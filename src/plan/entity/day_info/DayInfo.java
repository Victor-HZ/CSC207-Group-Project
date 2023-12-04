package plan.entity.day_info;

import plan.entity.weather.Weather;

import java.time.*;

public interface DayInfo{

    @Override
    String toString();

    String toString(ToStringType type);

    String stringInfo();

    String getInfo();
    void setYear(Integer year) throws DateTimeException;
    void setMonth(Integer month) throws DateTimeException;
    void setDay(Integer day) throws DateTimeException;
    void setHour(Integer hour) throws DateTimeException;

    void addDays(Integer days);
    void addMonths(Integer months);
    void addYears(Integer years);

    ZonedDateTime getDate();
    Integer getYear();
    Integer getMonth();
    Integer getDayOfMonth();
    DayOfWeek getDayofWeek();

    void setWeather(Weather weather);
    Weather getWeather();
}
