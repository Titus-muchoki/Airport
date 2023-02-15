package dao;

import models.Airport;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Sql2oAirportDaoTest {
    private static Connection conn;

    private Sql2oAirportDao airportDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/aircraft_test"; //connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        airportDao = new Sql2oAirportDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        airportDao.clearAll(); //clear all airports after every test

    }
    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addingAirportSetsId() throws Exception {
        Airport testAirport = setupAirport();
        assertNotEquals(1, testAirport.getId());
    }
    @Test
    public void addedAirportsAreReturnedFromGetAll() throws Exception {
        Airport testAirport = setupAirport();
        assertEquals(1, airportDao.getAll().size());
    }
    @Test
    public void noAirportsReturnsEmptyList() throws Exception {
        assertEquals(0, airportDao.getAll().size());
    }
    @Test
    public void findByIdReturnsCorrectAirport() throws Exception {
        Airport testAirport = setupAirport();
        Airport otherAirport = setupAirport();
        assertEquals(testAirport, airportDao.findById(testAirport.getId()));
        assertEquals(otherAirport, airportDao.findById(otherAirport.getId()));
    }
    @Test
    public void updateCorrectlyUpdatesAllFields() throws Exception {
        Airport airport = setupAirport();
        airportDao.update(airport.getId(), "JKIA", "214", "nairobi", "12");
        Airport airport1 = airportDao.findById(airport.getId());
        assertEquals("JKIA", airport1.getName());
        assertEquals("214", airport1.getCode());
        assertEquals("nairobi", airport1.getCity());
        assertEquals("12", airport1.getDistance());
    }
    @Test
    public void deleteByIdDeletesCorrectAirport() throws Exception {
        Airport testAirport = setupAirport();
        Airport otherAirport = setupAirport();
        airportDao.deleteById(testAirport.getId());
        assertEquals(1, airportDao.getAll().size());
    }
    @Test
    public void clearAll() throws Exception {
        Airport testAirport = setupAirport();
        Airport otherAirport = setupAirport();
        airportDao.clearAll();
        assertEquals(0, airportDao.getAll().size());
    }

    //HELPER METHODS
    public Airport setupAirport (){
        Airport airport = new Airport("JKIA", "214", "nairobi", "12");
        airportDao.add(airport);
        return airport;
    }
}
