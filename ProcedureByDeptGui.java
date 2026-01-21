import java.awt.event.*;
import javax.swing.*;

public class ProcedureByDeptGui {

    public ProcedureByDeptGui() {
        openSearchWindow();
    }

    private void openSearchWindow() {
        JFrame frame = new JFrame("Search Procedures by Department");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel title = new JLabel("Enter Department Name or Code:");
        title.setBounds(30, 20, 250, 25);
        panel.add(title);

        JTextField searchField = new JTextField();
        searchField.setBounds(240, 20, 150, 25);
        panel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(400, 20, 80, 25);
        panel.add(searchButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(resultArea);
        scroll.setBounds(30, 60, 430, 300);
        panel.add(scroll);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 370, 100, 30);
        panel.add(backButton);

        
        searchButton.addActionListener(e -> {
            String input = searchField.getText().trim();
            if (!input.isEmpty()) {
                String results = HospitalGui.getProceduresByDept(input);
                resultArea.setText(results);
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a Department Name or Code.");
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            new HospitalGui();
        });

        frame.setVisible(true);
    }
}
