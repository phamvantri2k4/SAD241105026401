import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TimecardController {
    private List<Timecard> timecards;
    private ProjectManagementDatabase database;

    public TimecardController() {
        this.timecards = new ArrayList<>();
        this.database = new ProjectManagementDatabase();
    }

    // Lấy hoặc tạo mới bảng chấm công cho một nhân viên
    public Timecard getTimecard(int employeeId, LocalDate date) {
        for (Timecard t : timecards) {
            if (t.getDate().equals(date) && t.getEmployeeId() == employeeId) {
                return t;
            }
        }
        // Tạo mới nếu không tìm thấy bảng chấm công
        Timecard newTimecard = new Timecard(employeeId, date, 0, null);
        timecards.add(newTimecard);
        return newTimecard;
    }

    // Hiển thị danh sách mã dự án
    public void displayChargeCodes() {
        System.out.println("danh sach ma du an co san:");
        for (String code : database.getChargeCodes()) {
            System.out.println(" - " + code);
        }
    }

    // Lưu bảng chấm công
    public void saveTimecard(Timecard timecard) {
        System.out.println("Da luu bang cham cong:");
        System.out.println("Ma nhan vien: " + timecard.getEmployeeId());
        System.out.println("Ngay: " + timecard.getDate());
        System.out.println("So gio lam viec: " + timecard.getHoursWorked());
        System.out.println("Ma du an: " + timecard.getChargeNumber());
    }
}
