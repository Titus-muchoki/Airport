package models;

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
        setFormattedCreatedAt(); //we'll make me in a minute
    }
}
