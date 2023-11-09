package plan.entity.activity;


import plan.entity.address.Address;

public interface Activity {
    String getName();
    Double getCost();
    Address getAddress();
    String getDescription();
}
