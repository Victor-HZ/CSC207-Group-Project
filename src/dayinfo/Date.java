package dayinfo;

public class Date implements DayInfo {
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
}
