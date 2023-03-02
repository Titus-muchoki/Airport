package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AirportTest {
    @Before
    public void setup() throws Exception{

    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void getNameReturnsCorrectName() throws Exception{
        Airport airport = setupAirport();
        assertEquals("JKIA", airport.getName());
    }
    @Test
    public void getCodeReturnsCorrectCode() throws Exception{
        Airport airport = setupAirport();
        assertEquals("214", airport.getCode());
    }
    @Test
    public void getCityReturnsCorrectCity() throws Exception{
        Airport airport = setupAirport();
        assertEquals("nairobi", airport.getCity());
    }
    @Test
    public void getDistanceShowsCorrectDistance() throws Exception{
        Airport airport = setupAirport();
        assertEquals("12", airport.getDistance());
    }

    @Test
    public void setNameSetsNameCorrectly(){
        Airport airport = setupAirport();
        airport.setName("wilson");
        assertEquals("wilson", airport.getName());
    }

    @Test
    public void setCodeSetsCodeCorrectly(){
        Airport airport = setupAirport();
        airport.setCode("123");
        assertNotEquals("233", airport.getCode());
    }
    @Test
    public void setCitySetsTheCityCorrectly(){
        Airport airport = setupAirport();
        airport.setCity("kisumu");
        assertNotEquals("nakuru", airport.getCity());
    }
    @Test
    public void setDistanceSetsTheCorrectDistance(){
        Airport airport = setupAirport();
        airport.setDistance("45");
        assertEquals("45", airport.getDistance());
    }
// helper
    public Airport setupAirport (){
        return new Airport("JKIA", "214", "nairobi", "12");
    }
}
