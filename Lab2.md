# Phân Tích Các Ca Sử Dụng trong Payroll System

## 1. Tổng quan các ca sử dụng đã xác định
Hệ thống **Payroll System** có các thành phần chính:
1. **Employee (Nhân viên):** Cung cấp thông tin và nhập dữ liệu liên quan đến thời gian làm việc.
2. **Timecard (Bảng chấm công):** Lưu trữ thông tin giờ làm việc.
3. **Paycheck (Phiếu lương):** Lưu thông tin về lương của nhân viên.
4. **PurchaseOrder (Đơn hàng mua):** Quản lý và xử lý đơn mua hàng.
5. **ProjectManagementDatabase:** Cơ sở dữ liệu quản lý các dự án và mã liên quan.
6. **BankSystem:** Xử lý giao dịch gửi lương trực tiếp.

---


## 2. Phân tích các ca sử dụng trong hệ thống Payroll System

Dựa trên hình ảnh và thông tin bạn cung cấp, hệ thống Payroll System bao gồm các ca sử dụng sau:

 ### 1. Maintain Timecard 
**Mô tả:** Nhân viên nhập giờ làm việc, chọn mã dự án (charge number), và lưu thông tin.  
**Các bước:**
1. Nhân viên mở bảng chấm công hiện tại.
2. Nhập giờ làm việc cho từng ngày, chọn mã dự án.
3. Lưu bảng chấm công vào hệ thống.

**Tương tác với các lớp phân tích:**
- Employee: Nhân viên nhập thông tin.
- Timecard: Lưu trữ giờ làm việc và mã dự án.
- ProjectManagementDatabase: Lấy mã dự án hợp lệ.

---

 ### 2. Generate Paycheck
**Mô tả:** Hệ thống tính toán lương dựa trên bảng chấm công và thông tin nhân viên, sau đó tạo phiếu lương.  
**Các bước:**
1. Hệ thống tổng hợp giờ làm việc từ các bảng chấm công.
2. Kiểm tra loại lương (theo giờ hoặc cố định).
3. Tính lương và tạo phiếu lương.

**Tương tác với các lớp phân tích:**
- Employee: Lấy thông tin nhân viên.
- Timecard: Tổng hợp giờ làm việc.
- Paycheck: Lưu thông tin phiếu lương.

---

### 3. Process Purchase Order (Xử lý đơn mua hàng)
**Mô tả:** Hệ thống xử lý các đơn mua hàng của nhân viên.  
**Các bước:**
1. Nhân viên gửi yêu cầu mua hàng.
2. Hệ thống kiểm tra tính hợp lệ của yêu cầu.
3. Xử lý và gửi yêu cầu đến bộ phận tài chính.

**Tương tác với các lớp phân tích:**
- Employee: Gửi yêu cầu.
- PurchaseOrder: Lưu thông tin đơn hàng.

---

### 4. View Project Details (Xem chi tiết dự án)
**Mô tả:** Nhân viên hoặc quản lý xem thông tin chi tiết về các dự án, bao gồm mã dự án và tiến độ.  
**Các bước:**
1. Hệ thống hiển thị danh sách dự án.
2. Người dùng chọn dự án để xem chi tiết.
3. Hiển thị các thông tin như mã dự án, tiến độ, và nhân viên tham gia.

**Tương tác với các lớp phân tích:**
- ProjectManagementDatabase: Cung cấp thông tin dự án.

---

 ### 5. Bank System Integration (Tích hợp hệ thống ngân hàng)
**Mô tả:** Hệ thống tích hợp với ngân hàng để thực hiện giao dịch trả lương cho nhân viên.  
**Các bước:**
1. Tổng hợp phiếu lương đã tạo.
2. Gửi thông tin giao dịch đến hệ thống ngân hàng.
3. Hệ thống ngân hàng thực hiện thanh toán.

**Tương tác với các lớp phân tích:**
- Paycheck: Lấy thông tin phiếu lương.
- BankSystem: Thực hiện giao dịch.

---

 ### 6. Manage Employee Details (Quản lý thông tin nhân viên)
**Mô tả:** Hệ thống cho phép quản lý thông tin nhân viên, bao gồm tạo mới, chỉnh sửa, hoặc xóa thông tin.  
**Các bước:**
1. **Tạo mới nhân viên:**
   - Nhập thông tin nhân viên (tên, ID, lương, liên lạc).
   - Lưu thông tin vào cơ sở dữ liệu.

2. **Chỉnh sửa thông tin nhân viên:**
   - Lấy thông tin nhân viên hiện tại.
   - Thay đổi các trường thông tin và lưu.

3. **Xóa nhân viên:**
   - Chọn nhân viên cần xóa.
   - Kiểm tra liên kết đến bảng chấm công, phiếu lương. Nếu không liên quan, xóa thông tin.

**Tương tác với các lớp phân tích:**
- Employee: Lưu thông tin nhân viên.
- Timecard: Kiểm tra liên kết trước khi xóa.

