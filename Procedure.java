public class Procedure {

    private String procedureNumber;
    private String name;
    private String description;
    private int durationMinutes;
    private String offeringDepartment;

    // Constructor
    public Procedure(String procedureNumber, String name, String description, int durationMinutes, String offeringDepartment) {
        this.procedureNumber = procedureNumber;
        this.name = name;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.offeringDepartment = offeringDepartment;
    }

    // Getters
    public String getProcedureNumber() {
        return procedureNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getOfferingDepartment() {
        return offeringDepartment;
    }

    // Setters
    public void setProcedureNumber(String procedureNumber) {
        this.procedureNumber = procedureNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setOfferingDepartment(String offeringDepartment) {
        this.offeringDepartment = offeringDepartment;
    }

    @Override
    public String toString() {
        return "ProcedureNumber: " + procedureNumber +
                ", Name: " + name +
                ", Duration: " + durationMinutes +
                ", Department: " + offeringDepartment;
    }
}
