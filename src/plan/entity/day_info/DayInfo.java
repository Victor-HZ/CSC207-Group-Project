package plan.entity.day_info;

public interface DayInfo{
    String getStr();
    String getInfo();
    void setYear(Integer year) throws NotValidDateException;
    void setMonth(Integer month) throws NotValidDateException;
    void setDay(Integer day) throws NotValidDateException;
    void setHour(Integer hour) throws NotValidDateException;
    void setDate(String date) throws NotValidDateException;
}
