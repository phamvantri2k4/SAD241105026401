# LAB3: IDENTIFY DESIGN ELEMENTS

### Xác định các phần tử thiết kế của hệ thống "Payroll System"

## **1.Subsystem context diagrams**

### **Biểu đồ ngữ cảnh cho BankSystem**
![diagram](https://www.planttext.com/api/plantuml/png/h5HBReCm4Drp2ejLkaWEWAegZTe5kqYSO68cgHKmQ3n6ZTgSh8iUgLUemIGnYIDrKIyGl7apy-PZVhw-buQ1sDPLqeBSmmv5MjYDEHZ6MgofUJ-auYCHxiWAZ14hqFl2MptiJqkDH6FMSAXHyqnfmsGbgqPdOWJp2_OmWF8DvJw8iKD-bhAncbTGWPOu0_-Pbvaec9JUESTUGAwt3TNGXmhy3UgoO73IUWdczEPTpWONecjKEVWTasDogJlNZBG5YQUArGaG-T_AXln_whvJvbJkgsR5LzEvJJcHomJQm81VUXhO2IMg3ccK4s50xGrbOpSLnaE_k4vded-EggS2X_AdNHp1gAQx6KkN83V6OdalsLKF9pblLYkmIKk4vsb4KaC7gWA7nIZ3b89zcS-VOdF9H3fk3veqmlTjSYn2jgHlETVLUIefxFg0uSO-VYuMuSLrJ5MtrN0T77Nfxat_0_W5003__mC0)

### Giải thích các thành phần trong biểu đồ:

- **BankSystem (Subsystem Proxy):**
    - Quản lý giao dịch thanh toán và cung cấp thông tin tài khoản.
    - Phương thức:
        - `processPayment`: Thực hiện thanh toán.
        - `getAccountBalance`: Lấy thông tin số dư tài khoản.
        - `sendStatement`: Gửi sao kê ngân hàng.

- **IBankSystem (Interface):**
    - Giao diện cho phép hệ thống khác giao tiếp với **BankSystem**.
    - Phương thức:
        - `processPayment`: Xử lý thanh toán.
        - `getAccountBalance`: Cung cấp số dư tài khoản.

- **PaymentInstruction (Entity):**
    - Chứa thông tin giao dịch, bao gồm số tài khoản, số tiền, và ngày giao dịch.

- **Paycheck (Entity):**
    - Đại diện cho phiếu lương, bao gồm số tiền và ngày phát hành.

- **BankInformation (Entity):**
    - Lưu trữ thông tin tài khoản, bao gồm số dư hiện tại và số dư khả dụng.


### **Biểu đồ ngữ cảnh cho PrintService**
![diagram](https://www.planttext.com/api/plantuml/png/Z9DDRi8m48NtEOML5KWD1uYgYWLTP8UK4mpEG2qSEx8d4QZbP5rm9AvGvyUDGr2fLoFFyyoNDvFRztLj2GpLfOmgu4Su88lpUcVFbh1aMwDFvvXzHimTBi5QToKKvMWQmN58zATg4nlDwn8LBOeXI9c_UkaLQDA-1ffboXejYg06_q1-x3iGK6qNmvEiI5bEBZuiVT2zkaINQEH-LoJe3jTtdw1wkB5ioA1TnnPybjbhKy8yaIH986f0YW88Vvrmn3kj9O8QaE_DH3FtCVpa86SxLnuafEP0GgidSCzc54vawctMCks1exTN-0kM_NCbOFDW9xJQ_h4L7SEaV9AyZJDDMLmPpT5QjF5SvzrrihfJJ4bVlrQhwJexeIWhYMrn9r-ZAjeVumS00F__0m00)

### Giải thích các thành phần trong biểu đồ:

- **PrintService:**
    - Quản lý các yêu cầu in tài liệu và sử dụng máy in.
    - Phương thức:
        - `printDocument`: Thực hiện việc in tài liệu.
        - `checkPrintStatus`: Kiểm tra trạng thái của máy in.

- **IPrintService (Interface):**
    - Giao diện cho phép các hệ thống khác giao tiếp với **PrintService**.
    - Phương thức:
        - `printDocument`: Yêu cầu **PrintService** in tài liệu.

- **Document (Entity):**
    - Đại diện cho tài liệu cần in, bao gồm thông tin như mã tài liệu, nội dung và định dạng.
    - Phương thức:
        - `validateDocument`: Kiểm tra tính hợp lệ của tài liệu.

- **Printer (Entity):**
    - Đại diện cho máy in, bao gồm các thông tin như trạng thái và vị trí.
    - Phương thức:
        - `printDocument`: Thực hiện việc in tài liệu.

### Quan hệ:
- **PrintService** xử lý tài liệu **Document** và sử dụng **Printer** để in.
- **IPrintService** được **PrintService** triển khai.


### **Biểu đồ ngữ cảnh cho ProjectManagementDatabase subsystems**
![diagram](https://www.planttext.com/api/plantuml/png/h5D1JiCm4Bpd5LPEhOJxW0YX7i8X1n1INx29jv71TY9xNQYWB-F0a_W2Jfg8H0u8fFfaxSxCUcVNd-yVMqTWoMkLj50zGOqitVdI7HsXPW-sUJccx3LXuLGAdEj2ZrZH7PY0rMWe1u8I70weywcH1c1Xzisg7UuYOpkoqjJhR1Jgw1EYRmKGJd8nzue52Cm4WjoXaQBNEIMdvBkNMqEIbbleYBD7HvNYt3reNCYMNeIECoOQNogS98Avv5t4u9mlcfKZWLHkjLweCNTc01fyplzkHc48xHug7FsGOu0L4u5BJBCl_FEkS7up6qF6Kej12m_eql_nphu4LjJ2zTjcyyk-1gxKhUg3WRv58xfly0K00F__0m00)

### Giải thích các thành phần trong biểu đồ:

- **ProjectManagementDatabase:**
    - Cung cấp và cập nhật thông tin dự án.
    - Phương thức:
        - `getProjectInfo`: Lấy thông tin dự án.
        - `updateProjectData`: Cập nhật thông tin dự án.

- **ProjectData (Entity):**
    - Lưu trữ thông tin dự án (mã dự án, tên dự án, ngân sách, trạng thái).
    - Phương thức:
        - `getProjectDetails`: Trả về chi tiết dự án.
        - `updateProjectDetails`: Cập nhật thông tin dự án.

- **IProjectDatabase (Interface):**
    - Giao diện để các hệ thống truy vấn thông tin dự án từ **ProjectManagementDatabase**.
    - Phương thức:
        - `getProjectInfo`: Lấy thông tin dự án.

### Quan hệ:
- **ProjectManagementDatabase** sử dụng **ProjectData** để truy xuất và cập nhật thông tin dự án.
- **ProjectManagementDatabase** implements **IProjectDatabase**, cho phép các hệ thống khác truy cập thông qua **Interface**.

## **2.Analysis class to design element map**

 ánh xạ các lớp phân tích đến các phần tử thiết kế

| **Analysis Class**             | **Design Element**              |
|--------------------------------|---------------------------------|
| **LoginForm**                  | **LoginForm**                   |
| **MaintainTimecardForm**       | **MainEmployeeForm**            |
|                                | **TimecardForm**                |
|                                |  **MainApplicationForm**        |
| **TimecardController**         | **TimecardController**          |
| **SystemClockInterface**       | **SystemClockInterface**        |
| **PayrollController**          | **PayrollController**           |
| **Paycheck**                   | **Paycheck**                    |
| **PaymentInstruction**         | **PaymentInstruction**          |
| **Employee**                   | **Employee**                    |
| **IEmployeeRepository**        | **IEmployeeRepository**         |
| **IPaymentRepository**         | **IPaymentRepository**          |
| **BankSystem**                 | **BankSystem**                  |
| **IBankSystem**                | **IBankSystem**                 |
| **ProjectManagementDatabase**  | **ProjectManagementDatabase**   |
| **IProjectDatabase**           | **IProjectDatabase**            |
| **ProjectData**                | **ProjectData**                 |



---

## **3.Design element to owning package map**

Hãy ánh xạ các phần tử thiết kế vào các gói

| **Design Element**        | **"Owning" Package**                        |
|---------------------------|--------------------------------------------|
| **UserInterface**          | Middleware::Presentation::GUI Framework    |
| **PayrollController**      | Applications::Payroll::BusinessLogic       |
| **TimecardController**     | Applications::Payroll::BusinessLogic       |
| **EmployeeRepository**     | DataAccess::Employee::Repository           |
| **PaymentRepository**      | DataAccess::Payment::Repository            |
| **Database**               | DataAccess::Database::Connection           |
| **Paycheck**               | BusinessServices::Payroll::Artifacts       |
| **PaymentInstruction**     | BusinessServices::Payroll::Artifacts       |
| **IEmployeeRepository**    | Interfaces::Employee::RepositoryInterface  |
| **IPaymentRepository**     | Interfaces::Payment::RepositoryInterface   |
| **IBankSystem**            | Interfaces::Bank::SystemInterface          |
| **IProjectDatabase**       | Interfaces::Project::DatabaseInterface     |
| **BankSystem**             | Subsystems::Bank::PaymentProcessing        |
| **ProjectManagementDatabase** | Subsystems::Project::DatabaseManagement |
| **ProjectData**            | BusinessServices::Project::DataArtifacts   |



## **4.Architectural layers and their dependencies**
Hãy vẽ biểu đồ mô tả các layers trong hệ thống và quan hệ giữa chúng.
![layers](https://www.planttext.com/api/plantuml/png/V5GxJiGm4ErzYb4QeE0258XliH98WE00WpCi5euTx4aWGjJKr5ISW0EaeE0aUmAkW1EItKtMksuYQzxCU_F6az_w-y0pEYuoBNAK3pWbI2uSUJAChAo1Cwp89V0Y81ofqNkuyUGcXidTeQGkydzIvNEDrGaoRk_iGMbLkXHr94cLD35vmOFmgtWL2_gZmYj3WUVCJfMC2RZ0obcjZwtXvajk84AYbeL6fWuMKP8xAmD306IXqP6M1S-roaYYIzSGPMY2u1xa8pmbQfK69JrcGzUDPt0ePTluSijgxlJaDCkrhOYkABTUiNNLGC-Kk4Vq4-ZlIoYF9OrXe-wNA3kBrZDsWBvITntnZK0RBBX5Jx6HpsE3ILjZI7B4U7ecMJ1T5kIgLSOjE9_LxmeU2pHmFwlVOAfczHU2_FcKe6VrHow6ZtntTp_owlOWQQr2oHwU5DydOXNKfCOc5v8TiLDKaeUqcVwTizdQ2gk361H0axPEUyZ_WMt9HCIOctfpFqELn-2I6eg8qAtBMZ2t-MmJ4TcR3IxqI-A1-rLAn06PjFaf_G400F__0m00)

