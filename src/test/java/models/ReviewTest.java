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
    @Test
    public void getCompetenceAreaReturnsCorrectly(){
        Review review = setupReview();
        assertEquals("844", review.getCompetenceArea());
    }
    @Test
    public void getTrainingUndertakenReturnsCorrectly(){
        Review review = setupReview();
        assertEquals("software", review.getTrainingUndertaken());
    }
    @Test
    public void getScheduledTrainingReturnsCorrectly(){
        Review review = setupReview();
        assertEquals("IT", review.getScheduledTraining());
    }
    // HELPER METHOD
    public Review setupReview(){
        return new Review("tito","23","844","software","IT", 1);

    }
}
