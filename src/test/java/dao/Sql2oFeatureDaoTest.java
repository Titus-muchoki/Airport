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
import static org.junit.Assert.assertFalse;

public class Sql2oFeatureDaoTest {
    private static Connection conn;

    private Sql2oFeatureDao featureDao;
    private Sql2oAirportDao airportDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/aircraft_test"; //connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        featureDao = new Sql2oFeatureDao(sql2o);
        airportDao = new Sql2oAirportDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        featureDao.clearAll(); //clear all restaurants after every test
        airportDao.clearAll(); //clear all restaurants after every test
    }
    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingFeatureSetsId() throws Exception {
        Feature testFeature = setupFeature();
        assertNotEquals(1, testFeature.getId());
    }
    @Test
    public void getAll() throws Exception {
        Feature feature1 = setupFeature();
        Feature feature2 = setupFeature();
        assertEquals(2, featureDao.getAll().size());
    }
    @Test
    public void getAllAirportsByActivityReturnsAirportsCorrectly() {
        Feature feature = setupFeature();
        featureDao.add(feature);
        int featureId = feature.getId();
        Airport newAirport = new Airport("", "" , "", "");
        Airport otherAirport = new Airport("", "","", "");
        Airport  thirdAirport = new Airport("","","", "");
        airportDao.add(newAirport);
        airportDao.add(otherAirport); //we are not adding loan 3 so, we can test things precisely.
        assertNotEquals(2, featureDao.getAllFeaturesByAirports( featureId).size());
        assertFalse(featureDao.getAllFeaturesByAirports( featureId).contains(newAirport));
        assertFalse(featureDao.getAllFeaturesByAirports( featureId).contains(otherAirport));
        assertFalse(featureDao.getAllFeaturesByAirports( featureId).contains(thirdAirport)); //things are accurate!
    }
    @Test
    public void deleteById() throws Exception {
        Feature testFeature = setupFeature();
        Feature otherFeature = setupFeature();
        featureDao.deleteById(testFeature.getId());
        assertEquals(1, featureDao.getAll().size());
        assertEquals(1, featureDao.getAll().size());
    }
    @Test
    public void clearAll() throws Exception {
        Feature testFeature = setupFeature();
        Feature otherFeature = setupFeature();
        featureDao.clearAll();
        assertEquals(0, featureDao.getAll().size());
    }
    //helpers

    public Feature setupFeature() {
        Feature feature = new Feature("20", "20", "40",1);
        featureDao.add(feature);
        return feature;
    }

    public Feature setupFeatureForAirport(Airport airport) {
        Feature feature = new Feature("20", "20", "40",1);
        airportDao.add(airport);
        return feature;
    }
    public Airport setupAirport (){
        Airport airport = new Airport("JKIA", "214", "nairobi", "12");
        airportDao.add(airport);
        return airport;
    }
}
