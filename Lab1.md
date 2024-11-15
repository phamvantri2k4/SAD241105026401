# Phân Tích Kiến Trúc và Ca Sử Dụng Hệ Thống "Payroll System"

## 1. Phân Tích Kiến Trúc

### Đề xuất kiến trúc

Hệ thống Payroll sẽ sử dụng kiến trúc **Client-Server** với ba lớp chính: **Client**, **Application Server**, và **Database Server**.

- **Client**: Đây là giao diện người dùng (Windows-based desktop interface) cho phép nhân viên nhập liệu, xem báo cáo và thay đổi các thông tin cá nhân. Các yêu cầu từ client sẽ được gửi đến application server để xử lý.
  
- **Application Server**: Lớp này sẽ xử lý các nghiệp vụ như tính toán lương, lưu trữ thông tin nhân viên, báo cáo, và các tính toán liên quan đến thời gian làm việc và hoa hồng. Hệ thống này sẽ giao tiếp với cơ sở dữ liệu và gửi các yêu cầu thanh toán đến các phương thức thanh toán.

- **Database Server**: Chứa các thông tin về nhân viên, lịch sử thanh toán, thông tin thời gian làm việc và các dữ liệu khác. Hệ thống sẽ truy vấn dữ liệu từ cơ sở dữ liệu **Project Management Database** (DB2), nhưng không thực hiện bất kỳ thao tác cập nhật nào.

### Lý do lựa chọn kiến trúc

Kiến trúc Client-Server giúp tách biệt các vai trò, dễ dàng bảo trì và mở rộng. Dữ liệu nhạy cảm về nhân viên được bảo vệ trong lớp riêng biệt, giúp giảm thiểu rủi ro bảo mật. Hệ thống có thể hoạt động trên nhiều máy tính cá nhân trong công ty mà không cần thay đổi cơ sở hạ tầng.

