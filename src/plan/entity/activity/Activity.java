package plan.entity.activity;


import plan.entity.address.Address;

public interface Activity {

    String getName();
    Double getCost();
    Address getAddress();
    String getDescription();
    void setName(String name);
    void setCost(Double cost);
    void setAddress(Address address);
    void setDescription(String description);
}
