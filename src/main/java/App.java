import com.google.gson.Gson;
import dao.Sql2oAirportDao;
import exceptions.ApiException;
import models.Airport;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2oAirportDao airportDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/aircraft"; //connect to aircraft, not jadle_test!
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");

        airportDao = new Sql2oAirportDao(sql2o);
        conn = sql2o.open();

        //CREATE
        post("/airports/new", "application/json", (req, res) -> {
            if (req.body().isEmpty()){
                return gson.toJson("error:payload cannot be null");
            }
            Airport airport = gson.fromJson(req.body(), Airport.class);
            airportDao.add(airport);
            res.status(201);;
            return gson.toJson(airport);
        });


        //FILTERS

        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });


        after((req, res) ->{
            res.type("application/json");
        });

    }
}