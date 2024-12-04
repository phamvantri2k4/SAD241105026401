
# **Thiết kế các ca sử dụng hệ thống Payroll System**

## **I. Giới thiệu**
Hệ thống **Payroll System** được thiết kế nhằm tự động hóa quy trình quản lý bảng chấm công, tính toán lương, xử lý thanh toán và tích hợp với các hệ thống liên quan như ngân hàng và cơ sở dữ liệu dự án.

---
## **II. Class Diagram: Payroll System**

---
## **III. Các ca sử dụng**

### **1. Maintain Timecard (Duy trì bảng chấm công)**

**Mô tả:**  
Nhân viên nhập và chỉnh sửa bảng chấm công, gồm thông tin giờ làm việc và mã dự án, sau đó lưu vào cơ sở dữ liệu.

**Thiết kế:**  
- **Actor:** Employee (Nhân viên)  
- **Mô hình tương tác:**  
  - **Giao diện:** Nhân viên tương tác với `TimecardForm` để nhập giờ làm việc.  
  - **Điều khiển:** `TimecardController` kiểm tra và xử lý dữ liệu.  
  - **Lưu trữ:** `TimecardRepository` lưu thông tin vào cơ sở dữ liệu.  
  - **Liên kết:** `ProjectManagementDatabase` kiểm tra mã dự án.

