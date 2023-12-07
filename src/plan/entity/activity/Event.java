package plan.entity.activity;


import plan.entity.address.Address;
import plan.entity.day_info.DayInfo;

public class Event implements Activity {
    String name;
    Address address;
    Double cost;
    String description;
    DayInfo date;

    public Event() {

    }

    @Override
    public String toString() {
        String dayInfoString;
        if (getDayInfo() == null) {
            dayInfoString = "N/A";
        } else {
            dayInfoString = getDayInfo().stringInfo();
        }

        return String.format("%s, %s, %f, %s, %s", getName(), getAddress().toString(), getCost(),
                getDescription(), dayInfoString);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setDayInfo(DayInfo date) {
        this.date = date;
    }

    @Override
    public DayInfo getDayInfo() {
        return date;
    }

    @Override
    public boolean equals(Activity other) {
        return this.description.equals(other.getDescription()) &&
                this.name.equals(other.getName()) &&
                this.cost.equals(other.getCost()) &&
                this.address.equals(other.getAddress());
    }

    public Event(String name, Address address, Double cost, String description){
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.description = description;
    }

}
