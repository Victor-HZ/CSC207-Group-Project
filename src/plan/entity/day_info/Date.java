package plan.entity.day_info;

import plan.entity.weather.Weather;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Date implements DayInfo {
    private LocalDateTime time;
    private Weather weather;

    public Date(){
        time = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return time.format(DateTimeFormatter.ISO_INSTANT);
    }

    public String toString(ToStringType type){
        switch (type){
            case TICKETMASTER:
                return this.toString();
            case WEATHER:
                this.time.format(DateTimeFormatter.ISO_LOCAL_DATE);
            default:
                return this.toString();
        }
    }

    @Override
    public String getInfo() {
        return this.toString() + weather.getStr();
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
    public LocalDateTime getDate() {
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
    public Weather getWeather() {
        return weather;
    }

    public String start;
    public String end;

    public void updateStart(String day) {
        // Day should be in the format of year-month-day T start hour (2018-04-02)
        start = day;
    }
    public void updateEnd(String day) {
        // Day should be in the format of year-month-day T start hour (2018-04-02)
        end = day;
    }

    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }

    public static void main(String[] args) throws DateTimeException {
        DayInfo day = new Date();
        day.setYear(2023);
        day.setMonth(11);
        day.setDay(10);
        day.setHour(15);
        System.out.println(day.toString());
    }
}
