package dao;

import models.Airport;
import models.Review;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;

public class Sql2oReviewDaoTest {
    private static Connection conn;

    private Sql2oReviewDao reviewDao;
    private Sql2oAirportDao airportDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/aircraft_test"; //connect to postgres test database
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        reviewDao = new Sql2oReviewDao(sql2o);
        airportDao = new Sql2oAirportDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        reviewDao.clearAll(); //clear all airports after every test
        airportDao.clearAll(); //clear all airports after every test
    }
    @AfterClass //changed to @AfterClass (run once after all tests in this file completed)
    public static void shutDown() throws Exception{ //changed to static
        conn.close(); // close connection once after this entire test file is finished
        System.out.println("connection closed");
    }
    @Test
    public void addReviewsSetsReviewsCorrectly(){
    Review review = setupReview();
    assertEquals(0, review.getId());
    }
    // HELPER METHOD
    public Review setupReview(){
        return new Review("tito","23","844","software","IT", 1);

    }
    public Review setupReviewForAirport(Airport airport){
        Review review = new Review("tito","23","844","software","IT", airport.getId());
        airportDao.add(airport);
        return review;
    }
    public Airport setupAirport (){
        Airport airport = new Airport("JKIA", "214", "nairobi", "12");
        airportDao.add(airport);
        return airport;
    }
}
