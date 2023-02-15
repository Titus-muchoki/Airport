package dao;

import models.Airport;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAirportDao implements AirportDao{

    private final Sql2o sql2o;
    public Sql2oAirportDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void add(Airport airport) {
        String sql = "INSERT INTO airports (name, code, city, distance) VALUES (:name, :code, :city, :distance)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(airport)
                    .executeUpdate()
                    .getKey();
            airport.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Airport> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM airports")
                    .executeAndFetch(Airport.class);
        }
    }

    @Override
    public Airport findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM airports WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Airport.class);
        }
    }

    @Override
    public void update(int id, String newName, String newCode, String newCity, String newDistance) {
        String sql = "UPDATE airports SET (name, code, city, distance) = (:name, :code, :city, :distance) WHERE id=:id"; //CHECK!!!
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("code", newCode)
                    .addParameter("city", newCity)
                    .addParameter("distance", newDistance)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from airports WHERE id = :id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from airports";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
