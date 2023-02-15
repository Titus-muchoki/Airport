package dao;

import models.Airport;
import models.Feature;
import models.Review;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void getAllFeaturesByAirport() throws Exception {
        Airport testAirport = setupAirport();
        Airport otherAirport = setupAirport(); //add in some extra data to see if it interferes
        Feature feature1 = setupFeatureForAirport(testAirport);
        Feature feature2 = setupFeatureForAirport(testAirport);
        Feature featureForOtherAirport = setupFeatureForAirport(otherAirport);
        assertNotEquals(2, featureDao.getAllFeaturesByAirport(testAirport.getId()).size());
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
    @Test
    public void timeStampIsReturnedCorrectly() throws Exception {
        Airport testAirport = setupAirport();
        airportDao.add(testAirport);
        Feature testFeature = new Feature("20", "20","40", testAirport.getId());
        featureDao.add(testFeature);

        long creationTime = testFeature.getCreatedat();
        long savedTime = featureDao.getAll().get(0).getCreatedat();
        String formattedCreationTime = testFeature.getFormattedCreatedAt();
        String formattedSavedTime = featureDao.getAll().get(0).getFormattedCreatedAt();
        assertEquals(formattedCreationTime,formattedSavedTime);
        assertEquals(creationTime, savedTime);
    }
//    @Test
//    public void reviewsAreReturnedInCorrectOrder() throws Exception {
//        Airport testAirport = setupAirport();
//        airportDao.add(testAirport);
//        Feature testFeature = new Feature("20", "20", "40", testAirport.getId());
//        featureDao.add(testFeature);
//        try {
//            Thread.sleep(2000);
//        }
//        catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
//
//        Feature testSecondFeature = new Feature("20", "20", "40", testAirport.getId());
//        featureDao.add(testSecondFeature);
//
//        try {
//            Thread.sleep(2000);
//        }
//        catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
//
//        Feature testThirdFeature = new Feature("20", "20", "40", testAirport.getId());
//        featureDao.add(testThirdFeature);
//
//        try {
//            Thread.sleep(2000);
//        }
//        catch (InterruptedException ex){
//            ex.printStackTrace();
//        }
//
//        Feature testFourthFeature = new Feature("20", "20", "40", testAirport.getId());
//        featureDao.add(testFourthFeature);
//
//        assertEquals(4, featureDao.getAllFeaturesByAirport(testAirport.getId()).size()); //it is important we verify that the list is the same size.
//        assertEquals("20", featureDao.getAllFeaturesByAirportSortedNewestToOldest(testAirport.getId()).get(0).getContent());
//    }





    //helpers

    public Feature setupFeature() {
        Feature feature = new Feature("20", "20", "40", 1);
        featureDao.add(feature);
        return feature;
    }

    public Feature setupFeatureForAirport(Airport airport) {
        Feature feature = new Feature("20", "20", "40", airport.getId());
        airportDao.add(airport);
        return feature;
    }
    public Airport setupAirport (){
        Airport airport = new Airport("JKIA", "214", "nairobi", "12");
        airportDao.add(airport);
        return airport;
    }
}
