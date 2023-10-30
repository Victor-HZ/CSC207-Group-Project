package entity.address;

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

public class Address {
    String postCode;
    String businessName;
    String streetName;
    Integer streetNumber;
    String city;
    Province province;
    String country = "Canada";

    Address(String postCode, String businessName, String streetName, Integer streetNumber, String city, String province, String country) throws IncorrectProvinceName{
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
            throw new IncorrectProvinceName(province);
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
    public Integer getStreetNumber(){
        return streetNumber;
    }
    public String getProvince(){
        return province.name();
    }
}
