# **Thiết kế các hệ thống con trong hệ thống Payroll System**

## **1. Hệ thống quản lý chấm công (Timecard Management System)**

### **Mục tiêu:**  
- Cho phép nhân viên nhập, chỉnh sửa bảng chấm công.
- Xác thực tính hợp lệ của mã dự án và lưu dữ liệu bảng chấm công vào hệ thống.

### **Thành phần chính:**  
- **TimecardForm:**  
  - Giao diện nhập và chỉnh sửa bảng chấm công.  
  - Hiển thị các trường như: *giờ làm việc, mã dự án, thời gian*.  
  - Xử lý các thao tác người dùng như thêm, sửa, và lưu bảng chấm công.

- **TimecardController:**  
  - Điều khiển logic nhập liệu và xác thực bảng chấm công.  
  - Kết nối với `ProjectManagementDatabase` để kiểm tra tính hợp lệ của mã dự án.  
  - Lưu dữ liệu thông qua `TimecardRepository`.

- **TimecardRepository:**  
  - Thực hiện lưu bảng chấm công vào cơ sở dữ liệu.  
  - Truy xuất dữ liệu bảng chấm công theo yêu cầu.

- **Tích hợp:**  
  - Sử dụng `ProjectManagementDatabase` để kiểm tra mã dự án.

