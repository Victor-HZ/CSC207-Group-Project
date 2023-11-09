package plan.entity.day_info;

import plan.entity.weather.Weather;

import java.util.ArrayList;
import java.util.Arrays;

public class Date implements DayInfo {
    private String year;
    private String month;
    private String day;
    private String hour;
    private Weather weather;

    @Override
    public String getStr() {
        return String.format("%s-%s-%sT%s:00:00Z", year, month, day, hour);
    }

    @Override
    public String getInfo() {
        return getStr() + weather.getStr();
    }

    @Override
    public void setYear(Integer year) throws NotValidDateException{
        if (2000 < year && year < 2100) {
            this.year = year.toString();
            return;
        }
        throw new NotValidDateException();
    }

    @Override
    public void setMonth(Integer month) throws NotValidDateException{
        if (0 < month && month < 13) {
            this.month = month.toString();
            return;
        }
        throw new NotValidDateException();
    }

    @Override
    public void setDay(Integer day)  throws NotValidDateException{
        if (month == null || day <= 0){
            throw new NotValidDateException();
        }
        ArrayList<String> validMonth = new ArrayList<String>(
                Arrays.asList("1", "3", "5", "7", "8", "10", "12")
        );
        ArrayList<String> validYear = new ArrayList<String>();
        for(int i = 2000; i <= 2100; i ++){
            if (i % 4 == 0 && i % 100 != 0){
                validYear.add(Integer.toString(i));
            }
        }
        if(day < 28){
            this.day = day.toString();
            return;
        } else if(day == 29){
            if(month.equals("2")){
                if(validYear.contains(year)) {
                    this.day = day.toString();
                    return;
                }
                throw new NotValidDateException();
            }
        } else if(day == 30){
            if(month.equals(("2"))){
                throw new NotValidDateException();
            }
            this.day = day.toString();
            return;
        }
        else if(day == 31){
            if(validMonth.contains(month)){
                this.day = day.toString();
                return;
            }
            throw new NotValidDateException();
        }
        throw new NotValidDateException();
    }

    @Override
    public void setHour(Integer hour)  throws NotValidDateException{
        if(0 <= hour && hour <= 24){
            this.hour = hour.toString();
        } else {
            throw new NotValidDateException();
        }
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
    @Override
    public void setDate(String date)  throws NotValidDateException{
        throw new NotValidDateException();
    }

    public static void main(String[] args) throws NotValidDateException {
        DayInfo day = new Date();
        day.setYear(2023);
        day.setMonth(11);
        day.setDay(10);
        day.setHour(15);
        System.out.println(day.getStr());
    }
}
