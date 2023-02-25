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
       @Test
       public void getAirportIdReturnsCorrectly() throws Exception{
        Activities activities = setupActivities();
        assertEquals(1, activities.getAirportId());
       }
       @Test
       public void setInspectionDateSetsCorrectly() throws  Exception{
        Activities activities = setupActivities();
        activities.setInspectionDate("28/02/2023");
        assertEquals("28/02/2023", activities.getInspectionDate());
       }
       @Test
       public void setInspectionAreaSetCorrectly() throws Exception{
        Activities activities = setupActivities();
        activities.setInspectionArea("gate c");
        assertEquals("gate c", activities.getInspectionArea());
       }
       @Test
       public void setInspectionOutcomeSetsCorrectly() throws Exception{
        Activities activities = setupActivities();
        activities.setInspectionOutcome("quit good");
        assertEquals("quit good", activities.getInspectionOutcome());
       }
       @Test
       public void setServiceAbilityStatusSetsCorrectly() throws  Exception{
        Activities activities = setupActivities();
        activities.setServiceAbilityStatus("medium");
        assertEquals("medium", activities.getServiceAbilityStatus());
       }
       @Test
       public void setAirportIdSetsAirportId() throws Exception{
        Activities activities = setupActivities();
        activities.setAirportId(2);
        assertEquals(2, activities.getAirportId());
       }

       // HELPER METHOD
    public Activities setupActivities(){
        return new  Activities("12/3/23","court","standard","good",1);
    }
}
