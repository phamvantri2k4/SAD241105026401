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
  
5. **Sơ đồ uml biểu đồ con Timecard Management System :**
   
   ![diagram](https://www.planttext.com/api/plantuml/png/V9112i9034NtSuhWlXTm8OMAu48GA-xZJ93gp6IOfa8HJ-R28ta5Mw6sYZNBdvV_FtdSxcaf6ALoLWNK9pmGJBQ58utHm0fz8pZo0dbT2ha9N1Gqeza5zgtUiGkERcILiPV8rb8S0JOKk2o4O_q5h2CVIKjVOuw2Uon9lS1XDYJ9x4SYJ67fGzLdGMlnSJs0XnvzgSOZnpEzD_-kHnit9ZkqXK6X3eAC3QchIicRzlzF0000__y30000)

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

4. **Sơ đồ uml biểu đồ con Payroll Processing System :**
   
   ![diagram](https://www.planttext.com/api/plantuml/png/V51B2i8m4Dtd54FtlO0BAUh6NMczm90EDRH9IZ8AHJoP2u_a5KnKIccaitcBzsLUZsVX6HrVT2y6b1ss15c9exDz3wMpahnNfeLwz4mwWvk0SDBgmHeo33_ftXgEI2xbvPbaLz5WlMBhneNWk4FJVTCNp4bfakYQcVMZI2eXpxT_Yc03TK2Qg1NtR4MqaMcYKCSP1sHSSQOhGq15x1HTQMAzk8iYfCOtlm400F__0m00)
   
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
     
5. **Sơ đồ uml biểu đồ con Employee Management System :**
   
   ![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bT1Od9sOdggWf9hRa5EVcLgge9lOXvG83SrhqGXkBAu93LNIQ6QIm48alDp2_BpGE8mjMxvHRauf9ppyqgAydDoKejmA0XABSWlpYp9Bwha0gj0DbD1LzSEYqaALWgUUGMb23CKN19B4b5q8ob6DWDX6T0CY0VH3AdbSaZDIm6520000F__0m00)
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
     
5. **Sơ đồ uml biểu đồ con Purchase Order Management System :**

![diagram](https://www.planttext.com/api/plantuml/png/b9512i9034NtSuhWlXTm8OMAEr4ik4_ReDNEfAJfeeWdS-6Hl8BJIgbOMZ2RGER_bn_czNY6bQ9eRGjJOdh54y5YNqjwnefW9na9RD7viIMd43ULabt0pO2lb6t9hfttZiwmOR5pxn4x5IuAaZdLWKgkScLfVbN25qfrIBL6nSJRJ2SSHO4WM4q5W2N4TMBpOVVdvZ7fopFY3L5Rdk_qDsxg9WyyOf5dgDIB8EACpDs4vBBsszu0003__mC0)
   
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

4. **Sơ đồ uml biểu đồ con Bank Integration System :**

   ![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bT1Od9sOdggWf9JObwsWcTUIMfwKM99PdwUGd1bSKbghf92DPS242JdvnRavwNcbIXuWbH29D5aG1AEAOa59Qb5N60f9AKAkhfso0eKh1G2YlAJKukB5G8IAtE1shbgkHnIyr90ZW80003__mC0)

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
     
5. **Sơ đồ uml biểu đồ con Project Management System :
   
    ![diagram](https://www.planttext.com/api/plantuml/png/R91D2i8m48NtESNGVI_WGWeMmONWpmd6E8gQPDfaiYZYoLnu9AzWAb83xUnctfllmNi_NrKGz1AjKGtg6vu9YetdAsc1DRgqMt82-ou8sGBk2j9ejWsx_lwpBjdRQMN1JZmRGtvQ_sVKA7Z0GEfhpC1GblCn3cQmepPI651Ga-35XFm_ysUKSMYYRIFvRc2jt8dLGrNaZdqt7m000F__0m00)
---
## **Sơ đồ hệ thống con**
Dưới đây là sơ đồ UML thể hiện các hệ thống con và mối quan hệ phụ thuộc giữa chúng.

![diagram](https://www.planttext.com/api/plantuml/png/Z5LBJiCm4Dtd55Oth7g1Bb2XWDG5ehI8lUiCRMXYMxPJ5A6UZ0L7uWhuKpifSKooYPJtPZnltdZoy_KzbmeBLLTbnZ4vu1sWoGetWfKbsZHIGJL1dndIJu1VYWe85Zbwn5H_g82gFrJp45PnHWtc-GzCL0bumQWonu98aDR0cImK4qqWzUFHT7eTYK0pjC5728ZDSCeknNdjAy48I5dGNLBRcPwiNNF87iWXKdjBMjvYUd0d1RINt0hhfpF2z1i2z4-6pbac56XkYDR7Ewnmj2_t5IzP0p3MTCyVCDt3oSPvKgHn_NYhh1-X1RgA0pQiSLKBiiSIq9F8TSAHIdsK3HgGUy593qkN6H4-aCbDHZos7OyBVT4McCb0IwfW9x0g64qgZyriYnhm9iTSTNHs9yzKtE7eAiztpWzZt2F1te6eqUOu-f0j3aqRuZZjUMPyjhgBhIL_ipWpXkAqqESQj2rUofA-iQxMAxI6qdPVxWikqHRK1m15qkgKbZEmz5Bho_RtMEGWGtHx5L9ZbUhv3BtYiiYnWY1dmNBNc_Zo6Hunjug2_PeZbQY9RKIMkFGZHVVlVzou4Mj0LrfppeIINhwkCJjbSrs_-PF-0W00__y30000)

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
