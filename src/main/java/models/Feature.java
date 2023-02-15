package models;

import java.util.Objects;

public class Feature {
    private String widthRunWay;
    private String lengthRunWay;
    private String strengthRunWay;

    private int id;
    private int airportId;

    private long createdat;
    private String formattedCreatedAt;

    public Feature(String widthRunWay, String lengthRunWay, String strengthRunWay, int airportId) {
        this.widthRunWay = widthRunWay;
        this.lengthRunWay = lengthRunWay;
        this.strengthRunWay = strengthRunWay;
        this.airportId = airportId;
        this.createdat = System.currentTimeMillis();
//        setFormattedCreatedAt(); //we'll make me in a minute
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feature)) return false;
        Feature feature = (Feature) o;
        return id == feature.id && airportId == feature.airportId && createdat == feature.createdat && Objects.equals(widthRunWay, feature.widthRunWay) && Objects.equals(lengthRunWay, feature.lengthRunWay) && Objects.equals(strengthRunWay, feature.strengthRunWay) && Objects.equals(formattedCreatedAt, feature.formattedCreatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthRunWay, lengthRunWay, strengthRunWay, id, airportId, createdat, formattedCreatedAt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
