import java.time.LocalDate;

public class Timecard {
    private int employeeId;
    private LocalDate date;
    private double hoursWorked;
    private String chargeNumber;

    public Timecard(int employeeId, LocalDate date, double hoursWorked, String chargeNumber) {
        this.employeeId = employeeId;
        this.date = date;
        this.hoursWorked = hoursWorked;
        this.chargeNumber = chargeNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }
}
