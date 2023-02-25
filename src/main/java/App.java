import com.google.gson.Gson;
import dao.Sql2oActivityDao;
import dao.Sql2oAirportDao;
import dao.Sql2oFeatureDao;
import dao.Sql2oReviewDao;
import exceptions.ApiException;
import models.Activity;
import models.Airport;
import models.Feature;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Sql2oAirportDao airportDao;
        Sql2oFeatureDao featureDao;
        Sql2oReviewDao reviewDao;
        Sql2oActivityDao activityDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/aircraft"; //connect to aircraft, not jadle_test!
        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        featureDao = new Sql2oFeatureDao(sql2o);
        airportDao = new Sql2oAirportDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        activityDao = new Sql2oActivityDao(sql2o);
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
        //READ
        get("/airports", "application/json", (req, res) -> {
            System.out.println(airportDao.getAll());

            if (airportDao.getAll().size() > 0){
                return gson.toJson(airportDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no airports are currently listed in the database.\"}";
            }
        });

        get("/airports/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int airportId = Integer.parseInt(req.params("id"));
            Airport airportToFind = airportDao.findById(airportId);
            if (airportToFind == null){
                throw new ApiException(404, String.format("No airport with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(airportId);
        });

        get("/airports/:id/features", "application/json", (req, res) -> {
            int airportId = Integer.parseInt(req.params("id"));

            Airport airportToFind = airportDao.findById(airportId);
            List<Feature> allFeatures;

            if (airportToFind == null){
                throw new Exception("No airport by that Id");
            }

            allFeatures = featureDao.getAllFeaturesByAirport(airportId);

            return gson.toJson(allFeatures);
        });

        //CREATE
        post("/features/new", "application/json", (req, res) -> {
            if (req.body().isEmpty()){
                return gson.toJson("error:payload cannot be null");
            }
            Feature feature = gson.fromJson(req.body(), Feature.class);
            featureDao.add(feature);
            res.status(201);;
            return gson.toJson(feature);
        });
        //READ
        get("/features", "application/json", (req, res) -> {
            System.out.println(featureDao.getAll());

            if (featureDao.getAll().size() > 0){
                return gson.toJson(featureDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no airports are currently listed in the database.\"}";
            }
        });

        post("/airports/:airportId/features/new", "application/json", (req, res) ->{
            int airportId = Integer.parseInt(req.params("airportId"));
            Feature feature = gson.fromJson(req.body(), Feature.class);
            feature.setCreatedat(); //I am new!
            feature.setFormattedCreatedAt();
            feature.setAirportId(airportId);
            featureDao.add(feature);
            res.status(201);
            return gson.toJson(feature);
        });
        //CREATE
        post("/reviews/new", "application/json", (req, res) -> {
            if (req.body().isEmpty()){
                return gson.toJson("error:payload cannot be null");
            }
            Review review = gson.fromJson(req.body(), Review.class);
            reviewDao.add(review);
            res.status(201);;
            return gson.toJson(review);
        });
        //READ
        get("/reviews", "application/json", (req, res) -> {
            System.out.println(reviewDao.getAll());

            if (reviewDao.getAll().size() > 0){
                return gson.toJson(reviewDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no airports are currently listed in the database.\"}";
            }
        });


        get("/airports/:id/reviews", "application/json", (req, res) -> {
            int airportId = Integer.parseInt(req.params("id"));

            Airport airportToFind = airportDao.findById(airportId);
            List<Review> allReviews;

            if (airportToFind == null){
                throw new Exception("No airport by that Id");
            }

            allReviews = reviewDao.getAllReviewsByAirport(airportId);

            return gson.toJson(allReviews);
        });
        post("/airports/:airportId/reviews/new", "application/json", (req, res) ->{
            int airportId = Integer.parseInt(req.params("airportId"));
            Review review = gson.fromJson(req.body(), Review.class);
            review.setAirportId(airportId);
            reviewDao.add(review);
            res.status(201);
            return gson.toJson(review);
        });
        //CREATE
        post("/activities/new", "application/json", (req, res) -> {
            if (req.body().isEmpty()){
                return gson.toJson("error:payload cannot be null");
            }
            Activity activity = gson.fromJson(req.body(), Activity.class);
            activityDao.add(activity);
            res.status(201);;
            return gson.toJson(activity);
        });
        //READ
        get("/activities", "application/json", (req, res) -> {
            System.out.println(activityDao.getAll());

            if (activityDao.getAll().size() > 0){
                return gson.toJson(activityDao.getAll());
            }
            else {
                return "{\"message\":\"I'm sorry, but no activities are currently listed in the database.\"}";
            }
        });


        get("/airports/:id/activities", "application/json", (req, res) -> {
            int airportId = Integer.parseInt(req.params("id"));

            Airport airportToFind = airportDao.findById(airportId);
            List<Activity> allActivities;

            if (airportToFind == null){
                throw new Exception("No airport by that Id");
            }

            allActivities = activityDao.getAllActivitiesByAirport(airportId);

            return gson.toJson(allActivities);
        });
        post("/airports/:airportId/activities/new", "application/json", (req, res) ->{
            int airportId = Integer.parseInt(req.params("airportId"));
            Activity activity = gson.fromJson(req.body(), Activity.class);
            activity.setAirportId(airportId);
            activityDao.add(activity);
            res.status(201);
            return gson.toJson(activity);
        });
//        delete("/airports/:airportId/reviews/:reviewid/delete", "application/json", (req, res) ->{
//            int airportId = Integer.parseInt(req.params("airportId"));
//            Review review = gson.fromJson(req.body(), Review.class);
//            review.setAirportId(airportId);
//            reviewDao.add(review);
//            res.status(201);
//            return gson.toJson(review);
//        });

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
