package plan.entity.activity;

import plan.entity.address.Address;

public class Meal implements Activity {
    String name;
    Address address;
    Double cost;
    String description;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Double getCost() {
        return null;
    }

    @Override
    public Address getAddress() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
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

    public Meal(String name, Address address, Double cost, String description){
        this.name = name;
        this.address = address;
        this.cost = cost;
        this.description = description;
    }

}
