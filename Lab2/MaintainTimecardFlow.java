import java.time.LocalDate;
import java.util.Scanner;

public class MaintainTimecardFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimecardController controller = new TimecardController();

        // Thông tin nhân viên giả lập
        Employee employee = new Employee(1, "Nguyen Van A");

        // Bước 1: Bắt đầu quy trình
        System.out.println("Duy tri bang cham cong cho nhan vien: " + employee.getName());
        LocalDate today = LocalDate.now();

        // Bước 2: Lấy bảng chấm công hiện tại
        Timecard timecard = controller.getTimecard(employee.getEmployeeId(), today);
        System.out.println("Da truy xuat bang cham cong ngay: " + today);

        // Bước 3: Hiển thị danh sách mã dự án
        controller.displayChargeCodes();

        // Bước 4: Nhập số giờ làm việc và mã dự án
        System.out.print("Nhap so gio lam viec: ");
        double hoursWorked = scanner.nextDouble();
        System.out.print("Nhap ma du an: ");
        String chargeNumber = scanner.next();

        timecard.setHoursWorked(hoursWorked);
        timecard.setChargeNumber(chargeNumber);

        // Bước 5: Lưu bảng chấm công
        controller.saveTimecard(timecard);

        scanner.close();
    }
}
