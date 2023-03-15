import dao.Sql2oActivityDao;
import dao.Sql2oAirportDao;
import dao.Sql2oFeatureDao;
import dao.Sql2oReviewDao;
import models.Activity;
import models.Airport;
import models.Feature;
import models.Review;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8090);
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/aircraft";

        Sql2o sql2o = new Sql2o(connectionString, "kajela", "8444");
        Sql2oAirportDao airportDao = new Sql2oAirportDao(sql2o);
        Sql2oActivityDao activityDao = new Sql2oActivityDao(sql2o);
        Sql2oFeatureDao featureDao = new Sql2oFeatureDao(sql2o);
        Sql2oReviewDao reviewDao = new Sql2oReviewDao(sql2o);

        //get: show all airports with all activities and show all activities

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Activity> allActivities = activityDao.getAll();
            model.put("activities", allActivities);
            model = new HashMap<>();
            List<Feature> features = featureDao.getAll();
            model.put("features", features);
            List<Review> reviews = reviewDao.getAll();
            model.put("reviews", reviews);
            List<Airport> airports = airportDao.getAll();
            model.put("airports", airports);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to create a new activity

        get("/activities/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Activity> activities = activityDao.getAll(); //refresh list of links for navbar
            model.put("activities", activities);
            return new ModelAndView(model, "activity-form.hbs"); //new layout
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new activity

        post("/activities", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String inspectionDate = req.queryParams("inspectionDate");
            String inspectionArea = req.queryParams("inspectionArea");
            String inspectionOutcome = req.queryParams("inspectionOutcome");
            String serviceAbilityStatus = req.queryParams("serviceAbilityStatus");
            int airportId = Integer.parseInt(req.queryParams("airportId"));
            Activity  newActivity = new Activity(inspectionDate,inspectionArea,inspectionOutcome,serviceAbilityStatus,airportId);
            activityDao.add(newActivity);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show new booking form
        get("/airports/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Activity> activities =  activityDao.getAll();
            model.put("activities", activities);
            return new ModelAndView(model, "airport-form.hbs");
        }, new HandlebarsTemplateEngine());


//        //task: process new booking form
        post("/airports", (req, res) -> { //URL to make new task on POST rout
            Map<String, Object> model = new HashMap<>();
            List<Activity> allActivities = activityDao.getAll();
            model.put("activities", allActivities);
            String name = req.queryParams("name");
            String code = req.queryParams("code");
            String city = req.queryParams("city");
            String distance = req.queryParams("distance");
            Airport newAirport = new Airport(name, code, city, distance);//See what we did with the hard coded categoryId?
            airportDao.add(newAirport);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete all activities and all airports

        get("/activities/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            activityDao.clearAll();
            airportDao.clearAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete all airports

        get("/airports/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            airportDao.clearAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
        //get: show a form to create a new activity

        get("/features/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Feature> features = featureDao.getAll(); //refresh list of links for navbar
            model.put("features", features);
            return new ModelAndView(model, "feature-form.hbs"); //new layout
        }, new HandlebarsTemplateEngine());
        post("/features", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String widthRunWay = req.queryParams("widthRunWay");
            String lengthRunWay = req.queryParams("lengthRunWay");
            String strengthRunWay = req.queryParams("strengthRunWay");
            int airportId = Integer.parseInt(req.queryParams("airportId"));
            Feature  newFeature = new Feature(widthRunWay,lengthRunWay,strengthRunWay,airportId);
            featureDao.add(newFeature);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
        get("/reviews/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Review> reviews = reviewDao.getAll(); //refresh list of links for navbar
            model.put("reviews", reviews);
            return new ModelAndView(model, "review-form.hbs"); //new layout
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new activity

        post("/reviews", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String inspectorName = req.queryParams("inspectorName");
            String inspectorCode = req.queryParams("inspectorCode");
            String competenceArea = req.queryParams("competenceArea");
            String trainingUndertaken = req.queryParams("trainingUndertaken");
            String scheduledTraining = req.queryParams("scheduledTraining");
            int airportId = Integer.parseInt(req.queryParams("airportId"));
            Review  newReview = new Review(inspectorName,inspectorCode,competenceArea,trainingUndertaken,scheduledTraining,airportId);
            reviewDao.add(newReview);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
        get("/activities", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Activity> allActivities = activityDao.getAll();
            model.put("activities", allActivities);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/reviews", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Review> allReviews = reviewDao.getAll();
            model.put("reviews", allReviews);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/features", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Feature> allFeatures = featureDao.getAll();
            model.put("features", allFeatures);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/airports/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("editAirport", true);
            Airport airports = airportDao.findById(1);
            model.put("airports", airports);
            model.put("airports", airportDao.getAll()); //refresh list of links for navbar
            return new ModelAndView(model, "airport-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process a form to update a category

//        post("/activities/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfActivitiesToEdit = Integer.parseInt(req.params("id"));
//            String inspectionDate = req.queryParams("inspectionDate");
//            String inspectionArea = req.queryParams("inspectionArea");
//            String inspectionOutcome = req.queryParams("inspectionOutcome");
//            String serviceAbilityStatus = req.queryParams("serviceAbilityStatus");
//            int airportId = Integer.parseInt(req.queryParams("airportId"));
//            catego.update(idOfCategoryToEdit, newAmount);
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());



//        get("/activities//airpor", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            airportDao.getAll();
//            res.redirect("/");
//            return null;
//        }, new HandlebarsTemplateEngine());
    }
}