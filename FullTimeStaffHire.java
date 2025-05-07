public class FullTimeStaffHire extends StaffHire {
    private double salary; // set salary
    private double weeklyFractionalHours; // set weekly fractional hours 

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                              String joiningDate, String qualification, String appointedBy,
                              boolean joined, double salary, int weeklyFractionalHours) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    public void setWeeklyFractionalHours(double weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
