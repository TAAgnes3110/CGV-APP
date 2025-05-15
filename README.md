# Movie Recommendation System

Hệ thống Movie Recommendation bao gồm backend (Node.js, Firebase, SQL Server) và frontend (Android/Kotlin).

## Cấu trúc thư mục

```
backend/
  Movie_Recommendation/      # Backend chính, API và các service liên quan
  movie-api/                 # API Node.js cho phim, kết nối Firebase
  sqlserver_api/             # API Node.js kết nối FireBase
frontend/
  app/                       # Ứng dụng Android (Kotlin/Java)
```

## Backend

- **movie-api/**: Node.js REST API, sử dụng Firebase Admin SDK.
- **sqlserver_api/**: Node.js REST API, kết nối SQL Server, import/export dữ liệu phim.
- **Movie_Recommendation/**: Các service và API phụ trợ khác.

### Chạy backend

1. Cài đặt dependencies:
   ```sh
   cd backend/movie-api
   npm install
   cd ../sqlserver_api
   npm install
   ```
2. Thêm file cấu hình Firebase (`serviceAccountKey.json`, `.env`...) vào đúng vị trí.
3. Khởi động server:
   ```sh
   node server.js      # trong movie-api/
   node index.js       # trong sqlserver_api/ (hoặc file main tương ứng)
   ```

## Frontend

- **app/**: Ứng dụng Android, sử dụng Retrofit để gọi API backend.

### Chạy frontend

1. Mở thư mục `frontend` bằng Android Studio hoặc VS Code.
2. Sync Gradle và build project.
3. Chạy app trên thiết bị/emulator.

## Cấu hình

- Đảm bảo các file cấu hình (`.env`, `serviceAccountKey.json`, v.v.) đã được thêm vào đúng vị trí.
- Sửa `baseUrl` trong các file Retrofit nếu cần trỏ tới đúng địa chỉ backend.
