import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HospitalGui {

    public static void main(String[] args) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String serverName = "cisvm-oracle.unfcsd.unf.edu";
        String portNumber = "1521";
        String sid = "orcl";
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "G02";
        String password = "ChanceKennyJasser";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            boolean reachable = conn.isValid(10); // 10 sec
            if (reachable) {
                System.out.println("Success");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new HospitalGui();

    }
    public HospitalGui() {

        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        JLabel welcome = new JLabel("Welcome to the Hospital Management System");
        welcome.setBounds(200, 10, 300, 25);
        panel.add(welcome);
        JButton patient = new JButton("Patient");
        patient.setBounds(150, 50, 150, 25);
        JButton doctor = new JButton("Doctor");
        doctor.setBounds(350, 50, 150, 25);
        JButton department = new JButton("Department");
        department.setBounds(150, 100, 150, 25);
        JButton procedure = new JButton("Procedure");
        procedure.setBounds(350, 100, 150, 25);
        JButton medication = new JButton("Medication");
        medication.setBounds(150, 150, 150, 25);
        JButton interactionRecord = new JButton("Interaction Record");
        interactionRecord.setBounds(350, 150, 150, 25);
        JButton assignProcedure = new JButton("Assign Procedure");
        assignProcedure.setBounds(150, 200, 150, 25);
        JButton assignMedication = new JButton("Assign Medication");
        assignMedication.setBounds(350, 200, 150, 25);

        
        JButton btnRecord = new JButton("Health Record");
        btnRecord.setBounds(150, 250, 150, 25); 
        JButton btnProcSearch = new JButton("Search Procedures");
        btnProcSearch.setBounds(350, 250, 150, 25); 
        panel.add(btnProcSearch);

        
        
        
        panel.add(patient);
        panel.add(doctor);
        panel.add(department);
        panel.add(procedure);
        panel.add(medication);
        panel.add(interactionRecord);
        panel.add(assignProcedure);
        panel.add(assignMedication);
        panel.add(btnRecord);

        patient.addActionListener(e -> {
            frame.dispose();
             new PatientGui();

        });
        doctor.addActionListener(e -> {
            frame.dispose();
            new DoctorGui();

        });
        department.addActionListener(e -> {
            frame.dispose();
            new DepartmentGui();
        });
        procedure.addActionListener(e -> {
            frame.dispose();
            new ProcedureGui();
        });
        medication.addActionListener(e -> {
            frame.dispose();
            new MedicationGui();
        });
        interactionRecord.addActionListener(e -> {
            frame.dispose();
            new InteractionRecordGui();
        });
        assignProcedure.addActionListener(e ->{
            frame.dispose();
            new AssignProcedureGui();
        });
        assignMedication.addActionListener(e ->{
            frame.dispose();
            new AssignPrescribesGui();
        });
        btnRecord.addActionListener(e -> {
             frame.dispose();
            new HealthRecordGui();
        });
        btnProcSearch.addActionListener(e -> {
                frame.dispose();
                new ProcedureByDeptGui();
        });
        JButton btnDocSearch = new JButton("Search Doc Procedures");
        btnDocSearch.setBounds(150 , 300, 180, 25); // Adjust Y position as needed
        panel.add(btnDocSearch);

        btnDocSearch.addActionListener(e -> {
            frame.dispose();
            new ProcedureByDocGui();
        });

    }
    public static void addDoctor(Doctor doctor) {
    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    String username = "G02";
    String password = "ChanceKennyJasser";

    String sql = "INSERT INTO Doctor " 
               + "(ID, SSN, FirstName, MiddleName, LastName, PhoneNumber, Address, ContactNumber, Birthday, DepartmentCode) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, doctor.id);
        ps.setString(2, doctor.ssn);
        ps.setString(3, doctor.firstName);
        ps.setString(4, doctor.middleName);
        ps.setString(5, doctor.lastName);
        ps.setString(6, doctor.phoneNumber);
        ps.setString(7, doctor.address);
        ps.setString(8, doctor.contactNumber);

        
        java.sql.Date birthdaySQL = new java.sql.Date(
            new java.text.SimpleDateFormat("MM-dd-yyyy").parse(doctor.birthday).getTime()
        );
        ps.setDate(9, birthdaySQL);

        
        ps.setString(10, doctor.departmentCode);

        ps.executeUpdate();
        System.out.println("Doctor inserted successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

        public static void addPatient(Patient p) {

            String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
            String username = "G02";
            String password = "ChanceKennyJasser";

            String sql = "INSERT INTO Patient "
                + "(ID, FirstName, MiddleName, LastName, Sex, Birthday, SSN, "
                + "CurrentAddress, PermanentAddress, CurrentPhoneNumber, PermanentPhoneNumber, "
                + "ConditionDescription, PrimaryCareDoctor, SecondCareDoctor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, p.id);
                ps.setString(2, p.firstName);
                ps.setString(3, p.midName);  
                ps.setString(4, p.lastName);
                ps.setString(5, p.sex);


            java.sql.Date birthdaySQL = new java.sql.Date(new java.text.SimpleDateFormat("MM-dd-yyyy").parse(p.birthday).getTime());

            ps.setDate(6, birthdaySQL);

            ps.setString(7, p.ssn);
            ps.setString(8, p.currentAddress);
            ps.setString(9, p.permanentAddress);
            ps.setString(10, p.currentPhoneNumber);
            ps.setString(11, p.permanentPhoneNumber);
            ps.setString(12, p.conditionDescription);
            ps.setString(13, p.primaryCareDoctor);
            ps.setString(14, p.secondCareDoctor);

            ps.executeUpdate();
            System.out.println("Patient inserted successfully!");

        } catch (Exception e) {
             e.printStackTrace();
        }
    }
    public static void addDepartment(Department d) {
			String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
            String username = "G02";
            String password = "ChanceKennyJasser";

            String sql = "INSERT INTO Department "+"(Code, Name, OfficeNumber, OfficePhone, Head) " + "VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement ps = conn.prepareStatement(sql)) {

                    ps.setString(1, d.code);
                    ps.setString(2, d.name);
                    ps.setString(3, d.officeNumber);
                    ps.setString(4, d.officePhone);
                    ps.setString(5, d.head);

                    ps.executeUpdate();
                    System.out.println("Department inserted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
    public static  void addProcedure(Procedure p) {
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "G02";
        String password = "ChanceKennyJasser";
        String sql = "INSERT INTO MedicalProcedure "+"(ProcedureNumber, Name, Description, DurationMinutes, OfferingDepartment) " + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,p.getProcedureNumber());
            ps.setString(2,p.getName());
            ps.setString(3,p.getDescription());
            ps.setInt(4,p.getDurationMinutes());
            ps.setString(5,p.getOfferingDepartment());

            ps.executeUpdate();
            System.out.println("Procedure inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMedication(Medication m) {
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "G02";
        String password = "ChanceKennyJasser";

        String sql = "INSERT INTO Prescription (Name, Manufacturer, Description) " +
                "VALUES ( ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setString(1, m.getName());
            ps.setString(2, m.getManufacturer());
            ps.setString(3, m.getDescription());

            ps.executeUpdate();
            System.out.println("Prescription/Medication inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addInteractionRecord(InteractionRecord ir) {
    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    String username = "G02";
    String password = "ChanceKennyJasser";
    
    String sql = "INSERT INTO InteractionRecord (PatientID, ID, INTERACTIONDATE, INTERACTIONTIME, Description) " +
                 "VALUES (?, ?, ?, ?, ?)";
    
    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, ir.getPatientId()); 
        ps.setInt(2, Integer.parseInt(ir.getInteractionId()));  
        
        
        java.sql.Date dateSQL = 
            new java.sql.Date(
                new java.text.SimpleDateFormat("MM-dd-yyyy").parse(ir.getDate()).getTime()
            );
        ps.setDate(3, dateSQL);
        
        
        java.sql.Time timeSQL = java.sql.Time.valueOf(ir.getTime());
        ps.setTime(4, timeSQL);
        
        ps.setString(5, ir.getDescription());
        
        ps.executeUpdate();
        System.out.println("Interaction Record inserted successfully!");
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public static void assignProcedureToPatient(PatientProcedureRecord record) {
    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    String username = "G02";
    String password = "ChanceKennyJasser";

    
    String sql = "INSERT INTO Patient_Procedure_Record " +
                 "(PatientID, ProcedureCode, DatePerformed, DoctorID, \"TIME\", Notes) " +
                 "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, record.getPatientId());
        ps.setString(2, record.getProcedureCode());

      
        java.sql.Date sqlDate = new java.sql.Date(
            new java.text.SimpleDateFormat("MM-dd-yyyy")
            .parse(record.getDatePerformed()).getTime()
        );
        ps.setDate(3, sqlDate);

        ps.setString(4, record.getDoctorId());
        
        
        java.sql.Time timeSQL = java.sql.Time.valueOf(record.getTime());
        ps.setTime(5, timeSQL);
        
        ps.setString(6, record.getNotes());

        ps.executeUpdate();
        System.out.println("Procedure successfully recorded for patient!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public static void addPrescribes(Prescribes p) {
    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    String username = "G02";
    String password = "ChanceKennyJasser";

    String sql = "INSERT INTO PRESCRIBES (DOCTORID, PATIENTID, PRESCRIPTIONNAME, PRESCRIPTIONDATE) " +
                 "VALUES (?, ?, ?, ?)";

    try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, username, password);
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, p.getDoctorId());
        ps.setString(2, p.getPatientId());
        ps.setString(3, p.getPrescriptionName());

        java.sql.Date sqlDate = new java.sql.Date(
            new java.text.SimpleDateFormat("MM-dd-yyyy")
            .parse(p.getPrescriptionDate()).getTime()
        );
        ps.setDate(4, sqlDate);

        ps.executeUpdate();
        System.out.println("Prescribes inserted successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public static String getProceduresByDept(String input) {
    StringBuilder sb = new StringBuilder();
    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    String username = "G02";
    String password = "ChanceKennyJasser";

    // This query joins the tables so you can search by Name OR Code
    // We use UPPER() to make the search case-insensitive
    String sql = "SELECT mp.Name, mp.ProcedureNumber, mp.Description, mp.DurationMinutes " +
                 "FROM MedicalProcedure mp " +
                 "JOIN Department d ON mp.OfferingDepartment = d.Code " +
                 "WHERE UPPER(d.Name) = UPPER(?) OR UPPER(d.Code) = UPPER(?)";

    try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, username, password);
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, input);
        ps.setString(2, input);

        java.sql.ResultSet rs = ps.executeQuery();
        
        boolean found = false;
        sb.append("--- Search Results for: ").append(input).append(" ---\n\n");
        
        while (rs.next()) {
            found = true;
            sb.append("Procedure Name: ").append(rs.getString("Name")).append("\n");
            sb.append("Code: ").append(rs.getString("ProcedureNumber")).append("\n");
            sb.append("Duration: ").append(rs.getInt("DurationMinutes")).append(" mins\n");
            sb.append("Description: ").append(rs.getString("Description")).append("\n");
            sb.append("--------------------------------------------------\n");
        }

        if (!found) {
            sb.append("No procedures found for this department.");
        }

    } catch (Exception e) {
        return "Database Error: " + e.getMessage();
    }
    return sb.toString();
}
public static String getProceduresByDoc(String input) {
    StringBuilder sb = new StringBuilder();
    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
    String username = "G02";
    String password = "ChanceKennyJasser";

    String sql = "SELECT mp.Name, mp.ProcedureNumber, mp.Description, mp.DurationMinutes " +
                 "FROM MedicalProcedure mp " +
                 "JOIN Patient_Procedure_Record r ON mp.ProcedureNumber = r.ProcedureCode " +
                 "WHERE UPPER(r.DoctorID) = UPPER(?)"; // Only ONE question mark here

    try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, username, password);
         java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

        
        ps.setString(1, input); 

        java.sql.ResultSet rs = ps.executeQuery();
        
        boolean found = false;
        sb.append("--- Search Results for Doctor ID: ").append(input).append(" ---\n\n");
        
        while (rs.next()) {
            found = true;
            sb.append("Procedure Name: ").append(rs.getString("Name")).append("\n");
            sb.append("Code: ").append(rs.getString("ProcedureNumber")).append("\n");
            sb.append("Duration: ").append(rs.getInt("DurationMinutes")).append(" mins\n");
            sb.append("Description: ").append(rs.getString("Description")).append("\n");
            sb.append("--------------------------------------------------\n");
        }

        if (!found) {
            sb.append("No procedures found for this DOCTOR ID.");
        }

    } catch (Exception e) {
        return "Database Error: " + e.getMessage();
    }
    return sb.toString();
}
public static String generateFullReport(String patientID) {
        StringBuilder sb = new StringBuilder();
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        String username = "G02";
        String password = "ChanceKennyJasser";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            
            String sqlPatient = 
                "SELECT FirstName, LastName, Sex, Birthday, CurrentAddress, CurrentPhoneNumber " +
                "FROM Patient WHERE ID = ?";

            try (PreparedStatement ps = conn.prepareStatement(sqlPatient)) {
                ps.setString(1, patientID);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    sb.append("=========================================\n");
                    sb.append("       PATIENT HEALTH RECORD\n");
                    sb.append("=========================================\n\n");
                    
                    sb.append("PATIENT DETAILS:\n");
                    sb.append("ID:      ").append(patientID).append("\n");
                    sb.append("Name:    ").append(rs.getString("FirstName")).append(" ").append(rs.getString("LastName")).append("\n");
                    sb.append("Sex:     ").append(rs.getString("Sex")).append("\n");
                    sb.append("DOB:     ").append(rs.getDate("Birthday")).append("\n");
                    sb.append("Address: ").append(rs.getString("CurrentAddress")).append("\n");
                    sb.append("Phone:   ").append(rs.getString("CurrentPhoneNumber")).append("\n");
                    sb.append("\n-----------------------------------------\n");
                } else {
                    return "Error: Patient ID '" + patientID + "' not found.";
                }
            }

         
            sb.append("(A) PROCEDURES PERFORMED:\n");
            
            
            String sqlProc = 
                "SELECT mp.Name, ppr.DatePerformed, ppr.\"TIME\", ppr.DoctorID, ppr.Notes " +
                "FROM Patient_Procedure_Record ppr " +
                "JOIN MedicalProcedure mp ON ppr.ProcedureCode = mp.ProcedureNumber " +
                "WHERE ppr.PatientID = ?";

            try (PreparedStatement ps = conn.prepareStatement(sqlProc)) {
                ps.setString(1, patientID);
                ResultSet rs = ps.executeQuery();

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    sb.append(" - Procedure: ").append(rs.getString("Name")).append("\n");
                    sb.append("   Date:      ").append(rs.getDate("DatePerformed"));
                    // Handle time potentially being null
                    Time t = rs.getTime("TIME");
                    if(t != null) sb.append(" at ").append(t);
                    sb.append("\n");
                    sb.append("   Doctor ID: ").append(rs.getString("DoctorID")).append("\n");
                    sb.append("   Notes:     ").append(rs.getString("Notes")).append("\n");
                    sb.append("   ---\n");
                }
                if (!found) sb.append("   No procedures recorded.\n");
            }
            sb.append("-----------------------------------------\n");

            
            sb.append("(B) HOSPITAL INTERACTIONS:\n");
            
            String sqlInter = "SELECT INTERACTIONDATE, INTERACTIONTIME, Description FROM InteractionRecord WHERE PatientID = ?";

            try (PreparedStatement ps = conn.prepareStatement(sqlInter)) {
                    ps.setString(1, patientID);
                    ResultSet rs = ps.executeQuery();

                    boolean found = false;
                    while (rs.next()) {
                        found = true;
                        // Make sure to match the getters to the new query columns
                        sb.append(" - Date:    ").append(rs.getDate("INTERACTIONDATE")).append("\n");
                        sb.append("   Time:    ").append(rs.getTime("INTERACTIONTIME")).append("\n");
                        sb.append("   Details: ").append(rs.getString("Description")).append("\n");
                        sb.append("   ---\n");
                    }
                    if (!found) sb.append("   No interactions recorded.\n");
            }
            sb.append("-----------------------------------------\n");

           
            sb.append("(C) MEDICATIONS PRESCRIBED:\n");
            
            
            String sqlMeds = "SELECT PrescriptionName, PrescriptionDate, DoctorID FROM PRESCRIBES WHERE PatientID = ?";

            try (PreparedStatement ps = conn.prepareStatement(sqlMeds)) {
                ps.setString(1, patientID);
                ResultSet rs = ps.executeQuery();

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    sb.append(" - Drug:   ").append(rs.getString("PrescriptionName")).append("\n");
                    sb.append("   Date:   ").append(rs.getDate("PrescriptionDate")).append("\n");
                    sb.append("   Doc ID: ").append(rs.getString("DoctorID")).append("\n");
                    sb.append("   ---\n");
                }
                if (!found) sb.append("   No medications prescribed.\n");
            }
            sb.append("=========================================\n");
            sb.append("END OF RECORD");

        } catch (SQLException e) {
            return "Database Error: " + e.getMessage();
        }

        return sb.toString();
    }
}

