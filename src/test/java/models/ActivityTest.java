package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ActivityTest {
    @Before
    public void setup() throws Exception{

    }
       @After
    public void tearDown() throws Exception{

       }
       @Test
       public void getInspectionDateReturnsCorrectly() throws Exception{
            Activities activities = setupActivities();
            assertNotEquals(0, activities.getInspectionDate());
       }
       @Test
       public void getInspectionAreaReturnsCorrectly() throws Exception{
        Activities activities = setupActivities();
        assertEquals("court", activities.getInspectionArea());
       }
       @Test
       public void getInspectionOutcomeReturnsCorrectly() throws Exception{
        Activities activities = setupActivities();
        assertEquals("standard", activities.getInspectionOutcome());
       }
       @Test
       public void getServiceAbilityStatusReturnsCorrectly() throws Exception{
        Activities activities = setupActivities();
        assertEquals("good", activities.getServiceAbilityStatus());
       }

       // HELPER METHOD
    public Activities setupActivities(){
        return new  Activities("12/3/23","court","standard","good",1);
    }
}
