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
    public Airport setupAirport (){
        return new Airport("JKIA", "214", "nairobi", "12");
    }
}
