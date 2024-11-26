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
  
```java
class Timecard {
    private String employeeId; 
    private int hoursWorked;   
    private boolean isSubmitted;

    public Timecard(String employeeId) {
        this.employeeId = employeeId;
        this.hoursWorked = 0;
        this.isSubmitted = false;
    }
    // Them gio lam viec
    public void addHours(int hours) {
        if (isSubmitted) {
            System.out.println("Loi: Bang cham cong da gui. Khong the them gio.");
            return;
        }
        if (hours < 0 || hours > 24) {
            System.out.println("Loi: Gio lam viec khong hop le (0-24).");
            return;
        }
        hoursWorked += hours;
        System.out.println("Da them " + hours + " gio. Tong gio hien tai: " + hoursWorked);
    }
    // Gui bang cham cong
    public void submit() {
        if (isSubmitted) {
            System.out.println("Loi: Bang cham cong da gui truoc do.");
            return;
        }
        if (hoursWorked == 0) {
            System.out.println("Loi: Khong the gui bang cham cong voi tong gio = 0.");
            return;
        }
        isSubmitted = true;
        System.out.println("Bang cham cong da gui thanh cong.");
    }
    public void display() {
        System.out.println("=== Thong tin bang cham cong ===");
        System.out.println("Ma nhan vien: " + employeeId);
        System.out.println("Tong gio lam viec: " + hoursWorked);
        System.out.println("Trang thai: " + (isSubmitted ? "Da gui" : "Chua gui"));
        System.out.println("===============================");
    }
}
public class MaintainTimecardApp {
    public static void main(String[] args) {
        Timecard timecard = new Timecard("NV001");

        // Them gio lam viec
        timecard.addHours(5);
        timecard.addHours(3);
        timecard.display();

        // gui bang cham cong
        timecard.submit();
        // them gio sau khi gui
        timecard.addHours(2);
        timecard.display();
    }
}
