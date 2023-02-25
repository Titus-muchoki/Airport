package models;

import java.util.Objects;

public class Activities {
    private String inspectionDate;
    private String inspectionArea;
    private String inspectionOutcome;
    private String serviceAbilityStatus;
    private int id;
    private int airportId;

    public Activities(String inspectionDate, String inspectionArea, String inspectionOutcome, String serviceAbilityStatus, int airportId) {
        this.inspectionDate = inspectionDate;
        this.inspectionArea = inspectionArea;
        this.inspectionOutcome = inspectionOutcome;
        this.serviceAbilityStatus = serviceAbilityStatus;
        this.airportId = airportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activities)) return false;
        Activities that = (Activities) o;
        return id == that.id && airportId == that.airportId && Objects.equals(inspectionDate, that.inspectionDate) && Objects.equals(inspectionArea, that.inspectionArea) && Objects.equals(inspectionOutcome, that.inspectionOutcome) && Objects.equals(serviceAbilityStatus, that.serviceAbilityStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inspectionDate, inspectionArea, inspectionOutcome, serviceAbilityStatus, id, airportId);
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspectionArea() {
        return inspectionArea;
    }

    public void setInspectionArea(String inspectionArea) {
        this.inspectionArea = inspectionArea;
    }

    public String getInspectionOutcome() {
        return inspectionOutcome;
    }

    public void setInspectionOutcome(String inspectionOutcome) {
        this.inspectionOutcome = inspectionOutcome;
    }

    public String getServiceAbilityStatus() {
        return serviceAbilityStatus;
    }

    public void setServiceAbilityStatus(String serviceAbilityStatus) {
        this.serviceAbilityStatus = serviceAbilityStatus;
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
