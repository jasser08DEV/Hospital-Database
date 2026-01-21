import javax.swing.*;

public class MedicationGui {
    public MedicationGui() {
        openMedicationGui();
    }

    private void openMedicationGui() {
        JFrame medFrame = new JFrame("Prescription Management");
        medFrame.setSize(700, 500);
        medFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        medFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        medFrame.add(panel);

        JLabel title = new JLabel("Prescription Management Window");
        title.setBounds(220, 10, 300, 25);
        panel.add(title);

        int xLabel = 40;
        int xField = 200;
        int widthLabel = 160;
        int widthField = 250;
        int height = 25;
        int y = 60;
        int gap = 40;


        JLabel nameLabel = new JLabel("Medication Name:");
        nameLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(nameLabel);
        JTextField nameField = new JTextField(20);
        nameField.setBounds(xField, y, widthField, height);
        panel.add(nameField);
        y += gap;

        JLabel manufacturer = new JLabel("Manufacturer:");
        manufacturer.setBounds(xLabel, y, widthLabel, height);
        panel.add(manufacturer);
        JTextField manufacturerField = new JTextField(20);
        manufacturerField.setBounds(xField, y, widthField, height);
        panel.add(manufacturerField);
        y += gap;

        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(descLabel);
        JTextField descField = new JTextField(50);
        descField.setBounds(xField, y, widthField, height);
        panel.add(descField);
        y += gap;

        JButton submitButton = new JButton("Add Prescription");
        submitButton.setBounds(xField, y, 150, height);
        submitButton.addActionListener(e -> {
            try {
                Medication medication = new Medication(
                        nameField.getText(),
                        manufacturerField.getText(),
                        descField.getText()
                );

                HospitalGui.addMedication(medication);
                JOptionPane.showMessageDialog(medFrame, "Prescription added successfully!");

                
                nameField.setText("");
                manufacturerField.setText("");
                descField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(medFrame,
                        "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(submitButton);

        JButton back = new JButton("Back");
        back.setBounds(xField + 170, y, 100, height);
        back.addActionListener(e -> {
            medFrame.dispose();
            new HospitalGui();
        });
        panel.add(back);

        medFrame.setVisible(true);
    }
}
