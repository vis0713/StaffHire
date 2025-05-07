import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    private JTextField vacancyField, designationField, jobTypeField, staffNameField,
            joiningDateField, qualificationField, appointedByField, salaryField,
            weeklyFractionalHoursField, workingHoursField, wagesPerHourField, shiftsField,
            displayNumberField;

    private JCheckBox joinedCheckBox;

    private JButton addFullTimeButton, addPartTimeButton, addSalaryButton,
            addWorkingShiftsButton, terminateButton, displayNumberButton, clearButton;

    private ArrayList<StaffHire> staffList = new ArrayList<>();

    public GUI() {
        setTitle("Staff Hire Management");
        setSize(700, 400);
        setLayout(new GridLayout(10, 4, 5, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("Vacancy:"));
        vacancyField = new JTextField();
        add(vacancyField);

        add(new JLabel("Designation:"));
        designationField = new JTextField();
        add(designationField);

        add(new JLabel("Job Type:"));
        jobTypeField = new JTextField();
        add(jobTypeField);

        add(new JLabel("Job Date:"));
        joiningDateField = new JTextField();
        add(joiningDateField);

        add(new JLabel("Staff Name:"));
        staffNameField = new JTextField();
        add(staffNameField);

        add(new JLabel("Appointed By:"));
        appointedByField = new JTextField();
        add(appointedByField);

        add(new JLabel("Qualification:"));
        qualificationField = new JTextField();
        add(qualificationField);

        add(new JLabel("Salary:"));
        salaryField = new JTextField();
        add(salaryField);

        add(new JLabel("Joined:"));
        joinedCheckBox = new JCheckBox();
        add(joinedCheckBox);

        add(new JLabel("Weekly Fractional Hours:"));
        weeklyFractionalHoursField = new JTextField();
        add(weeklyFractionalHoursField);

        add(new JLabel("Working Hours:"));
        workingHoursField = new JTextField();
        add(workingHoursField);

        add(new JLabel("Wages Per Hour:"));
        wagesPerHourField = new JTextField();
        add(wagesPerHourField);

        add(new JLabel("Shifts:"));
        shiftsField = new JTextField();
        add(shiftsField);

        addFullTimeButton = new JButton("Add Fulltime Staff");
        addFullTimeButton.addActionListener(this);
        add(addFullTimeButton);

        addPartTimeButton = new JButton("Add Parttime Staff");
        addPartTimeButton.addActionListener(this);
        add(addPartTimeButton);

        addSalaryButton = new JButton("Add Salary");
        addSalaryButton.addActionListener(this);
        add(addSalaryButton);

        addWorkingShiftsButton = new JButton("Add Working Shifts");
        addWorkingShiftsButton.addActionListener(this);
        add(addWorkingShiftsButton);

        terminateButton = new JButton("Terminate");
        terminateButton.addActionListener(this);
        add(terminateButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);

        add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        add(displayNumberField);

        displayNumberButton = new JButton("Display Number");
        displayNumberButton.addActionListener(this);
        add(displayNumberButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFullTimeButton) {
            try {
                int vacancy = Integer.parseInt(vacancyField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String staffName = staffNameField.getText();
                String joiningDate = joiningDateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                boolean joined = joinedCheckBox.isSelected();
                double salary = Double.parseDouble(salaryField.getText());
                int hours = Integer.parseInt(weeklyFractionalHoursField.getText());

                FullTimeStaffHire fullStaff = new FullTimeStaffHire(vacancy, designation, jobType, staffName, joiningDate,
                        qualification, appointedBy, joined, salary, hours);
                staffList.add(fullStaff);
                JOptionPane.showMessageDialog(this, "Full-time staff added successfully.");
                fullStaff.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please check the input fields.");
            }
        } else if (e.getSource() == addPartTimeButton) {
            try {
                int vacancy = Integer.parseInt(vacancyField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String staffName = staffNameField.getText();
                String joiningDate = joiningDateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                boolean joined = joinedCheckBox.isSelected();
                double workingHours = Double.parseDouble(workingHoursField.getText());
                double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
                String shifts = shiftsField.getText();

                PartTimeStaffHire partStaff = new PartTimeStaffHire(vacancy, designation, jobType, staffName, joiningDate,
                        qualification, appointedBy, joined, (int) workingHours, wagesPerHour, shifts, false);
                staffList.add(partStaff);
                JOptionPane.showMessageDialog(this, "Part-time staff added successfully.");
                partStaff.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please check the input fields.");
            }
        } else if (e.getSource() == clearButton) {
            vacancyField.setText("");
            designationField.setText("");
            jobTypeField.setText("");
            staffNameField.setText("");
            joiningDateField.setText("");
            qualificationField.setText("");
            appointedByField.setText("");
            salaryField.setText("");
            weeklyFractionalHoursField.setText("");
            workingHoursField.setText("");
            wagesPerHourField.setText("");
            shiftsField.setText("");
            displayNumberField.setText("");
            joinedCheckBox.setSelected(false);
        } else if (e.getSource() == displayNumberButton) {
            try {
                int vacancy = Integer.parseInt(displayNumberField.getText());
                boolean found = false;
                for (StaffHire staff : staffList) {
                    if (staff.getVacancyNumber() == vacancy) {
                        System.out.println("Staff Found:");
                        staff.print();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No staff found, Check vacancy number and Try again!.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid vacancy number.");
            }
        } else if (e.getSource() == addSalaryButton) {
            try {
                int vacancy = Integer.parseInt(vacancyField.getText());
                double salary = Double.parseDouble(salaryField.getText());
                boolean found = false;

                for (StaffHire staff : staffList) {
                    if (staff instanceof FullTimeStaffHire && staff.getVacancyNumber() == vacancy) {
                        System.out.println("Salary entered for Full-time staff with vacancy number " + vacancy + ": " + salary);
                        ((FullTimeStaffHire) staff).print();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No full-time staff found, Check the vacancy number and Try again!.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter valid values for vacancy and salary.");
            }
        } else if (e.getSource() == addWorkingShiftsButton) {
            try {
                int vacancy = Integer.parseInt(vacancyField.getText());
                String newShift = shiftsField.getText();
                boolean found = false;

                for (StaffHire staff : staffList) {
                    if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancy) {
                        ((PartTimeStaffHire) staff).setShifts(newShift);
                        System.out.println("Shift updated for Part-time staff with vacancy " + vacancy + ": " + newShift);
                        ((PartTimeStaffHire) staff).print();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No part-time staff found, Check vacancy number and Try again!.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter valid values for vacancy number and shift.");
            }
        } else if (e.getSource() == terminateButton) {
            try {
                int vacancy = Integer.parseInt(vacancyField.getText());
                boolean found = false;

                for (StaffHire staff : staffList) {
                    if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancy) {
                        ((PartTimeStaffHire) staff).terminate();
                        System.out.println("Part-time staff with vacancy number " + vacancy + " has been terminated.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No part-time staff found, Check vacancy number and Try again!.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid vacancy number.");
            }
        }
    }

    public static void main(String[] args) {
        new GUI();
    }
}
