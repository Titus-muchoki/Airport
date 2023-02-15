package models;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        setFormattedCreatedAt(); //we'll make me in a minute
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

    public long getCreatedat() {
        return createdat;
    }

    public void setCreatedat(long createdat) {
        this.createdat = createdat;
    }
    public String getFormattedCreatedAt(){
        Date date = new Date(createdat);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a"; //see https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        return sdf.format(date);
    }
    public void setFormattedCreatedAt(){
        Date date = new Date(createdat);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        this.formattedCreatedAt = sdf.format(date);
        System.out.println(this.formattedCreatedAt);
    }

//    @Override
//    public int compareTo(Feature featureObject) {
//        if (this.createdat < featureObject.createdat)
//        {
//            return -1; //this object was made earlier than the second object.
//        }
//        else if (this.createdat > featureObject.createdat){ //this object was made later than the second object
//            return 1;
//        }
//        else {
//            return 0; //they were made at the same time, which is very unlikely, but mathematically not impossible.
//        }
//    }
}
