package plan.entity.day_info;

import plan.entity.weather.Weather;
import plan.entity.weather.WeatherForecast;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date implements DayInfo {
    private ZonedDateTime time;
    private Weather weather;

    public Date(){
        time = ZonedDateTime.now();
//        time = time.withHour(12);
//        time = time.withMinute(0);
//        time = time.withSecond(0);
        time = time.withNano(0);
    }

    @Override
    public String toString(){
        return time.format(DateTimeFormatter.ISO_INSTANT);
    }

    @Override
    public String stringInfo() {
        String time = toString();
//        String weather = getWeather().toString();
        return String.format("%s, %s", time, weather);
    }

    public String toString(ToStringType type){
        switch (type){
            case TICKETMASTER:
                return this.toString();
            case WEATHER:
                return this.time.format(DateTimeFormatter.ISO_LOCAL_DATE);
            default:
                return this.toString();
        }
    }

    @Override
    public String getInfo() {
        return this + weather.toString();
    }

    @Override
    public void setYear(Integer year) throws DateTimeException{
//        if (2000 < year && year < 2100) {
//            this.year = year.toString();
//            return;
//        }
//        time = time.withYear(year);
//        throw new InvalidDateException();
        time = time.withYear(year);
    }

    @Override
    public void setMonth(Integer month) throws DateTimeException{
        time = time.withMonth(month);
    }

    @Override
    public void setDay(Integer day)  throws DateTimeException{
        time = time.withDayOfMonth(day);
    }

    @Override
    public void setHour(Integer hour)  throws DateTimeException{
        time = time.withHour(hour);
    }

    @Override
    public void addDays(Integer days) {
        time = time.plusDays(days);
    }

    @Override
    public void addMonths(Integer months) {
        time = time.plusMonths(months);
    }

    @Override
    public void addYears(Integer years) {
        time = time.plusYears(years);
    }

    @Override
    public ZonedDateTime getDate() {
        return this.time;
    }

    @Override
    public Integer getYear() {
        return time.getYear();
    }

    @Override
    public Integer getMonth() {
        return time.getMonth().getValue();
    }

    @Override
    public Integer getDayOfMonth() {
        return time.getDayOfMonth();
    }

    @Override
    public DayOfWeek getDayofWeek() {
        return time.getDayOfWeek();
    }

    @Override
    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public void newWeather() {
        this.weather = new WeatherForecast();
    }

    @Override
    public Weather getWeather() {
        return weather;
    }

    @Override
    public String getPlanDate(){
        return String.format("%1$d-%2$d-%3$d", this.getDayOfMonth(), this.getMonth(), this.getYear());
    }

    public static void main(String[] args) throws DateTimeException {
        DayInfo day = new Date();
        day.setYear(2023);
        day.setMonth(12);
        day.setDay(10);
        day.setHour(15);
        System.out.println(day);
    }
}
