import javax.swing.*;

public class ProcedureGui {

    public ProcedureGui() {
        openProcedureGui();
    }

    private void openProcedureGui() {

        JFrame procFrame = new JFrame("Procedure Management");
        procFrame.setSize(700, 450);
        procFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        procFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        procFrame.add(panel);

        JLabel title = new JLabel("Procedure Management");
        title.setBounds(240, 10, 300, 25);
        panel.add(title);

        int xLabel = 40, xField = 220;
        int widthLabel = 160, widthField = 250;
        int height = 25, y = 60, gap = 40;

        JLabel codeLabel = new JLabel("Procedure Code:");
        codeLabel.setBounds(xLabel, y, widthLabel, height);
        JTextField codeField = new JTextField();
        codeField.setBounds(xField, y, widthField, height);
        panel.add(codeLabel);
        panel.add(codeField);
        y += gap;

        JLabel nameLabel = new JLabel("Procedure Name:");
        nameLabel.setBounds(xLabel, y, widthLabel, height);
        JTextField nameField = new JTextField();
        nameField.setBounds(xField, y, widthField, height);
        panel.add(nameLabel);
        panel.add(nameField);
        y += gap;

        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(xLabel, y, widthLabel, height);
        JTextField descField = new JTextField();
        descField.setBounds(xField, y, widthField, height);
        panel.add(descLabel);
        panel.add(descField);
        y += gap;

        JLabel durationLabel = new JLabel("Duration (Minutes):");
        durationLabel.setBounds(xLabel, y, widthLabel, height);
        JTextField durationField = new JTextField();
        durationField.setBounds(xField, y, widthField, height);
        panel.add(durationLabel);
        panel.add(durationField);
        y += gap;

        JLabel deptLabel = new JLabel("Offering Department Code:");
        deptLabel.setBounds(xLabel, y, widthLabel, height);
        JTextField deptField = new JTextField();
        deptField.setBounds(xField, y, widthField, height);
        panel.add(deptLabel);
        panel.add(deptField);
        y += gap;

        JButton addButton = new JButton("Add Procedure");
        addButton.setBounds(150, y, 150, 25);
        panel.add(addButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(350, y, 150, 25);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            procFrame.dispose();
            new HospitalGui();
        });

        addButton.addActionListener(e -> {
            try {
                Procedure procedure = new Procedure(
                        codeField.getText(),
                        nameField.getText(),
                        descField.getText(),
                        Integer.parseInt(durationField.getText()),
                        deptField.getText()
                );

                HospitalGui.addProcedure(procedure);
                JOptionPane.showMessageDialog(procFrame, "Procedure added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(procFrame, "Error: " + ex.getMessage());
            }
        });

        procFrame.setVisible(true);
    }
}