### **Sơ đồ UML biểu đồ con Timecard Management System:**
![diagram](https://www.planttext.com/api/plantuml/png/Z99DJiCm48NtEONL5KZa0bcWIY04Yqe8a5WFpb2i-a_ZSQK8zMGiE19NmBMSn9IYabKyyzxxh9TyVNmk0mDnDBhn83UmHh5uKWObK2zMODF0e6NnE0H6in3lZH1IGmXYLDquCdcyVv8KQTnS0yFPUTb4tmFZkChZNVChxCfP9gSrqXIv1Qr-MBcyT9DhP8JuOXIV41wXFg1tGR6ZOQ86sFw7kCOPXyPhDo3U9PsoV24y3FT8ogLpgWB_W1TaAzvSfF3iQ8F9yAeTS5aSv1Iq12sZJkVRsJVNUgJGjhsSeTtKQpYjhlhfSZEr9t__Mbs5v2AGG7BjgE8ExXJIC8NlcYNQVlzFVWC00F__0m00)

---

## **2. Hệ thống xử lý bảng lương (Payroll Processing System)**

### **Mục tiêu:**  
- Tự động tính toán lương dựa trên bảng chấm công và thông tin nhân viên.
- Tạo phiếu lương, gửi dữ liệu thanh toán đến ngân hàng.

### **Thành phần chính:**  
- **PayrollController:**  
  - Thu thập bảng chấm công từ `TimecardRepository` và thông tin nhân viên từ `EmployeeRepository`.  
  - Tính toán lương dựa trên loại nhân viên (*Hourly, Salaried, Commissioned*).  
  - Tạo phiếu lương và gửi đến `PaycheckRepository`.

- **PaycheckRepository:**  
  - Lưu trữ phiếu lương.  
  - Cung cấp dữ liệu phiếu lương cho các báo cáo hoặc xử lý thanh toán.

- **Tích hợp:**  
  - Gửi yêu cầu thanh toán đến ngân hàng thông qua `IBankSystem`.

### **Sơ đồ UML biểu đồ con Payroll Processing System:**
![diagram](https://www.planttext.com/api/plantuml/png/T59BJiCm4Dtd5AEkYaGku4LL2LYmYsWlC7A74DMVQ3n1iggUZ0L7uWeuaN60DDbavCpxEbyVd_iWo39OK_MepzWIR1gCx8s1Xhsc43hNmY468Rk1ImMW3OO0UUd1EndVnDEtyT5ez61Gw806EMx9ziP78WLFURe7wInfv9E2OvxkChebHvp0YL-_aJxVW8-hr-gtasdpXNeVEl4SYvM0xpDHdmTL4BEcBEIUaxVEoOfMLgW1hH-SA7Wr7YMV9Q66kFE9uJ4bMGasscNP_XFuoLW47DeKFGYdQvZvZx7_UxgilH0lRwgkTxTQKrDVOHLIl4tDf31QrfTBKwea3zMrsfCxZJ_RDm000F__0m00)

---

## **3. Hệ thống quản lý nhân sự (Employee Management System)**

### **Mục tiêu:**  
- Cho phép quản trị viên quản lý thông tin nhân viên, như: thêm, sửa, xóa thông tin nhân viên.

### **Thành phần chính:**  
- **EmployeeForm:**  
  - Giao diện cho quản trị viên thêm, sửa, và xóa nhân viên.  
  - Hiển thị các thông tin như: *tên, mã nhân viên, phương thức thanh toán*.

- **EmployeeController:**  
  - Điều khiển xử lý logic nhập liệu.  
  - Kiểm tra dữ liệu hợp lệ trước khi lưu vào hệ thống.

- **EmployeeRepository:**  
  - Lưu trữ thông tin nhân viên.  
  - Hỗ trợ tìm kiếm nhân viên theo mã hoặc tên.

- **Tích hợp:**  
  - Cung cấp dữ liệu nhân viên cho hệ thống xử lý bảng lương.

### **Sơ đồ UML biểu đồ con Employee Management System:**
![diagram](https://www.planttext.com/api/plantuml/png/Z99DQiD038NtFeN8Abtu0bwKGD925jcq9n0UuGoTFqPAm9ISh8iUgLUeRSRsr74XsitJapuXpS_Nzuu5eroiAGBM7zWGR5viCBubWXEwJh3a1DvR5h8R-2m0QeFCCBfUVRI3t4ST2ON6rFOfoPUWrcH5XXRohRW3xBsJw8sXE66kQ7JUyO22MqgFQgeSEOpNcR9kM-6-KV2inSTsuZxGg8-6vCvrL1Le9_-m4g64XJsf3cs7OOdQDKaAsFQ7EP6SlVgJMwxxG8BQyBpUbSMMvVCyImLsE3ndtk7AkIih7YQbYBNa5Tdw5jsv4xlcjs97JlK_xnS00F__0m00)

---

## **4. Hệ thống ObjectStore Support**

### **Mục tiêu:**  
- Quản lý và cung cấp các thao tác liên quan đến OODBMS (Object-Oriented Database Management System) cho hệ thống Payroll.

### **Thành phần chính:**  
- **PayrollDBManager:**  
  - Lớp quản lý cơ sở dữ liệu, thực hiện các thao tác lưu trữ và truy xuất dữ liệu như nhân viên, bảng chấm công và phiếu lương.  
  - Xử lý các giao dịch trong cơ sở dữ liệu và đảm bảo tính toàn vẹn của dữ liệu trong hệ thống.

- **Tích hợp:**  
  - Quản lý các giao dịch lưu trữ, truy xuất dữ liệu và bảo mật thông tin trong hệ thống OODBMS.

### **Sơ đồ UML biểu đồ con ObjectStore Support:**
![diagram](https://www.planttext.com/api/plantuml/png/Z5BBQiCm4BpxAvQS7AX_m8SIIYuzb0OIw7aZRntLUY6j2gRaothe9_KNgXH93Iw5whIxC-pCIFfy_zW4HizHgyQXc70aM3qUNqZmdgqds4VdhESLl3K0Gc48iCFPMwMsTmze4jz_GvSJy9KEKfD0FxISYnxAQ9rf8t5baNRApaJtYISDtu33UKTUsjHlaMbzjJhfYXE9gNMvwA6C2kr8epG7ZoQWO6bDMm1XjPQyHCvD3LKSvJ0Td6pquSdwYPALPsMHCx1mc0MY6r9JSrtxNaeLqrKAjOs6_wCYFAMcNaHT_Ej9kkxs9r8FCL3uYrRjPDgvsP0PBX_Y2m00__y30000)

---

## **5. Hệ thống Bảo Mật (Security System)**

### **Mục tiêu:**  
- Cung cấp các dịch vụ bảo mật và quản lý quyền truy cập vào hệ thống Payroll.

### **Thành phần chính:**  
- **Secure Interfaces:**  
  - Cung cấp giao diện bảo mật cho các dịch vụ và hệ thống con trong Payroll.  
  - Quản lý và xác thực quyền truy cập của người dùng.

- **Security Manager Subsystem:**  
  - Thực hiện các cơ chế bảo mật cốt lõi cho toàn bộ hệ thống Payroll.  
  - Kiểm soát quyền truy cập và bảo vệ dữ liệu quan trọng.

### **Sơ đồ UML biểu đồ con Security System:**
![diagram](https://www.planttext.com/api/plantuml/png/b991JWCn34NtEONLrI1rBX2XgYoHGAg4UW0hDTEeCvdATeG0zMGiE19N80aPDBGi88iilktlPoSVR-zhKMIDGs-Ew0xO4ImUo4Ns-ho0LmFWUXI1ej5jKE97T2Gbb0z6tLDGxr1fAyHDJ5V0WIo8iW_T4ex9u6datQHSpKf7zY-bxiObLodL5hAm12OP8pkQrvtCJwI4UOyXOVCtaTkJE_pHBf-ECUZ_s-UashE5yw6hV3vvbNdiIIpSUT7hhy1gOY7TLgjcuXFIJVLfVbjbORfudxPTNMp8PawPicU1d5pciJ0KISp9h2diyh_u1000__y30000)

---

## **6. Hệ thống Giao Diện Người Dùng (GUI Framework)**

### **Mục tiêu:**  
- Quản lý giao diện người dùng và các tương tác với các hệ thống con trong Payroll.

### **Thành phần chính:**  
- **GUI Framework:**  
  - Quản lý các cửa sổ, xử lý giao diện người dùng cho các chức năng như nhập liệu bảng chấm công, xử lý lương, và quản lý nhân viên.

- **Tích hợp:**  
  - Liên kết các lớp giao diện với các hệ thống con và cung cấp các lớp bảo mật khi cần thiết.

### **Sơ đồ UML biểu đồ con GUI Framework:**
![diagram](https://www.planttext.com/api/plantuml/png/V95D2i9038NtSuhWgYvwWLc88FYp4qHS3zEWGwUPCaaf8fxCXKVo2hQs5YpgR8PyUP3taiVjFcSnKQh2gzBOt1mH9glz1fRH55Y7c4_WeW2iDypGD0R-mkqB9TB1KHRgf7vz6hfosWki3un_5LMP6VajkQh1GGVxsIc84uyQMAAZOyzi846I3mh0fr0lkauoKen6xD1MqSbvRIZp68USzeGstpF6BSR2CRj0d5HDhQ6bxom-sFn_aeyjfkdi7Kf3OQWv07_JZ5tfpW-hgveZPUtzdW000F__0m00)

---

## **7. Hệ thống Quản Lý In Ấn (PrintService Subsystem)**

### **Mục tiêu:**  
- Cung cấp các tiện ích để in các báo cáo và phiếu lương.

### **Thành phần chính:**  
- **PrintService Subsystem:**  
  - Cung cấp các chức năng in ấn cho các tài liệu, bao gồm phiếu lương, bảng chấm công, và các báo cáo tài chính.

### **Sơ đồ UML biểu đồ con PrintService Subsystem:**
![diagram](https://www.planttext.com/api/plantuml/png/R55B3e8m4Dtt51DNiE02NHWIFG1HBz2K4GdGadOmCOQJkV18Na6AfNnYL-sRr_TfFwztQaaOwfgQjK9Mea3OPQPKT4PpBoNkuCa0P2siXIK-mcwr3ZngsJMeAChzXiC4nPvNe48Z23Fna3UKrGbRRIXg_P73D70NUXPC9nrlc02LL2C7IuDnuJ6f5Osk2nJ08Xr-WsX3Y6V6nSb5Az5DWYbOI20QtJcjQwq5UMpeaQ4fTJuq7rfkIlkoGNZraacodrjow2pQVvGGWmTPotgMeihTxtq1003__mC0)

---

## **Sơ đồ hệ thống con**
Dưới đây là sơ đồ UML thể hiện các hệ thống con và mối quan hệ phụ thuộc giữa chúng.

![diagram](https://www.planttext.com/api/plantuml/png/X5RDSjiW4BxhAPXSsXxy0ZvqqjPDaqEddigPd0dQsDG8643sg9ayMGzzfBv2GGA4a6Jh8i_-V7pxxIxolpz_RxN1oZGrAoGcHxm7TBF5hHACeRBL1keRz5eK2Br3Ere3mQf2tp6tSJLmuqEicp2iTGov4wgsQQXxR1oeuDbWWzz_y9v6LjX0S7Ncjs82zaLmu_Y0Yf0dpEWarJswUQwfkORu4wJGr0ZLHaIDJrEqFLo5yW0hT12Dqaz27Q7osGGpqZ3Bydvm3J0prQrM7-Sehf6sRz38LeoNCttN4gjD15xvlAw5eRDR9GXeJVa-x-0KvJKlfyGCgpOHYOEoPfj93a2EkLB1lY3wACsBlWJrjPPCj01HT8vhy3ybRdUjX0jaEw1fVLwxdEEwOwSTRkTQp8sarkW5Z8tL289fK3v6BIzF21aj3r5WgmYkR7D6vXcTBcnE21djewlu6kP26oSCRHkdK3F4KWb7yjUTKBcOQ2nJcZsQ_4RR5-MoCRt-Fvv_0J6bMoHKDb8APVAPttpkUwCkNmgJeKtdQi2ujip6-_HIylnCzibXA7LVN0caKTIq-KHrTdXmz-yBjWiV2yEDETW9fCHEmgDLAXRd74BHt_29k0iY7u9mK2vKHoP9wGP0OMvoc0aZLscEsdLFX-Z4aQrRBm6Ie6fgBpF1lHpV7X_GdR9NmzdUkP6xjKPZ92uay2VAAt6El0aJ6X9RKdvl7SRZ8CvkwAoIIqBTOrwnNAZjG7Z86z5pXVh3XaMeg9OCjtEn-N7BscmLvQO4TQ84XWL8Z96gTCQD84qzKr-m3rg0IQNmfXqrB5d_qJcETuHPzyTffC2jfYxUYblxxN9_I_u3003__mC0)

---

## **Tương tác giữa các hệ thống con:**

### **1. Timecard Management System ↔ Payroll Processing System:**
- **TimecardController** nhận dữ liệu từ **TimecardForm**, xử lý và gửi đến **PayrollController** để tính toán và tạo phiếu lương.
- **TimecardController** tương tác với **TimecardRepository** để lưu trữ và truy xuất bảng chấm công.

### **2. Payroll Processing System ↔ Employee Management System:**
- **PayrollController** lấy dữ liệu từ **EmployeeRepository** (như loại lương, thông tin cá nhân) để tính toán lương.
- **EmployeeController** và **EmployeeForm** quản lý thông tin nhân viên, tương tác với **EmployeeRepository** để lưu trữ và truy xuất dữ liệu.

### **3. Payroll Processing System ↔ ObjectStore Support:**
- **PayrollController** và **PayrollDBManager** lưu trữ và truy xuất dữ liệu. **PayrollDBManager** lưu bảng chấm công và phiếu lương vào **TimecardRepository** và **PaycheckRepository**.

### **4. Security System ↔ Payroll System:**
- **SecureInterfaces** xác thực người dùng và kiểm tra quyền truy cập qua **SecurityManager**. 
- **SecurityManager** xác thực quyền truy cập vào các hệ thống như **TimecardForm**, **PayrollController**, và **EmployeeController**.

### **5. GUI Framework ↔ Các Hệ Thống Con Khác:**
- **GUIFramework** quản lý giao diện người dùng và các cửa sổ (**Window**). **SecurityHandler** kiểm tra quyền truy cập người dùng vào các cửa sổ và hệ thống như **TimecardForm**, **EmployeeForm**, **PaycheckForm**.

### **6. PrintService ↔ Payroll Processing System:**
- **PrintService** in các báo cáo phiếu lương và tài liệu khác, tạo và in tài liệu từ **PayrollController** và **PaycheckRepository**.

---

## **Mối quan hệ tổng thể:**
- **Timecard Management System** cung cấp dữ liệu bảng chấm công cho **Payroll Processing System** để tính toán lương.
- **Employee Management System** cung cấp dữ liệu nhân viên cho **Payroll Processing System** để tính toán lương.
- **ObjectStore Support** lưu trữ dữ liệu bảng chấm công và phiếu lương.
- **Security System** kiểm tra và quản lý quyền truy cập của người dùng vào các hệ thống con.
- **GUI Framework** đảm bảo giao diện người dùng và bảo mật giữa các hệ thống con.
- **PrintService** in các báo cáo phiếu lương và tài liệu từ **Payroll Processing System**.
