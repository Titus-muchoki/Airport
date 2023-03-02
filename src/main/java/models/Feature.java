package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Feature {

    private String widthRunWay;
    private String lengthRunWay;
    private String strengthRunWay;
    private int airportId;


    private int id;

    public Feature(String widthRunWay, String lengthRunWay, String strengthRunWay, int airportId) {
        this.widthRunWay = widthRunWay;
        this.lengthRunWay = lengthRunWay;
        this.strengthRunWay = strengthRunWay;
        this.airportId = airportId;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return airportId == feature.airportId && id == feature.id && Objects.equals(widthRunWay, feature.widthRunWay) && Objects.equals(lengthRunWay, feature.lengthRunWay) && Objects.equals(strengthRunWay, feature.strengthRunWay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthRunWay, lengthRunWay, strengthRunWay, airportId, id);
    }

    public String getWidthRunWay() {
        return widthRunWay;
    }

    public void setWidthRunWay(String widthRunWay) {
        this.widthRunWay = widthRunWay;
    }

    public String getLengthRunWay() {
        return lengthRunWay;
    }

    public void setLengthRunWay(String lengthRunWay) {
        this.lengthRunWay = lengthRunWay;
    }

    public String getStrengthRunWay() {
        return strengthRunWay;
    }

    public void setStrengthRunWay(String strengthRunWay) {
        this.strengthRunWay = strengthRunWay;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
