# admincode
# AdminCode – Minecraft Giftcode Plugin

AdminCode là plugin quản lý giftcode chuyên nghiệp dành cho các máy chủ Minecraft (1.20+).  
Hỗ trợ tạo mã, phát quà, chỉnh vật phẩm qua GUI, và chống sử dụng trùng bằng UUID + IP.

---

## Tính năng chính

### 1. Tạo giftcode dễ dàng
- `/admincode create <code>`
- Giftcode được lưu vĩnh viễn, không mất khi restart server.

### 2. Chỉnh sửa phần thưởng qua GUI
- `/admincode gui <code>`
- Kéo – thả vật phẩm trực tiếp trong giao diện.
- Vật phẩm được lưu bằng Base64 để đảm bảo độ chính xác tuyệt đối.

### 3. Lệnh cho người chơi
- `/code <code>` để nhận quà.
- Mỗi mã chỉ sử dụng **một lần** cho mỗi người chơi.
- Kiểm tra cả **UUID** và **địa chỉ IP** để ngăn abuse.

### 4. Hệ thống quản lý mã đầy đủ
- `/admincode list` – Danh sách mã
- `/admincode delete <mã>` – Xóa mã
- `/admincode reload` – Tải lại dữ liệu

### 5. Dễ tùy chỉnh
- Tất cả tin nhắn nằm trong `messages.yml`
- Dữ liệu giftcode lưu trong `codes.yml`

---

## Yêu cầu
- Spigot/Paper 1.20+
- Java 17+

---

## Cài đặt
1. Tải plugin từ trang phát hành.
2. Đưa file `.jar` vào thư mục `plugins/`.
3. Khởi động server.
4. Chỉnh sửa `messages.yml` và `config.yml` nếu cần.

---

## Bản quyền
Plugin được phát triển bởi **pnhuy08**  
Vui lòng giữ nguyên tên tác giả khi chia sẻ hoặc chỉnh sửa mã nguồn.

---

## Hỗ trợ
Nếu gặp lỗi hoặc cần bổ sung tính năng, vui lòng mở Issue trong GitHub repository.
