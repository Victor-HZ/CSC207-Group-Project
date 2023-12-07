package plan.entity.address;

import java.io.IOException;

public interface Address {
    String getPostalCode();
    String getBusinessName();
    String getStreetName();
    String getStreetNumber();
    String getCity();
    String getProvince();
    String getCountry();

    String getCoordinates();
    Double getLongitude();
    Double getLatitude();

    void setLatitude(Double latitude);
    void setLongitude(Double longitude);

    void setPostalCode(String postalCode);
    void setBusinessName(String businessName);
    void setStreetName(String streetName);
    void setStreetNumber(Integer streetNumber);
    void setCity(String city);
    void setProvince(String province) throws InvalidProvinceException;
    void setCountry(String country);

    void updateCoordinates() throws IOException;

    boolean equals(Address other);

    public String getAddressText();
}
