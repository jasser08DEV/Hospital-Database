public class Doctor {
    
    String id;
    String ssn;

    String firstName;
    String middleName;
    String lastName;

    String phoneNumber;
    String address;
    String contactNumber;

    String birthday; 
    String departmentCode;

    public Doctor(String id, String ssn, String firstName,String middleName, String lastName, String phoneNumber, String address, String contactNumber, String birthday, String departmentCode) {

        this.id = id;
        this.ssn = ssn;
        this.firstName = firstName;
        this.middleName= middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.contactNumber = contactNumber;
        this.birthday = birthday;
        this.departmentCode = departmentCode;
    }
}

