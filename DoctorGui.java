import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DoctorGui {
    String fName;
    String lName;
    String dobValue;
    String docID;
    String phone;
    String contact;
    String addr;
    String ssnValue;
    String depCode;


    public DoctorGui() {
        openDoctorWindow();
    }

    public void openDoctorWindow() {
        JFrame docFrame = new JFrame("Doctor Management");
        docFrame.setSize(700, 550);
        docFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        docFrame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        docFrame.add(panel);

        JLabel label = new JLabel("Doctor Management Window");
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
        
        JLabel middleName = new JLabel("Midlle Name:");
        middleName.setBounds(xLabel, y, widthLabel, height);
        panel.add(middleName);

        JTextField middleNameText = new JTextField(20);
        middleNameText.setBounds(xField, y, widthField, height);
        panel.add(middleNameText);
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

        JLabel doctorID = new JLabel("Doctor ID:");
        doctorID.setBounds(xLabel, y, widthLabel, height);
        panel.add(doctorID);

        JTextField doctorIDText = new JTextField(10);
        doctorIDText.setBounds(xField, y, widthField, height);
        panel.add(doctorIDText);
        y += gap;

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(phoneLabel);

        JTextField phoneText = new JTextField(15);
        phoneText.setBounds(xField, y, widthField, height);
        panel.add(phoneText);
        y += gap;

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(contactLabel);

        JTextField contactText = new JTextField(15);
        contactText.setBounds(xField, y, widthField, height);
        panel.add(contactText);
        y += gap;

        JLabel address = new JLabel("Address:");
        address.setBounds(xLabel, y, widthLabel, height);
        panel.add(address);

        JTextField addressText = new JTextField(150);
        addressText.setBounds(xField, y, 350, height);
        panel.add(addressText);
        y += gap;

        JLabel ssn = new JLabel("SSN:");
        ssn.setBounds(xLabel, y, widthLabel, height);
        panel.add(ssn);

        JTextField ssnText = new JTextField(11);
        ssnText.setBounds(xField, y, widthField, height);
        panel.add(ssnText);
        y += gap;

        JLabel depLabel = new JLabel("Department Code:");
        depLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(depLabel);

        JTextField depText = new JTextField(15);
        depText.setBounds(xField, y, widthField, height);
        panel.add(depText);
        y += gap;
        JButton submit = new JButton("Submit");
        submit.setBounds(180, y, 100, 30);
        panel.add(submit);
        y += gap;
        submit.addActionListener(e -> {
            Doctor doctor = new Doctor( doctorIDText.getText(),   
                                        ssnText.getText(),        
                                        firstNameText.getText(), 
                                        middleNameText.getText(), 
                                        lastNameText.getText(),   
                                        phoneText.getText(),      
                                        addressText.getText(),    
                                        contactText.getText(),    
                                        dateField.getText(),    
                                        depText.getText());
            HospitalGui.addDoctor(doctor);
            doctorIDText.setText("");
            ssnText.setText("");
            firstNameText.setText("");
            middleNameText.setText("");
            lastNameText.setText("");
            phoneText.setText("");
            addressText.setText("");
            contactText.setText("");
            dateField.setText("");
            depText.setText("");
        
        });

        JButton back = new JButton("Back");
        back.setBounds(400, y, 150, 30);
        back.addActionListener(e -> {
            docFrame.dispose();
            new HospitalGui(); 
        });
        panel.add(back);

        docFrame.setVisible(true);
    }

    
    
}
