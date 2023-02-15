package models;

import java.util.Objects;

public class Airport {
    private String name;
    private String code;
    private String city;
    private String distance;
    private String id;

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
        return Objects.equals(name, airport.name) && Objects.equals(code, airport.code) && Objects.equals(city, airport.city) && Objects.equals(distance, airport.distance) && Objects.equals(id, airport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, city, distance, id);
    }

}
