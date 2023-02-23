package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReviewTest {
    @Before
    public void setup() throws Exception{

    }
    @After
    public void tearDown() throws Exception{

    }
    @Test
    public void getInspectorNameReturnsCorrectly(){
        Review review = setupReview();
        assertEquals("tito", review.getInspectorName());
    }
    @Test
    public void getInspectorCodeReturnsCorrectly(){
        Review review = setupReview();
        assertEquals("23", review.getInspectorCode());
    }
    // HELPER METHOD
    public Review setupReview(){
        return new Review("tito","23","844","software","IT", 1);

    }
}