**Biểu đồ tuần tự:**
![diagram](https://www.planttext.com/api/plantuml/png/X98zQiCm7CLtdU9T81VmK0BzXBIbb0vTPLauRlNXodB0SuSEFKCX9dGCRQ5JF6GGz1uwGQzGcP34mPWkGlfBx_UU_j9linuNbXfRIa4eizhWLEP2LvoJM9SgeQR2NIOveoOvqqOIffKrMkoAnvkru8PmPJExFtxBSrra0LbjTswCVk3CNb55Kov3yOHQ6jE24x9rnUZem2_2zTIlbZdIp3Tl46ukCGlJ5uQPcqEw1HBVVC7LYdHrNSu-OeHptoopLl81qM9An7wrK2bOi7cNOEvRfQIlR7c3yIDC0kjPmXfw66bGWj50m8bVhIsUof0AZplgGA9-goDS_doMtGkI_g51ytjNCwYsuGeYSFwntJpGHPjImKvzynh6je68NQt9cAia_Ai_0000__y30000)

**- Giải thích thiết kế:**

**Tính tách biệt: TimecardController tập trung xử lý logic nhập liệu, tách biệt khỏi giao diện và cơ sở dữ liệu.**

**Đảm bảo tính toàn vẹn: Kiểm tra mã dự án trước khi lưu giúp tránh lỗi nhập sai.**

## **2. Generate Paycheck (Tạo phiếu lương)**

**Mô tả:**  
Hệ thống tự động tính toán lương dựa trên bảng chấm công và tạo phiếu lương cho nhân viên.

**Thiết kế:**  
- **Actor:** System (Hệ thống)  
- **Mô hình tương tác:**  
  - **Dữ liệu:** `PayrollController` lấy dữ liệu bảng chấm công qua `TimecardRepository`.  
  - **Tính toán:** Tính toán lương dựa trên thông tin nhân viên.  
  - **Lưu trữ:** Lưu phiếu lương vào `PaycheckRepository`.

**Biểu đồ tuần tự:**

![diagram](https://www.planttext.com/api/plantuml/png/T94nJiCm58Ptd-A_G2-G0LMmC30WwC0Q7AksSEpAUKRooCJC3OWGOaBjmEGC7O9o3v-0A-0gGgf8klZ9-j_tl__PFzr-sL3foDUQbPoimsreIDICMqFEQboN8HTzCLwrS4mOKXImKhNWfQjknCOsAfFXJya8bu8_72biTCNYR6fOu3p5BU7x9SKF3qgnjTX8bUBUGm-xeJLhDg4ELjC81QvIV0-eKhU5LgbxzhXFySsimMLMQl3-AzjDIIpciwrSnl6OkgTZq_ayqyLpdc7dvxRvrtXg_5tVSfWS_TCSw1E3nzSjS6dxLmEI-PHiAKoLl_KN003__mC0)

**- Giải thích thiết kế:**

  **Tính chính xác: Logic tính toán lương tập trung tại PayrollController đảm bảo dễ bảo trì và kiểm tra.**
  
  **Tái sử dụng: PaycheckRepository có thể được tích hợp thêm với các hệ thống khác như ngân hàng.** 

## **3. Process Purchase Order (Xử lý đơn mua hàng)**

**Mô tả:**  
Hệ thống xử lý các yêu cầu mua hàng từ nhân viên, kiểm tra tính hợp lệ và gửi đến bộ phận tài chính.

**Thiết kế:**  
- **Actor:** Employee (Nhân viên)  
- **Mô hình tương tác:**  
  - **Giao diện:** Nhân viên gửi yêu cầu thông qua `PurchaseOrderForm`.  
  - **Điều khiển:** `PurchaseOrderController` kiểm tra tính hợp lệ và lưu vào `PurchaseOrderRepository`.

**Biểu đồ tuần tự:**

![diagram](https://www.planttext.com/api/plantuml/png/Z94z2i9048NxESLSm0jOY23-589YPRjk5XFSxEfajqXjOU4b50j14AspXKN0U-m9l881aQX1iPsPzxqtCpTtQIQ6aR6n1CQD9cp7SwbJ8M2YhGeOfJYqn4EMY045WZgQOk1Q6TBolTDw5AKW4Cf4vaCu4dETH8L32l3qm5gZIgzZrxjZX6b-iCXzjhSOMuPXlb5Jg4nN46MC9oZmxeGoycvbNw3mHLK1bi7hsB-UlpFAGQpzIZNEjnnLwBEZGba0_qxok4wls6Ifq8JUhN7ciul1XVNP3ff21SKVxm000F__0m00)

**- Giải thích thiết kế:**

  **Tích hợp dễ dàng: Yêu cầu mua hàng có thể được mở rộng xử lý qua các hệ thống tài chính khác.**
  
  **Kiểm tra dữ liệu: Đảm bảo yêu cầu hợp lệ trước khi lưu.**

## **4. Bank System Integration (Tích hợp ngân hàng)**

**Mô tả:**  
Hệ thống gửi thông tin phiếu lương đến ngân hàng để thực hiện thanh toán.

**Thiết kế:**  
- **Actor:** System (Hệ thống)  
- **Mô hình tương tác:**  
  - `PayrollController` lấy thông tin phiếu lương từ `PaycheckRepository`.
  - Gửi yêu cầu thanh toán qua `IBankSystem`.

**Biểu đồ tuần tự:**

![diagram](https://www.planttext.com/api/plantuml/png/X951IaCn48RtESL_WLwW2ocwKD65g1U8UQ49BqtQl8cGfRXmuIcAY228hbyMNHHwZvp0AvX7AnRV4rV3CF_ytp_CPrfD6kAUmimmBiXvNCM6v8m9PyaxWmiUIp57szP8pwGbJR4R22L5VIddhj5bCx8R5sp5VSJf8RVrpeXjAqO7VQynZdDwquZhrm2HsvS0Kjmga5ilBUlfToQ_k6ESv_OvOgvqRbS1PlEnMTefwoin6avnxNFxXDkSxb3bz0wZSte8m_ozs_w9lwVy2tnM0XCMeSDFDNST_b6eOV8tzAIakxS5LRIeVnpOHDggFF8B003__mC0)

**- Giải thích thiết kế:**

**Đảm bảo an toàn: Tích hợp với IBankSystem giúp hệ thống hoạt động đồng bộ với ngân hàng.**

**Khả năng mở rộng: Cho phép thêm các ngân hàng khác dễ dàng thông qua giao diện IBankSystem.**

## **5. Manage Employee Details (Quản lý thông tin nhân viên)**

**Mô tả:**  
Hệ thống cho phép quản trị viên thêm, sửa, hoặc xóa thông tin nhân viên.

**Thiết kế:**  
- **Actor:** Admin  
- **Mô hình tương tác:**  
  - **Giao diện:** Quản trị viên tương tác với `EmployeeForm`.  
  - **Điều khiển:** `EmployeeController` kiểm tra và xử lý dữ liệu.  
  - **Lưu trữ:** `EmployeeRepository` lưu thông tin.

**Biểu đồ tuần tự:**

![diagram](https://www.planttext.com/api/plantuml/png/X90x2W8n48RxESLSm0ji8OhuACJ2odOVmGra9qlC2bjRM7WABGNHmieK5W7laHDu1QEYko9YESCt__SdLtDkpNIeT94926Cj5RQJZ1D4ig0aL2Lsirp8ah6UL1d4ahIIuhtiF6V1533IN5VucELondrU2V18n4Rp8ol0KUfEknnrQeyqHUqHIks6SCxjbg3ErcyhPO1zPtOS4sVsABWpomA-gVfjLIh0uULGrDpmpM3ZXtPYrx7lwjiJ2X_pn_fyxS0NN90tEhDwUIExbj1YbDn__mO00F__0m00)

**-Giải thích thiết kế:**

**Tính rõ ràng: EmployeeController tập trung logic xử lý, giúp bảo trì dễ dàng.**

**Quản lý dữ liệu: EmployeeRepository đảm bảo lưu trữ dữ liệu an toàn và hiệu quả.**


