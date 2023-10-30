package entity.activity;

import entity.address.Address;

public class Event implements Activity {
    String name;
    Address address;
    Double cost;
    String description;
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

    Event(String name, Address address, Double cost, String description){
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.description = description;
    }

}
