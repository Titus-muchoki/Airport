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
    public Feature setupFeature(){
       return new Feature("20","20","40",1);
    }
}
