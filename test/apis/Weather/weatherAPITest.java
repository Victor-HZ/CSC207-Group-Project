package apis.Weather;

import org.junit.Before;
import org.junit.Test;
import plan.entity.address.Address;
import plan.entity.address.CanadaAddress;
import plan.entity.address.InvalidProvinceException;
import plan.entity.day_info.Date;
import plan.entity.weather.Weather;
import plan.entity.weather.WeatherForecast;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class weatherAPITest {
    private Weather weather;
    private String rain;

    @Before
    public void init() throws InvalidProvinceException, IOException {
        String postCode = "L7M4B3";
        String businessName = "home";
        String streetName = "Dalecroft Crescent";
        Integer streetNumber = 2130;
        String city = "Burlington";
        String province = "ON";
        String country = "Canada";
        Double longitude = 43.387608371000184;
        Double latitude = -79.81157340312407;
        Address address = new CanadaAddress(postCode, businessName, streetName, streetNumber, city, province, country, longitude, latitude);
        weather = new WeatherForecast();
        Date date = new Date();
        weather.setWeather(date, address);
        rain = weather.getRain();
    }

    @Test
    public void weatherTest() {
        System.out.println(weather.toString());
        // TEST IS SUBJECT TO CHANGE AS THE WEATHER FORECAST IS ALWAYS CHANGING
        // THEREFORE IT IS ONLY TO SEE IF A STRING IS PRODUCED WITH THE CORRECT
        // SUBSTRINGS AND THROUGH THE PRINT WE CAN SEE IF IT IS CORRECT
        assertTrue(weather.toString().contains("temperature_2m"));
        assertTrue(weather.toString().contains("rain"));
        assertTrue(weather.toString().contains("time"));

    }

    @Test
    public void rainTest() {
        System.out.println(weather.getRain());
        assertEquals(weather.getRain(), "Moderate Rain");
    }
}
