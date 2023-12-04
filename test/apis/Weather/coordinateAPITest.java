package apis.Weather;

import apis.weather.Coordinate;
import org.junit.Before;
import org.junit.Test;
import plan.entity.address.Address;
import plan.entity.address.CanadaAddress;
import plan.entity.address.InvalidProvinceException;

import java.io.IOException;


public class coordinateAPITest {
    private Address address;
    private Double longToronto;
    private Double latToronto;

    @Before
    public void init() throws InvalidProvinceException {
        String postCode = "L7M4B3";
        String businessName = "home";
        String streetName = "Dalecroft Crescent";
        Integer streetNumber = 2130;
        String city = "Burlington";
        String province = "ON";
        String country = "Canada";
        Double longtitude = 43.387608371000184;
        Double latitude = -79.81157340312407;
        CanadaAddress home = new CanadaAddress(postCode, businessName, streetName, streetNumber, city, province, country, longtitude, latitude);
        address = home;
        longToronto = 43.6532;
        latToronto = 79.3832;
    }

    @Test
    public void simpleTest() throws IOException {
        Coordinate coor = new Coordinate();
        System.out.println(coor.updateCoordinates(address));
    }

    @Test
    public void testHome(){

    }
}
