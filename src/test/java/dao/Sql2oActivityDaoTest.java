package dao;

import models.Activity;
import models.Airport;
import models.Feature;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oActivityDaoTest {
    private static Connection conn;

    private Sql2oActivityDao activityDao;
    private Sql2oAirportDao airportDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/aircraft_test"; //connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        activityDao = new Sql2oActivityDao(sql2o);
        airportDao = new Sql2oAirportDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        activityDao.clearAll(); //clear all restaurants after every test
        airportDao.clearAll(); //clear all restaurants after every test
    }
    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingActivitySetsId() throws Exception {
        Activity testActivity = setupActivities();
        assertNotEquals(1, testActivity.getId());
    }
    @Test
    public void getAll() throws Exception {
        Activity activity = setupActivities();
        Activity activity1 = setupActivities();
        assertEquals(0, airportDao.getAll().size());
    }

@Test
public void getAllAirportsByActivityReturnsAirportsCorrectly() {
    Activity activity = setupActivities();
    activityDao.add(activity);
    int airportId = activity.getId();
    Airport newAirport = new Airport("", "" , "", "");
    Airport otherAirport = new Airport("", "","", "");
    Airport  thirdAirport = new Airport("","","", "");
    airportDao.add(newAirport);
    airportDao.add(otherAirport);
    assertNotEquals(2, activityDao.getAllActivitysByAirport( airportId).size());
    assertFalse(activityDao.getAllActivitysByAirport( airportId).contains(newAirport));
    assertFalse(activityDao.getAllActivitysByAirport( airportId).contains(otherAirport));
    assertFalse(activityDao.getAllActivitysByAirport( airportId).contains(thirdAirport)); //things are accurate!
}
    @Test
    public void deleteById() throws Exception{
        Activity testActivity = setupActivities();
        Activity otherActivity = setupActivities();
        activityDao.deleteById(testActivity.getId());
        assertEquals(0,activityDao.getAll().size());
        assertEquals(0,activityDao.getAll().size());
    }
    @Test
    public void clearAll()throws Exception{
        Activity activity = setupActivities();
        Activity activity1 = setupActivities();
        activityDao.clearAll();
        assertEquals(0, activityDao.getAll().size());
    }



    // HELPER METHOD
    public Activity setupActivities(){
        return new Activity("12/3/23","court","standard","good",1);
    }
    public Activity setupActivityForAirport(Airport airport) throws Exception{
        Activity activity = new Activity("12/3/23","court","standard","good",1);
        airportDao.add(airport);
        return activity;
    }
    public Airport setupAirport (){
        Airport airport = new Airport("JKIA", "214", "nairobi", "12");
        airportDao.add(airport);
        return airport;
    }
}
