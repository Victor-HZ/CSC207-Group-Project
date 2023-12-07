package plan.entity.address;

import apis.weather.Coordinate;

import java.io.IOException;
import java.util.HashMap;

enum Province {
    ON,
    QC,
    NS,
    NB,
    MB,
    BC,
    PE,
    SK,
    AB,
    NL
}

public class CanadaAddress implements Address{
    String postalCode = "";
    String businessName = "";
    String streetName = "";
    Integer streetNumber = 0;
    String city = "";
    Province province = Province.ON;
    String country = "CA";

    Double latitude = 0.0;
    Double longitude = 0.0;

    public CanadaAddress(){}

    public CanadaAddress(String postalCode, String businessName, String streetName, Integer streetNumber, String city, String province, String country, Double longitude, Double latitude) throws InvalidProvinceException{
        this.postalCode = postalCode;
        this.businessName = businessName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        boolean f = true;
        for(Province pro: Province.values()) {
            if (province.equalsIgnoreCase(pro.name())) {
                this.province = pro;
                f = false;
                break;
            }
        }
        if (f){
            throw new InvalidProvinceException(province);
        }
    }

    public String getPostalCode() {
        return postalCode;
    }
    public String getBusinessName(){
        return businessName;
    }
    public String getStreetName(){
        return streetName;
    }
    public String getCity(){
        return city;
    }
    public String getStreetNumber(){
        return streetNumber.toString();
    }
    public String getProvince(){
        return province.name();
   }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String getCoordinates() {
        return latitude.toString() + ',' + longitude.toString();
    }

    @Override
    public Double getLatitude() {
        return latitude;
    }

    @Override
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setProvince(String province) throws InvalidProvinceException {
        for(Province pro: Province.values()) {
            if (province.equalsIgnoreCase(pro.name())) {
                this.province = pro;
                return;
            }
        }
        throw new InvalidProvinceException(province);
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void updateCoordinates() throws IOException {
        Coordinate coordinate = new Coordinate();
        HashMap<String,Double> result = coordinate.updateCoordinates(this);
        this.longitude = result.get("Longitude");
        this.longitude = result.get("Latitude");
    }


    @Override
    public boolean equals(Address other) {
        return this.country.equals(other.getCountry()) &&
                this.city.equals(other.getCity()) &&
                this.streetNumber.toString().equals(other.getStreetNumber()) &&
                this.streetName.equals(other.getStreetName()) &&
                this.businessName.equals(other.getBusinessName()) &&
                this.postalCode.equals(other.getPostalCode()) &&
                this.province.name().equals(other.getProvince()) &&
                this.latitude.equals(other.getLatitude()) &&
                this.longitude.equals(other.getLongitude());
    }

    @Override
    public String getAddressText() {
        return String.format("%1$s %2$s, %3$s, %4$s, %5$s", this.getStreetNumber(),
                this.getStreetName(), this.getCity(), this.getProvince(), this.getCountry());
    }

    public String toString(){
        return country + " " + city + " " + province.name() + " " + streetNumber.toString() + " " + streetName + " " + postalCode;
    }
}
