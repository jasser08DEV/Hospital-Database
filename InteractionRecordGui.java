import java.awt.event.*;
import javax.swing.*;

public class InteractionRecordGui {
    public InteractionRecordGui() {
        openInteractionRecordGui();   
    }
    
    private void openInteractionRecordGui() {
        JFrame irFrame = new JFrame("Interaction Record Management");
        irFrame.setSize(700, 550);
        irFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        irFrame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        irFrame.add(panel);
        
        JLabel title = new JLabel("Interaction Record Management Window");
        title.setBounds(180, 10, 400, 25);
        panel.add(title);
        
        int xLabel = 40;
        int xField = 220;
        int widthLabel = 180;
        int widthField = 250;
        int height = 25;
        int y = 60;
        int gap = 40;
        
        JLabel patientIdLabel = new JLabel("Patient ID:");
        patientIdLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(patientIdLabel);
        JTextField patientIdField = new JTextField(10);
        patientIdField.setBounds(xField, y, widthField, height);
        panel.add(patientIdField);
        y += gap;
        
        JLabel idLabel = new JLabel("Interaction Number (1, 2, 3...):");
        idLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(idLabel);
        JTextField idField = new JTextField(10);
        idField.setBounds(xField, y, widthField, height);
        panel.add(idField);
        y += gap;
        
        JLabel dateLabel = new JLabel("Interaction Date (MM-dd-yyyy):");
        dateLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(dateLabel);
        JTextField dateField = new JTextField(20);
        dateField.setBounds(xField, y, widthField, height);
        panel.add(dateField);
        y += gap;
        
        JLabel timeLabel = new JLabel("Interaction Time (HH:mm:ss):");
        timeLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(timeLabel);
        JTextField timeField = new JTextField(20);
        timeField.setBounds(xField, y, widthField, height);
        panel.add(timeField);
        y += gap;
        
        JLabel descLabel = new JLabel("Description:");
        descLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(descLabel);
        JTextField descField = new JTextField(50);
        descField.setBounds(xField, y, widthField, height);
        panel.add(descField);
        y += gap;
        
        JLabel infoLabel = new JLabel("<html>Note: Interaction Number starts at 1 for each patient's<br>first interaction, 2 for second, etc.</html>");
        infoLabel.setBounds(xLabel, y, 450, 40);
        panel.add(infoLabel);
        y += 50;
        
        JButton submitButton = new JButton("Add Record");
        submitButton.setBounds(xField, y, 120, height);
        submitButton.addActionListener(e -> {
            try {
                // Validate Interaction ID is positive
                int id = Integer.parseInt(idField.getText());
                if (id <= 0) {
                    JOptionPane.showMessageDialog(irFrame, 
                        "Interaction Number must be greater than 0!", 
                        "Validation Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                InteractionRecord record = new InteractionRecord(
                    patientIdField.getText(),
                    idField.getText(),
                    dateField.getText(),
                    timeField.getText(),
                    descField.getText()
                );
                
                HospitalGui.addInteractionRecord(record);
                JOptionPane.showMessageDialog(irFrame, 
                    "Interaction Record added successfully!\n" +
                    "Patient: " + patientIdField.getText() + ", Interaction #" + idField.getText());
                
                // Clear fields after successful insertion
                patientIdField.setText("");
                idField.setText("");
                dateField.setText("");
                timeField.setText("");
                descField.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(irFrame, 
                    "Interaction Number must be a valid positive integer!", 
                    "Input Error", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(irFrame, 
                    "Time must be in format HH:mm:ss (e.g., 14:30:00)", 
                    "Time Format Error", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(irFrame, 
                    "Error: " + ex.getMessage() + 
                    "\nMake sure the Patient ID exists!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(submitButton);
        
        JButton back = new JButton("Back");
        back.setBounds(xField + 140, y, 100, height);
        back.addActionListener(e -> {
            irFrame.dispose();
            new HospitalGui();
        });
        panel.add(back);
        
        irFrame.setVisible(true);
    }
}