---

### Tổng quan
Hệ thống **Payroll System** hiện tại bao gồm **6 ca sử dụng chính**:
1. Maintain Timecard (Duy trì bảng chấm công).
2. Generate Paycheck (Tạo phiếu lương).
3. Process Purchase Order (Xử lý đơn mua hàng).
4. View Project Details (Xem chi tiết dự án).
5. Bank System Integration (Tích hợp hệ thống ngân hàng).
6. Manage Employee Details (Quản lý thông tin nhân viên).


## 3. Sơ đồ tuần tự (Sequence Diagram) cho các ca sử dụng

### **Ca sử dụng: Generate Paycheck**
![diagram](https://www.planttext.com/api/plantuml/png/P8-n3S9034NxJE4543q51GZHHi02riKeKNpdu7E4RZOAHc85SWGYejJ_lU_lr-Dvy1rB8eBL5afCAipd58qyRE14jvwYGOV9rUJQOWuCngNnv52h0JwIWOaXGoszHhYBjbGjbUdWg6IO4oWQhICoQeAA31kEIxNyxlYeWR8pspQ60xZ3q4vVb2gEOioafs35NpZlt4kuDkf_u1i00F__0m00)
### **Ca sử dụng: Process Purchase Order**
![diagram](https://www.planttext.com/api/plantuml/png/UhzxlsjkGKv-PMggWgwTGa1fKN96Od6gVr5AQf5pVbv9KNvEJcgHWfM2Sr5gOacgGbvgkK81L952FaWL5ouzwCO13GbBpCbC0Hc3HIT8lKjYIM8Io6GhXU34ibIyDe7KmvqET5z-NbfcKQv2SMboScfnCG000F__0m00)

### **Ca sử dụng: View ProjectManagementDatabase**
![diagram](https://www.planttext.com/api/plantuml/png/UhzxlsjkGKv-PMggWgwTGa1HVbPgSeblObvYUcfkQbw9Is99Ob9YSQg2bK9GQc5fQd69GW54ZK9AQabYPaun5suzG0FXXbif1AVcfS0rvsGMbm00003__mC0)

### **Ca sử dụng: Bank System Integration**
![diagram](https://www.planttext.com/api/plantuml/png/UhzxVq1YPN96QdAsWgwTWbDYNdPmPN59Qgw2bK9mQbwAGa5YPMvgNeb2PbvQVb5kOabcVXuNaYgW7hX-AmNd_BoqpA9SXPAYnBpYn6IGOeNYqkJarE9Y00000F__0m00)

### **Maintain Timecard**
![diagram](https://www.planttext.com/api/plantuml/png/b8yn3i8m34Ntdi8Nu08CB52OAY411t0JqnObSUMubJWR0qVY2cHefI04Wi6BzTx_-e_RlVIzuoiHB5Pmx3mP5BjbyR242hkWwK2dV_42PCAQWmexHvAq7IcOGOI2lfiPcVcJDTDWAVMw-C7Q2r_8Q8K16_AfPeEADKQQorkKXi2mfLXysLS6JO4j3nBXp39xOV0rIVnjxActgFJ7pWEE6Vu4003__mC0)

### **Employee**
![diagram](https://www.planttext.com/api/plantuml/png/d94x3e9048PxJZ4NCFOMDZuI2XiV1nYN7zr4Td6P9V5i5Xx9AxY0A4Ini9tyZ-_FtA-tHPQVx0MWqPIsEeDYbyGczn8RWKjPWIQqnjcZ419BFazOGFAKHWEUJjgA3H-GmKX8si0aBpE5A8w-w8AxvPe7oPwBYc89KKT22roRFsITukfMmulJAF5lxKQimtZNtztFg9k69eT-xmmfQrBjCXPj3TcK2YwHz4Vy_C6iyRy9caz43m000F__0m00)

## 4. Các lớp cần thiết cho các ca sử dụng
- **Employee:** Cung cấp thông tin nhân viên.
- **Timecard:** Lưu thông tin giờ làm việc.
- **Paycheck:** Lưu thông tin phiếu lương.
- **PurchaseOrder:** Quản lý đơn hàng.
- **ProjectManagementDatabase:** Lưu thông tin dự án.
- **BankSystem:** Hệ thống ngân hàng xử lý thanh toán.

  # Mô phỏng Java cho ca sử dụng Maintain Timecard*
  ### Class Employee
```java

public class Employee {
    private int employeeId;
    private String name;

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }
}
```
### Class ProjectManagementDatabase
```java
import java.util.Arrays;
import java.util.List;

public class ProjectManagementDatabase {
    // Simulate retrieving charge numbers from the database
    public List<String> getChargeCodes() {
        return Arrays.asList("MS01", "MS02", "MS03", "MS04");
    }
}
```
### Class Timecard
```java
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
```
### Class TimecardController
```java
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
```
### Class MaintainTimecardFlow
``` java
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
```
