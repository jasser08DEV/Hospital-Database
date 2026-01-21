import java.awt.event.*;
import javax.swing.*;

public class AssignProcedureGui {
    public AssignProcedureGui() {
        openAssignProcedureGui();
    }

    private void openAssignProcedureGui() {
        JFrame apFrame = new JFrame("Assign Procedure to Patient");
        apFrame.setSize(500, 500);
        apFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        apFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        apFrame.add(panel);

        JLabel title = new JLabel("Assign Procedure Management Window");
        title.setBounds(100, 10, 300, 25);
        panel.add(title);

        int xLabel = 30;
        int xField = 160;
        int widthLabel = 120;
        int widthField = 200;
        int height = 25;
        int y = 50;
        int gap = 40;

        JLabel patientIdLabel = new JLabel("Patient ID:");
        patientIdLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(patientIdLabel);
        JTextField patientIdField = new JTextField();
        patientIdField.setBounds(xField, y, widthField, height);
        panel.add(patientIdField);
        y += gap;

        JLabel procCodeLabel = new JLabel("Procedure Code:");
        procCodeLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(procCodeLabel);
        JTextField procCodeField = new JTextField();
        procCodeField.setBounds(xField, y, widthField, height);
        panel.add(procCodeField);
        y += gap;

        JLabel docIdLabel = new JLabel("Doctor ID:");
        docIdLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(docIdLabel);
        JTextField docIdField = new JTextField();
        docIdField.setBounds(xField, y, widthField, height);
        panel.add(docIdField);
        y += gap;

        JLabel dateLabel = new JLabel("Date (MM-dd-yyyy):");
        dateLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(dateLabel);
        JTextField dateField = new JTextField();
        dateField.setBounds(xField, y, widthField, height);
        panel.add(dateField);
        y += gap;

        JLabel timeLabel = new JLabel("Interaction Time (HH:mm):");
        timeLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(timeLabel);
        JTextField timeField = new JTextField(20);
        timeField.setBounds(xField, y, widthField, height);
        panel.add(timeField);
        y += gap;

        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(notesLabel);
        JTextField notesField = new JTextField();
        notesField.setBounds(xField, y, widthField, height);
        panel.add(notesField);
        y += gap;

        JButton submitButton = new JButton("Assign Procedure");
        submitButton.setBounds(100, y, 150, 30);
        submitButton.addActionListener(e -> {
            try {
                PatientProcedureRecord record = new PatientProcedureRecord(
                    patientIdField.getText(),
                    procCodeField.getText(),
                    dateField.getText(),
                    docIdField.getText(),
                    timeField.getText(),
                    notesField.getText()
                );

                HospitalGui.assignProcedureToPatient(record);
                JOptionPane.showMessageDialog(apFrame, "Record Added Successfully!");

                patientIdField.setText("");
                procCodeField.setText("");
                dateField.setText("");
                docIdField.setText("");
                timeField.setText("");
                notesField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(apFrame, "Error: " + ex.getMessage());
            }
        });
        panel.add(submitButton);

        JButton back = new JButton("Back");
        back.setBounds(270, y, 100, 30);
        back.addActionListener(e -> {
            apFrame.dispose();
            new HospitalGui();
        });
        panel.add(back);

        apFrame.setVisible(true);
    }
}
