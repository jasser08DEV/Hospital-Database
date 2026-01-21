import java.awt.event.*;
import javax.swing.*;

public class DepartmentGui {
    String code;
    String name;
    String officeNumber;
    String officePhone;
    String head;


    public DepartmentGui() {
        openDepartmentWindow();
    }

    public void openDepartmentWindow() {
        JFrame depFrame = new JFrame("Department Management");
        depFrame.setSize(700, 450);
        depFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        depFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        depFrame.add(panel);

        JLabel title = new JLabel("Department Management Window");
        title.setBounds(220, 10, 300, 25);
        panel.add(title);

        int xLabel = 40;
        int xField = 180;
        int widthLabel = 150;
        int widthField = 250;
        int height = 25;
        int y = 60;
        int gap = 40;

        JLabel codeLabel = new JLabel("Code:");
        codeLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(codeLabel);

        JTextField codeField = new JTextField(10);
        codeField.setBounds(xField, y, widthField, height);
        panel.add(codeField);
        y += gap;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(nameLabel);

        JTextField nameField = new JTextField(50);
        nameField.setBounds(xField, y, widthField, height);
        panel.add(nameField);
        y += gap;

        JLabel officeNumberLabel = new JLabel("Office Number:");
        officeNumberLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(officeNumberLabel);

        JTextField officeNumberField = new JTextField(11);
        officeNumberField.setBounds(xField, y, widthField, height);
        panel.add(officeNumberField);
        y += gap;

        JLabel officePhoneLabel = new JLabel("Office Phone:");
        officePhoneLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(officePhoneLabel);

        JTextField officePhoneField = new JTextField(11);
        officePhoneField.setBounds(xField, y, widthField, height);
        panel.add(officePhoneField);
        y += gap;

        JLabel headLabel = new JLabel("Head:");
        headLabel.setBounds(xLabel, y, widthLabel, height);
        panel.add(headLabel);

        JTextField headField = new JTextField(50);
        headField.setBounds(xField, y, widthField, height);
        panel.add(headField);
        y += gap + 10;

        JButton submit = new JButton("Submit");
        submit.setBounds(180, y, 100, 30);
        panel.add(submit);
        y += gap;

        JButton back = new JButton("Back");
        back.setBounds(400, y,150, 30);
        back.addActionListener(e -> {
            depFrame.dispose();
            new HospitalGui(); 
        });
        panel.add(back);

        

        depFrame.setVisible(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department department = new Department(
                codeField.getText(),
                nameField.getText(),
                officeNumberField.getText(),
                officePhoneField.getText(),
                headField.getText()
                );
                HospitalGui.addDepartment(department);

                codeField.setText("");
                nameField.setText("");
                officeNumberField.setText("");
                officePhoneField.setText("");
                headField.setText("");            
            }
        });
    }
    public String getHead() {
        return head;
    }
    public String getName() {
        return name;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public String getOfficePhone() {
        return officePhone;
    }
    public String getCode() {
        return code;
    }


}
