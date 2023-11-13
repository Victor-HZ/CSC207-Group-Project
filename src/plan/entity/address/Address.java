package plan.entity.address;

public interface Address {
    String getPostCode();
    String getBusinessName();
    String getStreetName();
    String getStreetNumber();
    String getCity();
    String getProvince();
    String getCountry();

    void setPostCode(String postCode);
    void setBusinessName(String businessName);
    void setStreetName(String streetName);
    void setStreetNumber(Integer streetNumber);
    void setCity(String city);
    void setProvince(String province) throws IncorrectProvinceName;
    void setCountry(String country);

    boolean equals(Address other);
}
