# **Thiết kế các lớp trong hệ thống Payroll System**

## 1. Timecard Management System

### 1.1 Lớp: Timecard

**Thuộc tính:**
- `id`: ID bảng chấm công (String)
- `employeeId`: ID nhân viên (String)
- `projectId`: Mã dự án (String)
- `hoursWorked`: Số giờ làm việc (float)
- `date`: Ngày chấm công (Date)
- `status`: Trạng thái ("Draft", "Submitted", "Approved")

**Phương thức:**
- `submit()`: Gửi bảng chấm công để duyệt.
- `approve()`: Phê duyệt bảng chấm công.
- `reject()`: Từ chối bảng chấm công.

**Trạng thái:**
- `Draft`: Bảng chấm công mới tạo.
- `Submitted`: Bảng chấm công đã gửi duyệt.
- `Approved`: Bảng chấm công đã phê duyệt.
- `Rejected`: Bảng chấm công bị từ chối.

![diagram](https://www.planttext.com/api/plantuml/png/NCyn3i8m30NGFQVm20CNoDI1XHaaPjCO22HDP3kLAiJ963WILo1aG9J5qd_IrvTVZsSdYgmb1jC7586TZzGZExWPW1LuPs6hx8TJYnHpI1FHPiwPquLw_TDpAYpxn5UgVWm9jR539GlhUbki-rhafmWWvH2zBfOMnkHT8ynrOwIPCNr6ltGt7GskVl86003__mC0)



### 1.2 Lớp: TimecardController

**Thuộc tính:**
- `timecardRepository`: Tham chiếu đến lớp TimecardRepository.

**Phương thức:**
- `validateTimecard(timecard: Timecard)`: Xác thực bảng chấm công.
- `saveTimecard(timecard: Timecard)`: Lưu bảng chấm công vào TimecardRepository.
- `submitTimecard(timecardId: String)`: Gửi bảng chấm công để duyệt.

![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niK98PcvgSc9HYdD-NabHVavEQf52DPU2Wgv22LGYABKWlpYp9B-eqWgk6246LAgWK9QOavcIM98AazQ0wKNeqBHIAClFJ04hBqui8rffQL9kPWc6Oa-Wyk2IeioyT9ZYMYw7rBmKeBS00000__y30000)

### 1.3 Lớp: TimecardRepository

**Thuộc tính:**
- `databaseConnection`: Kết nối cơ sở dữ liệu.

**Phương thức:**
- `save(timecard: Timecard)`: Lưu bảng chấm công.
- `findById(timecardId: String)`: Tìm bảng chấm công theo ID.
- `findByEmployeeId(employeeId: String)`: Tìm các bảng chấm công của nhân viên.

![diagram](https://www.planttext.com/api/plantuml/png/J8z12i8m44NtESKixS8B596Yk2W8Wdg1QJFAI9EKp5W8uibSU2IlO12jtNtuxttuhyUp4iMeLzUPjaCHEBAZ5gFTKn-4DSG4DmCm1ukA3GgjW_VKAWTVmgwvv9Xh0C61PlgLot6cA648R3_8YRrTfTgEM9t1WqRsv-9lJD2DwxkGYB92OvmeMnPT_BobkPkAlCrNtW000F__0m00)

## 2. Payroll Processing System

### 2.1 Lớp: Payroll

**Thuộc tính:**
- `id`: ID bảng tính lương (String)
- `employeeId`: ID nhân viên (String)
- `grossPay`: Lương gốc (float)
- `taxes`: Tiền thuế (float)
- `netPay`: Lương ròng (float)
- `status`: Trạng thái ("Pending", "Processed")

**Phương thức:**
- `calculateNetPay()`: Tính lương ròng.
- `process()`: Đánh dấu bảng lương đã xử lý.

![diagram](https://www.planttext.com/api/plantuml/png/N8un3i8m34NtdC8Z35mWKrSMXCG9hCHKaTouYXr4XNeo1ex45OWoeCBev_Vj_tw-1ZKiLYTsWL4LphWKOOQ70pX0YXukLb8U-qZJpB8G7N_nM4Ir1JrSMT0wCxoJRa4c-rFQPwkwkGGGa4DbD3frUxVtS9CK-suk4aZrorOtK8wj-GS00F__0m00)

### 2.2 Lớp: PayrollController

**Thuộc tính:**
- `payrollRepository`: Tham chiếu đến PayrollRepository.

**Phương thức:**
- `generatePayroll(employeeId: String)`: Tính lương cho nhân viên.
- `processPayroll(payrollId: String)`: Xử lý bảng lương.

![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niK90OcLHVawEStvU2OXEBLAevb9Gq5KeW8W7fHRa5sUMv1TLMi6K8eI02XKKqbFpKeiIIrAXiXgfkGKv-PMfgPufLWh19KMPUUcQLWfb-PafODK5HVd9gSN5CCLGMp3Lrd8vfEQb09q90000__y30000)

### 2.3 Lớp: PayrollRepository

**Thuộc tính:**
- `databaseConnection`: Kết nối cơ sở dữ liệu.

**Phương thức:**
- `save(payroll: Payroll)`: Lưu bảng lương.
- `findById(payrollId: String)`: Tìm bảng lương theo ID.

![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niK90OcLHVavEK6f1Vd5cINvHfK8rbuA2ha9AOabYKc9ngdD-NbvgSabcVfwLWdzI5f09b5PGA4uiIzKeWEYrWXcYQQLGbf-P0bQGbfcNubJfcG9Jv9bYfH1SKfIPbwu9LyzLo-MGcfS2T0m0003__mC0)

## 3. Employee Management System

### 3.1 Lớp: Employee

**Thuộc tính:**
- `id`: ID nhân viên (String)
- `name`: Tên nhân viên (String)
- `position`: Chức vụ (String)
- `salaryType`: Loại lương ("Hourly", "Salaried", "Commissioned")
- `paymentMethod`: Phương thức thanh toán (String)

**Phương thức:**
- `updateInfo()`: Cập nhật thông tin nhân viên.

![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niO9hRa5EVcLgga8rbuA2ha9cYfL2S4bHPbuwc9kNc9kA8b2GNvnPafcVXo9Od9YJM5GPKbc0fZQnCZSrhyGtjIGZ7zbO1ONIWfJ4abJFlBHy3KqhXRByp1IkMYw7rBmKeBi00000__y30000)

### 3.2 Lớp: EmployeeController

**Thuộc tính:**
- `employeeRepository`: Tham chiếu đến EmployeeRepository.

**Phương thức:**
- `addEmployee(employee: Employee)`: Thêm nhân viên mới.
- `updateEmployee(employeeId: String)`: Cập nhật thông tin nhân viên.
- `removeEmployee(employeeId: String)`: Xóa nhân viên.

![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bToJc9niO9hRa5EVcLggdD-NabHVavEQf52DPU2Wgv2AbGYABKWlpYp9B-eqWgk6246LAgWa9YI0fFHW6b3ADQqKYZBpqm1gomjI4aiISLGx9bYfH1SKfIPbuwik2WrDx-C6CMrN0wfUIb0Fm40003__mC0)

### 3.3 Lớp: EmployeeRepository

**Thuộc tính:**
- `databaseConnection`: Kết nối cơ sở dữ liệu.

**Phương thức:**
- `save(employee: Employee)`: Lưu thông tin nhân viên.
- `findById(employeeId: String)`: Tìm nhân viên theo ID.
- `findAll()`: Truy xuất danh sách nhân viên.

![diagram](https://www.planttext.com/api/plantuml/png/H8v12i8m54JtESLVjWil44Igug8W5FG4QVzN8cbIyh-589xCXKVo2WRHk1jctWppUZmR5XFbEZerECCCkt5o8H4TQ0fi9SG4DmMm03HYUiEq3TxJ83Pu3Lr_oJB706ncgkXRrcMcrZ07Yn_aP3rkKei5Qr73KQBrv_hVAEZQkIhxUyko_8KhTLSDUSn_tm000F__0m00)

## 4. Quan hệ phụ thuộc và kết hợp

**Quan hệ kết hợp:**
- `Timecard` được tham chiếu bởi `TimecardController` và được lưu trong `TimecardRepository`.
- `Payroll` được tham chiếu bởi `PayrollController` và được lưu trong `PayrollRepository`.
- `Employee` được tham chiếu bởi `EmployeeController` và được lưu trong `EmployeeRepository`.

**Quan hệ phụ thuộc:**
- `TimecardController` phụ thuộc vào `ProjectManagementDatabase` để xác thực mã dự án.
- `PayrollController` phụ thuộc vào `EmployeeRepository` để truy xuất thông tin nhân viên.
- `PayrollController` phụ thuộc vào `IBankSystem` để gửi thanh toán lương.

![diagram](https://www.planttext.com/api/plantuml/png/UhzxlqDnIM9HIMbk3bT8PcvgSc9HYdD-NabHVavEQf62hgwT0amuABKWlpYp9B-eaYiWiHAa04qXL1H9dMjkGKv-PMegcaAOC99A77O75ELdfIQN-2Rc9QQdvgRcbRWabYGc9HQdud025fEnA_HqIipB3guiBadDvN98pKi1-Xy0003__mC0)

