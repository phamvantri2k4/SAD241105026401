# **Thiết kế các ca sử dụng hệ thống Payroll System**

## **I. Giới thiệu**
Hệ thống **Payroll System** được thiết kế nhằm tự động hóa quy trình quản lý bảng chấm công, tính toán lương, xử lý thanh toán và tích hợp với các hệ thống liên quan như ngân hàng và cơ sở dữ liệu dự án. Mục tiêu của hệ thống là nâng cao hiệu quả quản lý và giảm thiểu sai sót trong việc tính toán và xử lý dữ liệu.

---

## **II. Các ca sử dụng**

### **1. Maintain Timecard (Quản lý bảng chấm công)**

**Mô tả:**  
Nhân viên nhập và chỉnh sửa bảng chấm công, gồm thông tin giờ làm việc và mã dự án, sau đó lưu vào cơ sở dữ liệu.

**Thiết kế:**  
- **Actor:** Employee (Nhân viên)
- **Mô hình tương tác:**
  - **Giao diện:** Nhân viên tương tác với `TimecardForm` để nhập giờ làm việc và mã dự án.
  - **Điều khiển:** `TimecardController` xử lý dữ liệu và kiểm tra tính hợp lệ của mã dự án từ `ProjectManagementDatabase`.
  - **Lưu trữ:** `TimecardRepository` lưu thông tin vào cơ sở dữ liệu.
  - **Liên kết:** `ProjectManagementDatabase` kiểm tra mã dự án để đảm bảo tính hợp lệ.

