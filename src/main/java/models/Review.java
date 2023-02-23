package models;

import java.util.Objects;

public class Review {
    private String inspectorName;
    private String inspectorCode;
    private String competenceArea;
    private String trainingUndertaken;
    private String scheduledTraining;
    private int airportId;
    private int id;


    public Review(String inspectorName, String inspectorCode, String competenceArea, String trainingUndertaken, String scheduledTraining, int airportId) {
        this.inspectorName = inspectorName;
        this.inspectorCode = inspectorCode;
        this.competenceArea = competenceArea;
        this.scheduledTraining = scheduledTraining;
        this.trainingUndertaken = trainingUndertaken;
        this.airportId = airportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return airportId == review.airportId && id == review.id && Objects.equals(inspectorName, review.inspectorName) && Objects.equals(inspectorCode, review.inspectorCode) && Objects.equals(competenceArea, review.competenceArea) && Objects.equals(trainingUndertaken, review.trainingUndertaken) && Objects.equals(scheduledTraining, review.scheduledTraining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inspectorName, inspectorCode, competenceArea, trainingUndertaken, scheduledTraining, airportId, id);
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }
}
