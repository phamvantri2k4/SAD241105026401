**PHÂN TÍCH KIẾN TRÚC, CƠ CHẾ, CA SỬ DỤNG**
# Lab 1: Phân Tích Kiến Trúc, Cơ Chế, Ca Sử Dụng của Payroll System

## Mục đích
Phân tích kiến trúc và các ca sử dụng của hệ thống "Payroll System".

## Thực hiện
1. **Phân tích yêu cầu** để đề xuất kiến trúc phù hợp cho bài toán, giải thích.
2. **Phân tích yêu cầu** để đề xuất các cơ chế (phân tích) cần giải quyết trong bài toán.
3. **Phân tích 02 ca sử dụng**:
   - Select Payment
   - Maintain Timecard

---

## 1. Phân Tích Kiến Trúc

### Đề xuất kiến trúc
Kiến trúc phù hợp là kiến trúc **Client-Server dựa trên mô hình phân tán**, đáp ứng các yêu cầu:
- **Tích hợp cơ sở dữ liệu**: Giao tiếp với cơ sở dữ liệu cũ mà không cập nhật nó.
- **Giao diện desktop**: Tương thích với hệ điều hành Windows, đáp ứng cho các thao tác của nhân viên.
- **Bảo mật cao**: Kiểm soát quyền truy cập của nhân viên, giới hạn chỉ chỉnh sửa thông tin cá nhân.

### Biểu đồ Package mô tả kiến trúc

- **Client Application**: Giao diện trên máy tính Windows để nhân viên và quản trị viên tương tác với hệ thống.
- **Application Server**: Xử lý các yêu cầu từ client, bao gồm chấm công, tính lương và truy xuất cơ sở dữ liệu cũ.
- **Database Server**: Lưu trữ thông tin về nhân viên và tương tác với Project Management Database thông qua các interface SQL.


