package dayinfo;

public class Date implements DayInfo {
    public String start;
    public String end;
    public Integer offset;

    public void updateStart(String day) {
        // Day should be in the format of year-month-day T start hour (2018-04-02T00:00:00)
        start = day;
    }

    public void updateEnd(String day) {
        // Day should be in the format of year-month-day T start hour (2018-04-02T00:00:00)
        end = day;
    }

    public Integer getOffset() {
        Integer startHour = Integer.parseInt(start.substring(10, 13));
        Integer endHour = Integer.parseInt(end.substring(10, 13));
        offset = endHour - startHour;
        return offset;
    }
}
