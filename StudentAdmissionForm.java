import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class StudentAdmissionForm {

    private JFrame frame;
    private JTextField nameField, fatherNameField, motherNameField, phoneNumberField, emailField, presentAddressField, permanentAddressField;
    private JComboBox<String> dayCombo, monthCombo, yearCombo, waiverCombo;
    private JRadioButton bloodGroupAPositive, bloodGroupANegative, bloodGroupBPositive, bloodGroupBNegative,
            bloodGroupABPositive, bloodGroupABNegative, bloodGroupOPositive, bloodGroupONegative;
    private JRadioButton maleButton, femaleButton, otherButton;
    private JTextField sscGpaField, hscGpaField, admissionBatchField, emergencyNumberField;
    private JRadioButton SWEButton, CSEButton, EEEButton, BBAButton, LLBButton, EconomicsButton, EnglishButton;
    private JRadioButton fallButton, springButton, summerButton;
    private JButton copyAddressButton;

    public StudentAdmissionForm() {
        frame = new JFrame("Student Admission Form");
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(750, 900);
        frame.setLocationRelativeTo(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        JLabel universityLabel = new JLabel("<html><span style='color:black;'>Metropolitan University</span></html>", JLabel.CENTER);
        universityLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        headerPanel.add(universityLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(20, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(formPanel, BorderLayout.CENTER);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Father's Name:"));
        fatherNameField = new JTextField();
        formPanel.add(fatherNameField);

        formPanel.add(new JLabel("Mother's Name:"));
        motherNameField = new JTextField();
        formPanel.add(motherNameField);

        formPanel.add(new JLabel("Date of Birth:"));
        JPanel datePanel = new JPanel();
        dayCombo = new JComboBox<>();
        for (int i = 1; i <= 31; i++) dayCombo.addItem(String.format("%02d", i));
        monthCombo = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"});
        yearCombo = new JComboBox<>();
        for (int i = 2005; i >= 1990; i--) yearCombo.addItem(String.valueOf(i));
        datePanel.add(dayCombo);
        datePanel.add(monthCombo);
        datePanel.add(yearCombo);
        formPanel.add(datePanel);

        formPanel.add(new JLabel("Blood Group:"));
        JPanel bloodGroupPanel = new JPanel();
        bloodGroupAPositive = new JRadioButton("A+");
        bloodGroupANegative = new JRadioButton("A-");
        bloodGroupBPositive = new JRadioButton("B+");
        bloodGroupBNegative = new JRadioButton("B-");
        bloodGroupABPositive = new JRadioButton("AB+");
        bloodGroupABNegative = new JRadioButton("AB-");
        bloodGroupOPositive = new JRadioButton("O+");
        bloodGroupONegative = new JRadioButton("O-");
        ButtonGroup bloodGroupGroup = new ButtonGroup();
        bloodGroupGroup.add(bloodGroupAPositive);
        bloodGroupGroup.add(bloodGroupANegative);
        bloodGroupGroup.add(bloodGroupBPositive);
        bloodGroupGroup.add(bloodGroupBNegative);
        bloodGroupGroup.add(bloodGroupABPositive);
        bloodGroupGroup.add(bloodGroupABNegative);
        bloodGroupGroup.add(bloodGroupOPositive);
        bloodGroupGroup.add(bloodGroupONegative);
        bloodGroupPanel.add(bloodGroupAPositive);
        bloodGroupPanel.add(bloodGroupANegative);
        bloodGroupPanel.add(bloodGroupBPositive);
        bloodGroupPanel.add(bloodGroupBNegative);
        bloodGroupPanel.add(bloodGroupABPositive);
        bloodGroupPanel.add(bloodGroupABNegative);
        bloodGroupPanel.add(bloodGroupOPositive);
        bloodGroupPanel.add(bloodGroupONegative);
        formPanel.add(bloodGroupPanel);

        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);
        formPanel.add(genderPanel);

        formPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        formPanel.add(phoneNumberField);

        formPanel.add(new JLabel("Emergency Number:"));
        emergencyNumberField = new JTextField();
        formPanel.add(emergencyNumberField);

        formPanel.add(new JLabel("Email Address:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Present Address:"));
        presentAddressField = new JTextField();
        formPanel.add(presentAddressField);

        formPanel.add(new JLabel("Permanent Address:"));
        permanentAddressField = new JTextField();
        formPanel.add(permanentAddressField);

        formPanel.add(new JLabel("Copy Present Address to Permanent Address:"));
        copyAddressButton = new JButton("Copy Address");
        formPanel.add(copyAddressButton);

        copyAddressButton.addActionListener(e -> permanentAddressField.setText(presentAddressField.getText()));

        formPanel.add(new JLabel("Waiver (%):"));
        waiverCombo = new JComboBox<>();
        for (int i = 5; i <= 100; i += 5) {
            waiverCombo.addItem(i + "%");
        }
        formPanel.add(waiverCombo);

        formPanel.add(new JLabel("SSC GPA:"));
        sscGpaField = new JTextField();
        formPanel.add(sscGpaField);

        formPanel.add(new JLabel("HSC GPA:"));
        hscGpaField = new JTextField();
        formPanel.add(hscGpaField);

        formPanel.add(new JLabel("Department:"));
        JPanel departmentPanel = new JPanel();
        SWEButton = new JRadioButton("SWE");
        CSEButton = new JRadioButton("CSE");
        EEEButton = new JRadioButton("EEE");
        BBAButton = new JRadioButton("BBA");
        LLBButton = new JRadioButton("LLB");
        EconomicsButton = new JRadioButton("Economics");
        EnglishButton = new JRadioButton("English");
        ButtonGroup departmentGroup = new ButtonGroup();
        departmentGroup.add(SWEButton);
        departmentGroup.add(CSEButton);
        departmentGroup.add(EEEButton);
        departmentGroup.add(BBAButton);
        departmentGroup.add(LLBButton);
        departmentGroup.add(EconomicsButton);
        departmentGroup.add(EnglishButton);
        departmentPanel.add(SWEButton);
        departmentPanel.add(CSEButton);
        departmentPanel.add(EEEButton);
        departmentPanel.add(BBAButton);
        departmentPanel.add(LLBButton);
        departmentPanel.add(EconomicsButton);
        departmentPanel.add(EnglishButton);
        formPanel.add(departmentPanel);

        formPanel.add(new JLabel("Admission Batch Number:"));
        admissionBatchField = new JTextField();
        formPanel.add(admissionBatchField);

        formPanel.add(new JLabel("Session:"));
        JPanel sessionPanel = new JPanel();
        fallButton = new JRadioButton("Fall");
        springButton = new JRadioButton("Spring");
        summerButton = new JRadioButton("Summer");
        ButtonGroup sessionGroup = new ButtonGroup();
        sessionGroup.add(fallButton);
        sessionGroup.add(springButton);
        sessionGroup.add(summerButton);
        sessionPanel.add(fallButton);
        sessionPanel.add(springButton);
        sessionPanel.add(summerButton);
        formPanel.add(sessionPanel);

        JPanel buttonPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String dept = "";
            if (SWEButton.isSelected()) dept = "SWE";
            else if (CSEButton.isSelected()) dept = "CSE";
            else if (EEEButton.isSelected()) dept = "EEE";
            else if (BBAButton.isSelected()) dept = "BBA";
            else if (LLBButton.isSelected()) dept = "LLB";
            else if (EconomicsButton.isSelected()) dept = "Economics";
            else if (EnglishButton.isSelected()) dept = "English";
            String batch = admissionBatchField.getText();

            if (name.isEmpty() || dept.isEmpty() || batch.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String fileName = name + "" + dept + "" + batch + ".txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("Student Admission Form Details:\n");
                writer.write("Name: " + name + "\n");
                writer.write("Father's Name: " + fatherNameField.getText() + "\n");
                writer.write("Mother's Name: " + motherNameField.getText() + "\n");
                writer.write("Date of Birth: " + dayCombo.getSelectedItem() + " " + monthCombo.getSelectedItem() + " " + yearCombo.getSelectedItem() + "\n");
                writer.write("Blood Group: " + (bloodGroupAPositive.isSelected() ? "A+" : 
                    bloodGroupANegative.isSelected() ? "A-" :
                    bloodGroupBPositive.isSelected() ? "B+" :
                    bloodGroupBNegative.isSelected() ? "B-" :
                    bloodGroupABPositive.isSelected() ? "AB+" :
                    bloodGroupABNegative.isSelected() ? "AB-" :
                    bloodGroupOPositive.isSelected() ? "O+" : "O-") + "\n");
                writer.write("Gender: " + (maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Other") + "\n");
                writer.write("Phone Number: " + phoneNumberField.getText() + "\n");
                writer.write("Emergency Number: " + emergencyNumberField.getText() + "\n");
                writer.write("Email Address: " + emailField.getText() + "\n");
                writer.write("Present Address: " + presentAddressField.getText() + "\n");
                writer.write("Permanent Address: " + permanentAddressField.getText() + "\n");
                writer.write("Waiver: " + waiverCombo.getSelectedItem() + "\n");
                writer.write("SSC GPA: " + sscGpaField.getText() + "\n");
                writer.write("HSC GPA: " + hscGpaField.getText() + "\n");
                writer.write("Department: " + dept + "\n");
                writer.write("Admission Batch: " + batch + "\n");
                writer.write("Session: " + (fallButton.isSelected() ? "Fall" : springButton.isSelected() ? "Spring" : "Summer") + "\n");
                JOptionPane.showMessageDialog(frame, "Congratulations,Welcome to Metropolitan University! and Data saved successfully to " + fileName);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(frame, "Error saving data: " + ioException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentAdmissionForm();
    }
}