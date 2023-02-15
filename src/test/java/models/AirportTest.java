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
        assertNotEquals("Joy", airport.getName());
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
    public Airport setupAirport (){
        return new Airport("JKIA", "214", "nairobi", "12");
    }
}
