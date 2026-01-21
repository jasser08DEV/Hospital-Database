import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class HealthRecordGui {

    public HealthRecordGui() {
        openRecordWindow();
    }

    private void openRecordWindow() {
        JFrame frame = new JFrame("Patient Health Record");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JPanel topPanel = new JPanel();
        JLabel lblId = new JLabel("Enter Patient ID: ");
        JTextField txtId = new JTextField(15);
        JButton btnGenerate = new JButton("Generate Record");
        
        topPanel.add(lblId);
        topPanel.add(txtId);
        topPanel.add(btnGenerate);
        panel.add(topPanel, BorderLayout.NORTH);

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(reportArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back to Main Menu");
        panel.add(btnBack, BorderLayout.SOUTH);

        btnGenerate.addActionListener(e -> {
            String patientID = txtId.getText().trim();
            if(!patientID.isEmpty()) {
                String report = HospitalGui.generateFullReport(patientID);
                reportArea.setText(report);
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a Patient ID");
            }
        });

        btnBack.addActionListener(e -> {
            frame.dispose();
            new HospitalGui();
        });

        frame.setVisible(true);
    }
}
    