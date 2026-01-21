public class PatientProcedureRecord {
    private String patientId;
    private String procedureCode; 
    private String datePerformed;
    private String doctorId;
    private String time;
    
    private String notes;

    public PatientProcedureRecord(String patientId, String procedureCode, String datePerformed, 
                                  String doctorId, String time,String notes) {
        this.patientId = patientId;
        this.procedureCode = procedureCode;
        this.datePerformed = datePerformed;
        this.doctorId = doctorId;
        this.time = time;
        this.notes = notes;
    }

    // Getters
    public String getPatientId() { return patientId; }
    public String getProcedureCode() { return procedureCode; }
    public String getDatePerformed() { return datePerformed; }
    public String getDoctorId() { return doctorId; }
    public String getTime(){ return time;}
    public String getNotes() { return notes; }
}