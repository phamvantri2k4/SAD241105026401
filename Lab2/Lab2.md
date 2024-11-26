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

## 2. Phân tích chi tiết các ca sử dụng

### **Ca sử dụng 1: Maintain Timecard (Duy trì bảng chấm công)**  
Đã được phân tích trong câu hỏi trước với các bước:
1. Lấy bảng chấm công hiện tại (hoặc tạo mới nếu chưa tồn tại).
2. Hiển thị danh sách mã dự án từ **ProjectManagementDatabase**.
3. Nhập số giờ làm việc và lưu lại thông tin.

### **Ca sử dụng 2: Generate Paycheck (Tạo phiếu lương)**
**Mô tả:** Tính toán và tạo phiếu lương dựa trên thông tin từ bảng chấm công và thông tin nhân viên.  
**Các bước:**
1. **Lấy thông tin nhân viên:** Lấy thông tin từ đối tượng `Employee`.
2. **Lấy thông tin bảng chấm công:** Tổng hợp giờ làm việc từ `Timecard` (theo từng kỳ lương).
3. **Tính toán lương:** Xác định kiểu lương (lương giờ hoặc lương cố định).
4. **Tạo phiếu lương:** Lưu kết quả vào `Paycheck`.
5. **Gửi thông tin thanh toán:** Chuyển phiếu lương đến `BankSystem` để xử lý thanh toán.

### **Ca sử dụng 3: Process Purchase Order (Xử lý đơn mua hàng)**
**Mô tả:** Quản lý và xử lý đơn mua hàng.  
**Các bước:**
1. **Nhập thông tin đơn hàng:** Tạo một `PurchaseOrder` với thông tin sản phẩm và giá trị.
2. **Kiểm tra tính hợp lệ:** Xác minh đơn hàng hợp lệ (thông qua các quy tắc kinh doanh).
3. **Lưu đơn hàng:** Lưu thông tin đơn hàng vào hệ thống.

### **Ca sử dụng 4: View Project Details (Xem chi tiết dự án)**
**Mô tả:** Hiển thị danh sách và thông tin mã dự án trong hệ thống.  
**Các bước:**
1. **Lấy danh sách mã dự án:** Truy xuất thông tin từ `ProjectManagementDatabase`.
2. **Hiển thị thông tin dự án:** Bao gồm mã dự án, tên dự án, và chi tiết liên quan.

### **Ca sử dụng 5: Bank System Integration (Tích hợp hệ thống ngân hàng)**
**Mô tả:** Gửi thông tin thanh toán từ phiếu lương đến hệ thống ngân hàng.  
**Các bước:**
1. **Lấy thông tin phiếu lương:** Từ `Paycheck`.
2. **Kết nối với BankSystem:** Thực hiện gửi dữ liệu lương (bao gồm số tài khoản và số tiền).
3. **Xác nhận giao dịch thành công:** Kiểm tra phản hồi từ ngân hàng và lưu lại trạng thái.

---

## 3. Sơ đồ tuần tự (Sequence Diagram) cho các ca sử dụng

### **Ca sử dụng: Generate Paycheck**
![diagram](https://www.planttext.com/api/plantuml/png/P8-n3S9034NxJE4543q51GZHHi02riKeKNpdu7E4RZOAHc85SWGYejJ_lU_lr-Dvy1rB8eBL5afCAipd58qyRE14jvwYGOV9rUJQOWuCngNnv52h0JwIWOaXGoszHhYBjbGjbUdWg6IO4oWQhICoQeAA31kEIxNyxlYeWR8pspQ60xZ3q4vVb2gEOioafs35NpZlt4kuDkf_u1i00F__0m00)
### **Ca sử dụng: Process Purchase Order**
![diagram](https://www.planttext.com/api/plantuml/png/UhzxlsjkGKv-PMggWgwTGa1fKN96Od6gVr5AQf5pVbv9KNvEJcgHWfM2Sr5gOacgGbvgkK81L952FaWL5ouzwCO13GbBpCbC0Hc3HIT8lKjYIM8Io6GhXU34ibIyDe7KmvqET5z-NbfcKQv2SMboScfnCG000F__0m00)

### **Ca sử dụng: View Project Details**
![diagram](https://www.planttext.com/api/plantuml/png/UhzxlsjkGKv-PMggWgwTGa1HVbPgSeblObvYUcfkQbw9Is99Ob9YSQg2bK9GQc5fQd69GW54ZK9AQabYPaun5suzG0FXXbif1AVcfS0rvsGMbm00003__mC0)

### **Ca sử dụng: Bank System Integration**
![diagram](https://www.planttext.com/api/plantuml/png/UhzxVq1YPN96QdAsWgwTWbDYNdPmPN59Qgw2bK9mQbwAGa5YPMvgNeb2PbvQVb5kOabcVXuNaYgW7hX-AmNd_BoqpA9SXPAYnBpYn6IGOeNYqkJarE9Y00000F__0m00)

## 4. Các lớp cần thiết cho các ca sử dụng
- **Employee:** Cung cấp thông tin nhân viên.
- **Timecard:** Lưu thông tin giờ làm việc.
- **Paycheck:** Lưu thông tin phiếu lương.
- **PurchaseOrder:** Quản lý đơn hàng.
- **ProjectManagementDatabase:** Lưu thông tin dự án.
- **BankSystem:** Hệ thống ngân hàng xử lý thanh toán.
