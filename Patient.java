import java.util.ArrayList;

public class Patient {
    String id;
    String firstName;
    String midName;
    String lastName;

    String sex;
    String birthday; 
    String ssn;

    String currentAddress;
    String permanentAddress;

    String currentPhoneNumber;
    String permanentPhoneNumber;

    String conditionDescription;

    String primaryCareDoctor;
    String secondCareDoctor;
    ArrayList<Procedure> procedures =  new ArrayList<>();
    public Patient(String id, String firstName, String midName ,String lastName, String sex, String birthday, String ssn, String currentAddress,String permanentAddres,String currentPhoneNumber,
                    String permanentPhoneNumber,String conditionDescription, String primaryCareDoctor, String secondCareDoctor){
                        this.id = id;
                        this.firstName = firstName;
                        this.midName = midName;
                        this.lastName = lastName;
                        this.sex = sex;
                        this.birthday= birthday;
                        this.ssn = ssn;
                        this.currentAddress = currentAddress;
                        this.permanentAddress = permanentAddres;
                        this.currentPhoneNumber = currentPhoneNumber;
                        this.permanentPhoneNumber = permanentPhoneNumber;
                        this.conditionDescription = conditionDescription;
                        this.primaryCareDoctor = primaryCareDoctor;
                        this.secondCareDoctor = secondCareDoctor;
    }
}
