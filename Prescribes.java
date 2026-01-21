public class Prescribes {
    private String doctorId;
    private String patientId;
    private String prescriptionName;
    private String prescriptionDate;

    public Prescribes(String doctorId, String patientId, String prescriptionName, String prescriptionDate) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.prescriptionName = prescriptionName;
        this.prescriptionDate = prescriptionDate;
    }

    public String getDoctorId() { return doctorId; }
    public String getPatientId() { return patientId; }
    public String getPrescriptionName() { return prescriptionName; }
    public String getPrescriptionDate() { return prescriptionDate; }
}