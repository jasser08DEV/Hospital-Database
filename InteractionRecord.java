public class InteractionRecord {
    private String patientId;  
    private String interactionId;  
    private String date;
    private String time;
    private String description;

    public InteractionRecord(String patientId, String interactionId, String date, 
                           String time, String description) {
        this.patientId = patientId;
        this.interactionId = interactionId;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    // Getters
    public String getPatientId() {
        return patientId;
    }

    public String getInteractionId() {
        return interactionId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                ", Interaction #" + interactionId +
                ", Date: " + date +
                ", Time: " + time +
                ", Description: " + description;
    }
}