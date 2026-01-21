import java.awt.event.*;
import javax.swing.*;

public class AssignPrescribesGui {

    public AssignPrescribesGui() {
        openAssignPrescribesGui();
    }

    private void openAssignPrescribesGui() {
        JFrame frame = new JFrame("Assign Prescribes");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel title = new JLabel("Assign Prescribes");
        title.setBounds(150, 10, 300, 25);
        panel.add(title);

        int xLabel = 30, xField = 160;
        int widthLabel = 120, widthField = 200;
        int height = 25, y = 50, gap = 40;

        JLabel docLabel = new JLabel("Doctor ID:");
        docLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(docLabel);
        JTextField docField = new JTextField();
        docField.setBounds(xField, y, widthField, height);
        panel.add(docField);
        y += gap;

        JLabel patientIdLabel = new JLabel("Patient ID:");
        patientIdLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(patientIdLabel);
        JTextField patientIdField = new JTextField();
        patientIdField.setBounds(xField, y, widthField, height);
        panel.add(patientIdField);
        y += gap;

        JLabel nameLabel = new JLabel("Prescription Name:");
        nameLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(xField, y, widthField, height);
        panel.add(nameField);
        y += gap;

        JLabel dateLabel = new JLabel("Date (MM-dd-yyyy):");
        dateLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(dateLabel);
        JTextField dateField = new JTextField();
        dateField.setBounds(xField, y, widthField, height);
        panel.add(dateField);
        y += gap;

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, y, 120, 30);
        submitButton.addActionListener(e -> {
            try {
                Prescribes pres = new Prescribes(
                    docField.getText(),
                    patientIdField.getText(),
                    nameField.getText(),
                    dateField.getText()
                );

                HospitalGui.addPrescribes(pres);
                JOptionPane.showMessageDialog(frame, "Prescribes Added Successfully!");

                docField.setText("");
                patientIdField.setText("");
                nameField.setText("");
                dateField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });
        panel.add(submitButton);

        JButton back = new JButton("Back");
        back.setBounds(250, y, 100, 30);
        back.addActionListener(e -> {
            frame.dispose();
            new HospitalGui();
        });
        panel.add(back);

        frame.setVisible(true);
    }
}