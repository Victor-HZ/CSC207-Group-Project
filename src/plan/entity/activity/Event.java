package plan.entity.activity;


import plan.entity.address.Address;

public class Event implements Activity {
    String name;
    Address address;
    Double cost;
    String description;

    public Event() {

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

    }

    @Override
    public void setCost(Double cost) {

    }

    @Override
    public void setAddress(Address address) {

    }

    @Override
    public void setDescription(String description) {

    }

    public Event(String name, Address address, Double cost, String description){
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.description = description;
    }

}
