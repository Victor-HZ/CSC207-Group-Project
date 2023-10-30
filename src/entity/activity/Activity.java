package entity.activity;

import entity.address.Address;

public interface Activity {
    String getName();
    Double getCost();
    Address getAddress();
    String getDescription();
}
