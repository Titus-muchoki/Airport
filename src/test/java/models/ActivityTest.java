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
            Activity activity = setupActivities();
            assertNotEquals(0, activity.getInspectionDate());
       }
       @Test
       public void getInspectionAreaReturnsCorrectly() throws Exception{
        Activity activity = setupActivities();
        assertEquals("court", activity.getInspectionArea());
       }
       @Test
       public void getInspectionOutcomeReturnsCorrectly() throws Exception{
        Activity activity = setupActivities();
        assertEquals("standard", activity.getInspectionOutcome());
       }
       @Test
       public void getServiceAbilityStatusReturnsCorrectly() throws Exception{
        Activity activity = setupActivities();
        assertEquals("good", activity.getServiceAbilityStatus());
       }
       @Test
       public void getAirportIdReturnsCorrectly() throws Exception{
        Activity activity = setupActivities();
        assertEquals(1, activity.getAirportId());
       }
       @Test
       public void setInspectionDateSetsCorrectly() throws  Exception{
        Activity activity = setupActivities();
        activity.setInspectionDate("28/02/2023");
        assertEquals("28/02/2023", activity.getInspectionDate());
       }
       @Test
       public void setInspectionAreaSetCorrectly() throws Exception{
        Activity activity = setupActivities();
        activity.setInspectionArea("gate c");
        assertEquals("gate c", activity.getInspectionArea());
       }
       @Test
       public void setInspectionOutcomeSetsCorrectly() throws Exception{
        Activity activity = setupActivities();
        activity.setInspectionOutcome("quit good");
        assertEquals("quit good", activity.getInspectionOutcome());
       }
       @Test
       public void setServiceAbilityStatusSetsCorrectly() throws  Exception{
        Activity activity = setupActivities();
        activity.setServiceAbilityStatus("medium");
        assertEquals("medium", activity.getServiceAbilityStatus());
       }
       @Test
       public void setAirportIdSetsAirportId() throws Exception{
        Activity activity = setupActivities();
        activity.setAirportId(2);
        assertEquals(2, activity.getAirportId());
       }

       // HELPER METHOD
    public Activity setupActivities(){
        return new Activity("12/3/23","court","standard","good",1);
    }
}
