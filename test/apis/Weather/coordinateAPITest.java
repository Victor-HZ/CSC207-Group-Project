package apis.Weather;

import apis.weather.CoordinateAPI;
import org.junit.Before;
import org.junit.Test;
import plan.entity.address.Address;
import plan.entity.address.CanadaAddress;
import plan.entity.address.InvalidProvinceException;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class coordinateAPITest {
    private Address address;
    private Address toronto;
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
        Double longitude = 43.387608371000184;
        Double latitude = -79.81157340312407;
        address = new CanadaAddress(postCode, businessName, streetName, streetNumber, city, province, country, longitude, latitude);
        latToronto = 43.6534;
        longToronto = -79.383;
        toronto = new CanadaAddress(postCode, businessName, streetName, streetNumber, "Toronto", province, country, longToronto, latToronto);
    }

    @Test
    public void testHome() throws IOException {
        CoordinateAPI coor = new CoordinateAPI();
        HashMap<String, Double> update = coor.updateCoordinates(address);
        assertEquals(update.get("Latitude"), (Double) 43.3248);
        assertEquals((Object) update.get("Longitude"), -79.796);
    }

    @Test
    public void testToronto() throws IOException {
        CoordinateAPI coor = new CoordinateAPI();
        HashMap<String, Double> update = coor.updateCoordinates(toronto);
        assertEquals(update.get("Latitude"), toronto.getLatitude());
        assertEquals(update.get("Longitude"), toronto.getLongitude());
    }
}
