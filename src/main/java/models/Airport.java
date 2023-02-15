package models;

import java.util.Objects;

public class Airport {
    private String name;
    private String code;
    private String city;
    private String distance;
    private int id;

    public Airport(String name, String code, String city, String distance) {
        this.name = name;
        this.code = code;
        this.city = city;
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return id == airport.id && Objects.equals(name, airport.name) && Objects.equals(code, airport.code) && Objects.equals(city, airport.city) && Objects.equals(distance, airport.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, city, distance, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