**Biểu đồ tuần tự:**
![diagram](https://www.planttext.com/api/plantuml/png/X98zQiCm7CLtdU9T81VmK0BzXBIbb0vTPLauRlNXodB0SuSEFKCX9dGCRQ5JF6GGz1uwGQzGcP34mPWkGlfBx_UU_j9linuNbXfRIa4eizhWLEP2LvoJM9SgeQR2NIOveoOvqqOIffKrMkoAnvkru8PmPJExFtxBSrra0LbjTswCVk3CNb55Kov3yOHQ6jE24x9rnUZem2_2zTIlbZdIp3Tl46ukCGlJ5uQPcqEw1HBVVC7LYdHrNSu-OeHptoopLl81qM9An7wrK2bOi7cNOEvRfQIlR7c3yIDC0kjPmXfw66bGWj50m8bVhIsUof0AZplgGA9-goDS_doMtGkI_g51ytjNCwYsuGeYSFwntJpGHPjImKvzynh6je68NQt9cAia_Ai_0000__y30000)

**Giải thích thiết kế:**
- **Tách biệt giữa giao diện và xử lý logic:** `TimecardController` đảm nhận xử lý logic nhập liệu, tách biệt hoàn toàn với giao diện (`TimecardForm`) và việc lưu trữ dữ liệu (`TimecardRepository`). Điều này giúp dễ dàng bảo trì và phát triển hệ thống.
- **Kiểm tra tính hợp lệ:** `TimecardController` kiểm tra mã dự án trước khi lưu vào cơ sở dữ liệu để đảm bảo tính hợp lệ của thông tin nhập vào, tránh các lỗi nhập dữ liệu.

---

### **2. Generate Paycheck (Tạo phiếu lương)**

**Mô tả:**  
Hệ thống tự động tính toán lương dựa trên bảng chấm công và tạo phiếu lương cho nhân viên.

**Thiết kế:**  
- **Actor:** System (Hệ thống)
- **Mô hình tương tác:**
  - **Dữ liệu:** `PayrollController` lấy dữ liệu bảng chấm công từ `TimecardRepository`.
  - **Tính toán:** Tính toán lương dựa trên thông tin nhân viên.
  - **Lưu trữ:** Lưu phiếu lương vào `PaycheckRepository`.

**Biểu đồ tuần tự:**
![diagram](https://www.planttext.com/api/plantuml/png/T94nJiCm58Ptd-A_G2-G0LMmC30WwC0Q7AksSEpAUKRooCJC3OWGOaBjmEGC7O9o3v-0A-0gGgf8klZ9-j_tl__PFzr-sL3foDUQbPoimsreIDICMqFEQboN8HTzCLwrS4mOKXImKhNWfQjknCOsAfFXJya8bu8_72biTCNYR6fOu3p5BU7x9SKF3qgnjTX8bUBUGm-xeJLhDg4ELjC81QvIV0-eKhU5LgbxzhXFySsimMLMQl3-AzjDIIpciwrSnl6OkgTZq_ayqyLpdc7dvxRvrtXg_5tVSfWS_TCSw1E3nzSjS6dxLmEI-PHiAKoLl_KN003__mC0)

**Giải thích thiết kế:**
- **Tính toán chính xác:** Quy trình tính toán lương được thực hiện tập trung trong `PayrollController`, giúp giảm thiểu sai sót và dễ dàng kiểm tra, bảo trì.
- **Tái sử dụng:** Phiếu lương được lưu trữ trong `PaycheckRepository`, giúp hệ thống có thể tích hợp với các hệ thống khác như ngân hàng hay bộ phận kế toán.

---

### **3. Process Purchase Order (Xử lý đơn mua hàng)**

**Mô tả:**  
Hệ thống xử lý các yêu cầu mua hàng từ nhân viên, kiểm tra tính hợp lệ và gửi đến bộ phận tài chính.

**Thiết kế:**  
- **Actor:** Employee (Nhân viên)
- **Mô hình tương tác:**
  - **Giao diện:** Nhân viên gửi yêu cầu qua `PurchaseOrderForm`.
  - **Điều khiển:** `PurchaseOrderController` kiểm tra tính hợp lệ và lưu vào `PurchaseOrderRepository`.

**Biểu đồ tuần tự:**
![diagram](https://www.planttext.com/api/plantuml/png/Z94z2i9048NxESLSm0jOY23-589YPRjk5XFSxEfajqXjOU4b50j14AspXKN0U-m9l881aQX1iPsPzxqtCpTtQIQ6aR6n1CQD9cp7SwbJ8M2YhGeOfJYqn4EMY045WZgQOk1Q6TBolTDw5AKW4Cf4vaCu4dETH8L32l3qm5gZIgzZrxjZX6b-iCXzjhSOMuPXlb5Jg4nN46MC9oZmxeGoycvbNw3mHLK1bi7hsB-UlpFAGQpzIZNEjnnLwBEZGba0_qxok4wls6Ifq8JUhN7ciul1XVNP3ff21SKVxm000F__0m00)

**Giải thích thiết kế:**
- **Tích hợp dễ dàng:** Yêu cầu mua hàng có thể được xử lý và tích hợp thêm với các hệ thống tài chính khác, chẳng hạn như hệ thống mua sắm hoặc kế toán.
- **Kiểm tra dữ liệu:** Trước khi lưu trữ yêu cầu mua hàng, `PurchaseOrderController` đảm bảo rằng thông tin hợp lệ và không có lỗi nhập liệu.

---

### **4. Bank System Integration (Tích hợp ngân hàng)**

**Mô tả:**  
Hệ thống gửi thông tin phiếu lương đến ngân hàng để thực hiện thanh toán.

**Thiết kế:**  
- **Actor:** System (Hệ thống)
- **Mô hình tương tác:**
  - `PayrollController` lấy thông tin phiếu lương từ `PaycheckRepository`.
  - Gửi yêu cầu thanh toán qua `IBankSystem`.

**Biểu đồ tuần tự:**
![diagram](https://www.planttext.com/api/plantuml/png/X951IaCn48RtESL_WLwW2ocwKD65g1U8UQ49BqtQl8cGfRXmuIcAY228hbyMNHHwZvp0AvX7AnRV4rV3CF_ytp_CPrfD6kAUmimmBiXvNCM6v8m9PyaxWmiUIp57szP8pwGbJR4R22L5VIddhj5bCx8R5sp5VSJf8RVrpeXjAqO7VQynZdDwquZhrm2HsvS0Kjmga5ilBUlfToQ_k6ESv_OvOgvqRbS1PlEnMTefwoin6avnxNFxXDkSxb3bz0wZSte8m_ozs_w9lwVy2tnM0XCMeSDFDNST_b6eOV8tzAIakxS5LRIeVnpOHDggFF8B003__mC0)

**Giải thích thiết kế:**
- **Đảm bảo an toàn:** Tích hợp với `IBankSystem` giúp hệ thống hoạt động đồng bộ với ngân hàng, đảm bảo các giao dịch thanh toán được xử lý chính xác.
- **Khả năng mở rộng:** Hệ thống có thể dễ dàng mở rộng để thêm các ngân hàng khác thông qua giao diện `IBankSystem`.

---

### **5. Manage Employee Details (Quản lý thông tin nhân viên)**

**Mô tả:**  
Hệ thống cho phép quản trị viên thêm, sửa, hoặc xóa thông tin nhân viên.

**Thiết kế:**  
- **Actor:** Admin (Quản trị viên)
- **Mô hình tương tác:**
  - **Giao diện:** Quản trị viên tương tác với `EmployeeForm` để nhập thông tin nhân viên.
  - **Điều khiển:** `EmployeeController` kiểm tra và xử lý dữ liệu.
  - **Lưu trữ:** `EmployeeRepository` lưu thông tin.

**Biểu đồ tuần tự:**
![diagram](https://www.planttext.com/api/plantuml/png/X90x2W8n48RxESLSm0ji8OhuACJ2odOVmGra9qlC2bjRM7WABGNHmieK5W7laHDu1QEYko9YESCt__SdLtDkpNIeT94926Cj5RQJZ1D4ig0aL2Lsirp8ah6UL1d4ahIIuhtiF6V1533IN5VucELondrU2V18n4Rp8ol0KUfEknnrQeyqHUqHIks6SCxjbg3ErcyhPO1zPtOS4sVsABWpomA-gVfjLIh0uULGrDpmpM3ZXtPYrx7lwjiJ2X_pn_fyxS0NN90tEhDwUIExbj1YbDn__mO00F__0m00)

**Giải thích thiết kế:**

- **Tính rõ ràng:** `EmployeeController` đảm nhận tất cả logic xử lý thông tin nhân viên, giúp hệ thống dễ bảo trì và phát triển thêm tính năng.
  
- **Quản lý dữ liệu:** `EmployeeRepository` đảm bảo rằng tất cả dữ liệu nhân viên được lưu trữ an toàn và hiệu quả.

---

### **6. View Project Details (Xem thông tin dự án)**

**Mô tả:**  
Nhân viên hoặc quản lý xem thông tin chi tiết dự án, bao gồm mã dự án, tiến độ và ngân sách.

**Actors:**

- **Primary Actor:** Employee hoặc HR Manager

**Mô hình tương tác:**
- `ProjectManagementDatabase`: Truy vấn thông tin dự án

**Biểu đồ tuần tự:**

![diagram](https://www.planttext.com/api/plantuml/png/V90z2i9044RxFSLS81T88Ib4R0IB2BQJpPADc0bi9a9AiVGKGJo0O9KjKkGaUmAlOBPGWW6hWOzvRtvUjeygHiDrSHGekJImgvGHILbJYgQ1hIaFIlAgD8LGn3b_emqIPgeOmoKo9bWf8JmBmM9AXR1N1QH86ggXbHfIPnymj2GcJHDchWqXDdK39zVT2LWFJyg0Svg9vYG4lxl4ndMtKMNF_qoVbVmv8QnpPoz-ihFNAILrFbRNzImYHQd_u1i00F__0m00)

**Giải thích thiết kế:**

- **Dữ liệu chính xác:** Tất cả thông tin dự án được truy xuất trực tiếp từ `ProjectManagementDatabase`, đảm bảo tính chính xác và cập nhật.
  
- **Giao diện đơn giản:** `ProjectForm` là giao diện đơn giản giúp người dùng nhanh chóng truy vấn và hiển thị thông tin về các dự án.

