# **Thiết kế các hệ thống con trong hệ thống Payroll System**

## **1. Hệ thống quản lý chấm công (Timecard Management System)**

### **Mục tiêu:**  
- Cho phép nhân viên nhập, chỉnh sửa bảng chấm công.
- Xác thực tính hợp lệ của mã dự án và lưu dữ liệu bảng chấm công vào hệ thống.

### **Thành phần chính:**  
1. **TimecardForm:**  
   - Giao diện nhập và chỉnh sửa bảng chấm công.
   - Hiển thị các trường như: *giờ làm việc, mã dự án, thời gian*.  
   - Xử lý các thao tác người dùng như thêm, sửa, và lưu bảng chấm công.

2. **TimecardController:**  
   - Điều khiển logic nhập liệu và xác thực bảng chấm công.  
   - Kết nối với `ProjectManagementDatabase` để kiểm tra tính hợp lệ của mã dự án.  
   - Lưu dữ liệu thông qua `TimecardRepository`.

3. **TimecardRepository:**  
   - Thực hiện lưu bảng chấm công vào cơ sở dữ liệu.
   - Truy xuất dữ liệu bảng chấm công theo yêu cầu.

4. **Tích hợp:**  
   - Sử dụng `ProjectManagementDatabase` để kiểm tra mã dự án.

---

## **2. Hệ thống xử lý bảng lương (Payroll Processing System)**

### **Mục tiêu:**  
- Tự động tính toán lương dựa trên bảng chấm công và thông tin nhân viên.
- Tạo phiếu lương, gửi dữ liệu thanh toán đến ngân hàng.

### **Thành phần chính:**  
1. **PayrollController:**  
   - Thu thập bảng chấm công từ `TimecardRepository` và thông tin nhân viên từ `EmployeeRepository`.
   - Tính toán lương dựa trên loại nhân viên (*Hourly, Salaried, Commissioned*).
   - Tạo phiếu lương và gửi đến `PaycheckRepository`.

2. **PaycheckRepository:**  
   - Lưu trữ phiếu lương.
   - Cung cấp dữ liệu phiếu lương cho các báo cáo hoặc xử lý thanh toán.

3. **Tích hợp:**  
   - Gửi yêu cầu thanh toán đến ngân hàng thông qua `IBankSystem`.

---

## **3. Hệ thống quản lý nhân sự (Employee Management System)**

### **Mục tiêu:**  
- Cho phép quản trị viên quản lý thông tin nhân viên, như: thêm, sửa, xóa thông tin nhân viên.

### **Thành phần chính:**  
1. **EmployeeForm:**  
   - Giao diện cho quản trị viên thêm, sửa, và xóa nhân viên.
   - Hiển thị các thông tin như: *tên, mã nhân viên, phương thức thanh toán*.

2. **EmployeeController:**  
   - Điều khiển xử lý logic nhập liệu.
   - Kiểm tra dữ liệu hợp lệ trước khi lưu vào hệ thống.

3. **EmployeeRepository:**  
   - Lưu trữ thông tin nhân viên.
   - Hỗ trợ tìm kiếm nhân viên theo mã hoặc tên.

4. **Tích hợp:**  
   - Cung cấp dữ liệu nhân viên cho hệ thống xử lý bảng lương.

---

## **4. Hệ thống quản lý đơn hàng (Purchase Order Management System)**

### **Mục tiêu:**  
- Xử lý yêu cầu mua hàng từ nhân viên, xác thực mã dự án liên quan, và lưu thông tin đơn hàng.

### **Thành phần chính:**  
1. **PurchaseOrderForm:**  
   - Giao diện nhập yêu cầu mua hàng, gồm: *tên đơn hàng, số lượng, mã dự án*.

2. **PurchaseOrderController:**  
   - Điều khiển logic xử lý đơn hàng.
   - Kiểm tra thông tin đơn hàng thông qua `ProjectManagementDatabase`.

3. **PurchaseOrderRepository:**  
   - Lưu trữ thông tin các đơn hàng.

4. **Tích hợp:**  
   - Kiểm tra mã dự án hợp lệ từ `ProjectManagementDatabase`.

---

## **5. Hệ thống tích hợp ngân hàng (Bank Integration System)**

### **Mục tiêu:**  
- Gửi thông tin thanh toán lương đến ngân hàng để thực hiện giao dịch.

### **Thành phần chính:**  
1. **IBankSystem:**  
   - Giao diện kết nối với hệ thống ngân hàng.

2. **BankAdapter:**  
   - Xử lý định dạng dữ liệu trước khi gửi đến ngân hàng.
   - Tùy chỉnh cho từng ngân hàng cụ thể.

3. **Tích hợp:**  
   - Nhận dữ liệu phiếu lương từ `PayrollController`.
   - Gửi yêu cầu thanh toán cho ngân hàng.

---

## **6. Hệ thống quản lý dự án (Project Management System)**

### **Mục tiêu:**  
- Lưu trữ thông tin dự án và xác thực mã dự án khi được yêu cầu từ các hệ thống khác.

### **Thành phần chính:**  
1. **ProjectForm:**  
   - Giao diện cho nhân viên hoặc quản lý xem thông tin dự án.

2. **ProjectController:**  
   - Điều khiển truy vấn thông tin dự án.

3. **ProjectManagementDatabase:**  
   - Lưu trữ thông tin về mã dự án, tiến độ, và ngân sách.

4. **Tích hợp:**  
   - Hỗ trợ kiểm tra mã dự án cho các hệ thống khác.

---

## **Tương tác giữa các hệ thống con**

1. **Hệ thống quản lý chấm công:**  
   - Cung cấp dữ liệu bảng chấm công cho hệ thống xử lý bảng lương.
   - Xác thực mã dự án qua hệ thống quản lý dự án.

2. **Hệ thống xử lý bảng lương:**  
   - Gửi phiếu lương đến ngân hàng qua hệ thống tích hợp ngân hàng.

3. **Hệ thống quản lý đơn hàng:**  
   - Xác thực mã dự án từ hệ thống quản lý dự án.

4. **Hệ thống quản lý nhân sự:**  
   - Cung cấp thông tin nhân viên cho hệ thống xử lý bảng lương.
