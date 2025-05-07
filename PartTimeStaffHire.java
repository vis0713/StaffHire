public class PartTimeStaffHire extends StaffHire {
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    public PartTimeStaffHire(int aVacancyNumber, String aDesignation, String aJobType, String aStaffName,
                             String aJoiningDate, String aQualification,
                             String aAppointedBy, boolean aJoined,
                             int workingHours, double wagesPerHour, String shifts, boolean terminated) {
        super(aVacancyNumber, aDesignation, aJobType, aStaffName,
              aJoiningDate, aQualification, aAppointedBy, aJoined);
        this.workingHours = workingHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = terminated;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public double getWagesPerHour() {
        return wagesPerHour;
    }

    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }

    public String getShifts() {
        return shifts;
    }

    public void setShifts(String shifts) {
        this.shifts = shifts;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public void terminate() {
        if (isTerminated()) {
            System.out.println("Staff is already terminated.");
        } else {
            setTerminated(true);
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            System.out.println("Staff has been terminated successfully.");
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Working Hours: " + workingHours);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
    }
}
