package plan.entity.address;

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
    NL;
}

public class CanadaAddress implements Address{
    String postCode;
    String businessName;
    String streetName;
    Integer streetNumber;
    String city;
    Province province;
    String country = "Canada";

    public CanadaAddress(){

    }

    CanadaAddress(String postCode, String businessName, String streetName, Integer streetNumber, String city, String province, String country) throws InvalidProvinceException{
        this.postCode = postCode;
        this.businessName = businessName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
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

    public String getPostCode() {
        return postCode;
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
    public void setPostCode(String postCode) {
        this.postCode = postCode;
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
    public boolean equals(Address other) {
        return this.country.equals(other.getCountry()) &&
                this.city.equals(other.getCity()) &&
                this.streetNumber.toString().equals(other.getStreetNumber()) &&
                this.streetName.equals(other.getStreetName()) &&
                this.businessName.equals(other.getBusinessName()) &&
                this.postCode.equals(other.getPostCode()) &&
                this.province.name().equals(other.getProvince());
    }

//    public String getString(){
//        return
//    }
}
