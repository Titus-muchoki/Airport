package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
}
