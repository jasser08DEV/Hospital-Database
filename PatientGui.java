import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PatientGui {
    

    public PatientGui() {
        openPatientWindow();
    }
    public void openPatientWindow() {
    JFrame patientFrame = new JFrame("Patient Management");
    patientFrame.setSize(900, 700);
    patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    patientFrame.setLocationRelativeTo(null);
    JPanel panel = new JPanel();
    panel.setLayout(null);
    patientFrame.add(panel);

    JLabel label = new JLabel("Patient Management Window");
    label.setBounds(240, 10, 250, 25);
    panel.add(label);

    int xLabel = 30;
    int xField = 180;
    int widthLabel = 150;
    int widthField = 200;
    int height = 25;
    int y = 50;   
    int gap = 35; 

    JLabel firstName = new JLabel("First Name:");
    firstName.setBounds(xLabel, y, widthLabel, height);
    panel.add(firstName);

    JTextField firstNameText = new JTextField(20);
    firstNameText.setBounds(xField, y, widthField, height);
    panel.add(firstNameText);
    y += gap;
    JLabel midName = new JLabel("Middle Name:");
    midName.setBounds(xLabel, y, widthLabel, height);
    panel.add(midName);

    JTextField midNameText = new JTextField(20);
    midNameText.setBounds(xField, y, widthField, height);
    panel.add(midNameText);
    y += gap;

    JLabel lastName = new JLabel("Last Name:");
    lastName.setBounds(xLabel, y, widthLabel, height);
    panel.add(lastName);

    JTextField lastNameText = new JTextField(20);
    lastNameText.setBounds(xField, y, widthField, height);
    panel.add(lastNameText);
    y += gap;

    JLabel dob = new JLabel("Date of Birth:");
    dob.setBounds(xLabel, y, widthLabel, height);
    panel.add(dob);

    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
    JFormattedTextField dateField = new JFormattedTextField(format);
    dateField.setBounds(xField, y, widthField, height);
    dateField.setToolTipText("MM-DD-YYYY");
    panel.add(dateField);
    y += gap;

    JLabel patientID = new JLabel("Patient ID:");
    patientID.setBounds(xLabel, y, widthLabel, height);
    panel.add(patientID);

    JTextField patientIDText = new JTextField(10);
    patientIDText.setBounds(xField, y, widthField, height);
    panel.add(patientIDText);
    y += gap;

    JLabel sex = new JLabel("Sex:");
    sex.setBounds(xLabel, y, widthLabel, height);
    panel.add(sex);

    JRadioButton male = new JRadioButton("Male");
    male.setBounds(xField, y, 70, height);
    panel.add(male);

    JRadioButton female = new JRadioButton("Female");
    female.setBounds(xField + 80, y, 80, height);
    panel.add(female);

    JRadioButton other = new JRadioButton("Other");
    other.setBounds(xField + 170, y, 80, height);
    panel.add(other);

    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);
    genderGroup.add(other);
    y += gap;

    JLabel phone = new JLabel("Phone Number:");
    phone.setBounds(xLabel, y, widthLabel, height);
    panel.add(phone);

    JTextField currentPhoneText = new JTextField(15);
    currentPhoneText.setBounds(xField, y, widthField, height);
    panel.add(currentPhoneText);
    y += gap;

    JLabel permPhoneLabel = new JLabel("Permanent Phone:");
    permPhoneLabel.setBounds(xLabel, y, widthLabel, height);
    panel.add(permPhoneLabel);

    JTextField permPhoneText = new JTextField(15);
    permPhoneText.setBounds(xField, y, widthField, height);
    panel.add(permPhoneText);
    y += gap;

    JLabel currentAddress = new JLabel("Current Address:");
    currentAddress.setBounds(xLabel, y, widthLabel, height);
    panel.add(currentAddress);

    JTextField currentAddressText = new JTextField(150);
    currentAddressText.setBounds(xField, y, 350, height);
    panel.add(currentAddressText);
    y += gap;

    JLabel permanentAddress = new JLabel("Permanent Address:");
    permanentAddress.setBounds(xLabel, y, widthLabel, height);
    panel.add(permanentAddress);

    JTextField permanentAddressText = new JTextField(150);
    permanentAddressText.setBounds(xField, y, 350, height);
    panel.add(permanentAddressText);
    y += gap;

    JLabel ssn = new JLabel("SSN:");
    ssn.setBounds(xLabel, y, widthLabel, height);
    panel.add(ssn);

    JTextField ssnText = new JTextField(11);
    ssnText.setBounds(xField, y, widthField, height);
    panel.add(ssnText);

    y += gap;

    JLabel primaryDoctor = new JLabel("Primary Doctor:");
    primaryDoctor.setBounds(xLabel, y, widthLabel, height);
    panel.add(primaryDoctor);
    JTextField primaryDoctorText = new JTextField(10);
    primaryDoctorText.setBounds(xField, y, widthField, height);
    panel.add(primaryDoctorText);

    y += gap;
    JLabel secondaryDoctor = new JLabel("Secondary Doctor ID:");
    secondaryDoctor.setBounds(xLabel, y , widthLabel, height);
    panel.add(secondaryDoctor);
    JTextField secondaryDoctorText = new JTextField(10);
    secondaryDoctorText.setBounds(xField, y , widthField, height);
    panel.add(secondaryDoctorText);
    y += gap;
    JLabel conditionLabel = new JLabel("Condition:");
    conditionLabel.setBounds(xLabel, y , widthLabel, height);
    panel.add(conditionLabel);
    JComboBox<String> conditionComboBox = new JComboBox<>(new String[] {
        "Stable", "Critical", "Recovering", "Under Observation"
    });
    conditionComboBox.setBounds(xField, y , widthField, height);
    panel.add(conditionComboBox);
    y += gap;
    JButton submit = new JButton("Submit");
    submit.setBounds(180, y, 100, 30);
    panel.add(submit);
    y += gap;

    JButton back = new JButton("Back");
    back.setBounds(400, y,150, 30);
    back.addActionListener(e -> {
        patientFrame.dispose();
        new HospitalGui(); 
    });
    panel.add(back);

    submit.addActionListener(e -> {
         String genderValue = "";
        if (male.isSelected()) genderValue = "Male";
        else if (female.isSelected()) genderValue = "Female";
        else if (other.isSelected()) genderValue = "Other";
        try{
            Patient patient = new Patient(
            patientIDText.getText(),
            firstNameText.getText(),
            midNameText.getText(),
            lastNameText.getText(),
            genderValue,
            dateField.getText(),
            ssnText.getText(),
            currentAddressText.getText(),
            permanentAddressText.getText(),
            currentPhoneText.getText(),
             permPhoneText.getText(),
            (String) conditionComboBox.getSelectedItem(),  
            primaryDoctorText.getText(),                 
            secondaryDoctorText.getText()
            );
        
            HospitalGui.addPatient(patient);

            patientIDText.setText("");
            firstNameText.setText("");
            midNameText.setText("");
            lastNameText.setText("");
            dateField.setText("");
            ssnText.setText("");
            currentAddressText.setText("");
            permanentAddressText.setText("");
            currentPhoneText.setText("");
            permPhoneText.setText("");
            primaryDoctorText.setText("");
            secondaryDoctorText.setText("");
    
            genderGroup.clearSelection();
            conditionComboBox.setSelectedIndex(0);
                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(patientFrame, "Error: " + ex.getMessage());
        }

        }
    );
    
    
    patientFrame.setVisible(true);
    }

    
    
}
