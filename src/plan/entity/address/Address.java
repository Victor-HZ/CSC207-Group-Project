package plan.entity.address;

import java.io.IOException;

public interface Address {
    String getPostCode();
    String getBusinessName();
    String getStreetName();
    String getStreetNumber();
    String getCity();
    String getProvince();
    String getCountry();

    String getCoordinates();
    Double getLongtitude();
    Double getLatitude();

    void setLatitude(Double latitude);
    void setLongtitude(Double longtitude);

    void setPostCode(String postCode);
    void setBusinessName(String businessName);
    void setStreetName(String streetName);
    void setStreetNumber(Integer streetNumber);
    void setCity(String city);
    void setProvince(String province) throws InvalidProvinceException;
    void setCountry(String country);

    void updateCoordinates() throws IOException;

    boolean equals(Address other);
}
