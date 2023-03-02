package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeatureTest {
    @Before
    public void setup() throws Exception{

    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void getWidthRunWayReturnsCorrectly(){
        Feature feature = setupFeature();
        assertEquals("20", feature.getWidthRunWay());
    }
    @Test
    public void getLengthRunWayReturnsCorrectly(){
        Feature feature = setupFeature();
        assertEquals("20", feature.getLengthRunWay());
    }
    @Test
    public void getStrengthRunWayReturnsCorrectly(){
        Feature feature = setupFeature();
        assertEquals("40", feature.getStrengthRunWay());
    }
    @Test
    public void getAirportIdReturnsCorrectly() throws Exception{
        Feature feature = setupFeature();
        assertEquals(1,feature.getAirportId());
    }

    public Feature setupFeature(){
       return new Feature("20","20","40", 1);
    }
}
