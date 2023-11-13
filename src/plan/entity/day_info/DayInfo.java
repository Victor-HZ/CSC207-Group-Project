package plan.entity.day_info;

public interface DayInfo{
    String getStr();
    String getInfo();
    void setYear(Integer year) throws InvalidDateException;
    void setMonth(Integer month) throws InvalidDateException;
    void setDay(Integer day) throws InvalidDateException;
    void setHour(Integer hour) throws InvalidDateException;
    void setDate(String date) throws InvalidDateException;
}