### Biểu đồ Package
![Diagram](https://www.planttext.com/api/plantuml/png/V5ExJWCn4Epz5QjKKAJX0r0WIO44KXJeeYiMtt8o-2NRLvmGNqR19_4B-7Ava8ljkFJCpixEsh_VFmiVq8LMIMQHVs13CDjWvuoKyDpvG6e6dmpYES9BAKW7UCIEt0ZsPxTMLfgE21vq8FU6dAf_S4lMk925NeGYZgwEe6qJoXURjh-pLWgEGHYTyJ1wNwBahTopSfsUK4Sn5UUe9hNz3MoSuUIzq4tYFzx1MZT25yojCE0hUhgKpiZ9-UgnAfrcIzousfyYphmJ3oU3x6lXQdL_SprwY-voIu7v_BQGLBgcWPnENzxQK96DccMx3WMPVB8YP_93OhdTJSSyHfZEKkvVe2QQR9UyoWDr-Y2YvDd5GV3oDXUaw_w7_W400F__0m00)

## 2. Cơ Chế Phân Tích

Các cơ chế chính cần giải quyết trong hệ thống này bao gồm:

- **Xác thực và phân quyền**: Đảm bảo chỉ nhân viên có quyền truy cập vào thời gian làm việc của chính họ và quản trị viên có thể quản lý thông tin của tất cả nhân viên.
  
- **Tính toán lương**: Hệ thống cần tính toán chính xác số tiền lương cho các nhân viên, bao gồm lương theo giờ, lương cố định, và lương cố định cộng với hoa hồng.

- **Quản lý thời gian làm việc và đơn hàng**: Cần có cơ chế lưu trữ và xử lý chính xác thông tin về thời gian làm việc của nhân viên và các đơn hàng đã thực hiện.

- **Xử lý thanh toán tự động**: Hệ thống cần tự động tính toán và thực hiện các khoản thanh toán cho nhân viên vào ngày quy định mà không cần sự can thiệp thủ công.

### Biểu đồ 
![Diagram](https://www.planttext.com/api/plantuml/png/X9DDJiCm48NtFiMe-ru1DGeL6v0gMbQeYy4PfHR-a-qiBDIJiU18N06Rj914JkFjDs_UcnVb-_DhumEwq2d9BF9tR0bMEupEI0dxw0Ef5NmmIEyFrrAG3l28aTmLvlVwuib1rOLJme9Z44OV_sd5ENaFjT4XRU_1cOrNLzRAYxAm_vghHiaxsKyz4J-X5buTHtCg9zmvaos5RWVmcQnn0Hv8anj4d2Qvnu1lwAaG8oFOQkwYdPxODI8LOzfsxBbLLff81B_IVJ0kUGpuGIZYw9e2l-GgTWlhzLsvruMgUk5SJOMAUi6DCsOrCwUnOfFBDcN5ZVuctsJPeJG_i__CDgIR_Ely0000__y30000)

## 3. Phân Tích Ca Sử Dụng "Select Payment"

### Các lớp phân tích

- **Employee**: Nhân viên yêu cầu thanh toán và cung cấp thông tin về phương thức thanh toán và ngày thanh toán.
- **PayrollSystem**: Hệ thống tính toán số tiền lương và gửi thông tin thanh toán đến **PaymentMethod**.
- **PaymentMethod**: Lớp này xác định phương thức thanh toán cho nhân viên, bao gồm chuyển khoản ngân hàng, gửi qua bưu điện, hoặc nhận trực tiếp tại văn phòng.

### Biểu đồ Sequence



## 4. Phân Tích Ca Sử Dụng "Maintain Timecard"

### Các lớp phân tích

- **Employee**: Nhân viên cung cấp thông tin về thời gian làm việc của họ và các dự án liên quan, nhập số giờ đã làm cho mỗi ngày và mỗi charge number (mã dự án).
- **Timecard**: Lớp này lưu trữ các bản ghi thời gian làm việc của nhân viên. Mỗi bản ghi bao gồm thông tin về ngày làm việc, số giờ làm việc, và charge number (mã dự án).
- **PayrollSystem**: Xử lý và lưu trữ thông tin thời gian làm việc vào hệ thống. Sau khi nhân viên nhập thời gian làm việc, hệ thống sẽ tính toán tổng số giờ, xác định việc trả lương theo kiểu gì (theo giờ, lương cố định), và lưu trữ thông tin này để thanh toán vào các ngày thanh toán quy định.

### Biểu đồ Sequence

## 5. Hợp Nhất Kết Quả Phân Tích

### Tổng quan về các ca sử dụng

Hệ thống "Payroll System" được phân tích thông qua hai ca sử dụng chính: **Select Payment** và **Maintain Timecard**. Mỗi ca sử dụng có mục đích và hành vi riêng biệt, nhưng đều liên quan mật thiết đến các hoạt động xử lý lương cho nhân viên.

1. **Ca sử dụng "Select Payment"**:
   - Mục đích: Xử lý yêu cầu thanh toán của nhân viên và xác định phương thức thanh toán (chuyển khoản ngân hàng, gửi qua bưu điện, hoặc nhận trực tiếp tại văn phòng).
   - Các lớp phân tích liên quan: **Employee**, **PayrollSystem**, **PaymentMethod**.
   - Hành vi chính: Nhân viên yêu cầu thanh toán, hệ thống tính toán và gửi yêu cầu thanh toán tới phương thức thanh toán đã chọn.

2. **Ca sử dụng "Maintain Timecard"**:
   - Mục đích: Xử lý và lưu trữ thông tin về thời gian làm việc của nhân viên và các dự án họ tham gia. Hệ thống tính toán số tiền lương dựa trên thời gian làm việc và phương thức thanh toán.
   - Các lớp phân tích liên quan: **Employee**, **Timecard**, **PayrollSystem**.
   - Hành vi chính: Nhân viên nhập thời gian làm việc, hệ thống lưu trữ thời gian và tính toán lương theo giờ hoặc lương cố định.

### Hợp nhất các kết quả phân tích

#### Các lớp phân tích chung

- **Employee**: Là người yêu cầu thanh toán và cung cấp thông tin về thời gian làm việc và các dự án tham gia.
- **PayrollSystem**: Lớp trung gian xử lý các yêu cầu thanh toán và tính toán lương cho nhân viên. Đối với "Maintain Timecard", hệ thống tính toán lương từ số giờ làm việc và lưu trữ thông tin. Đối với "Select Payment", hệ thống gửi yêu cầu thanh toán tới phương thức thanh toán đã được nhân viên chọn.
- **PaymentMethod**: Xác định phương thức thanh toán cho nhân viên, thực hiện việc thanh toán dựa trên yêu cầu từ PayrollSystem.

#### Biểu đồ Sequence tổng hợp

