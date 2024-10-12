To-Do List Application

Fitur
Registrasi Pengguna: Pengguna dapat mendaftar dengan username, password, dan email.
Login Pengguna: Pengguna dapat masuk ke aplikasi menggunakan username dan password.
Manajemen Checklist: Pengguna dapat membuat, melihat, dan menghapus checklist.
Manajemen Item: Pengguna dapat menambahkan, melihat, dan menghapus item dalam checklist.
Teknologi yang Digunakan
Spring Boot: Framework untuk membangun aplikasi backend.
PostgreSQL: Database relasional yang digunakan untuk menyimpan data.
Spring Security: Menangani otentikasi dan otorisasi pengguna.
JWT (JSON Web Token): Untuk mengamankan API.
Struktur Database
Aplikasi ini menggunakan tiga tabel utama:

1. Tabel users
   Tabel untuk menyimpan informasi pengguna.

sql
Copy code
CREATE TABLE users (
id SERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(100) UNIQUE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
2. Tabel checklists
   Tabel untuk menyimpan daftar checklist yang dibuat oleh pengguna.

sql
Copy code
CREATE TABLE checklists (
id SERIAL PRIMARY KEY,
title VARCHAR(100) NOT NULL,
user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
3. Tabel items
   Tabel untuk menyimpan item-item yang ada dalam setiap checklist.

sql
Copy code
CREATE TABLE items (
id SERIAL PRIMARY KEY,
description VARCHAR(255) NOT NULL,
completed BOOLEAN DEFAULT FALSE,
checklist_id INTEGER REFERENCES checklists(id) ON DELETE CASCADE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
Instalasi
Clone Repository

bash
Copy code
git clone <repository-url>
cd <repository-directory>
Persiapkan Database PostgreSQL

Dummy Data Bisa di akses pada file sql berikut:
Eksekusi skrip SQL berikut untuk membuat tabel:
tabel USer
\i path/to/users.sql

Tabel Checklist
\i path/to/checklist.sql

Tabel Item
\i path/to/item.sql
Konfigurasi Aplikasi

Ubah application.properties untuk mengkonfigurasi koneksi database PostgreSQL:
properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
Jalankan Aplikasi

Copy code
mvn spring-boot:run
API Endpoints
1. Auth API
   POST /api/auth/register

Mendaftarkan pengguna baru.
Request Body:
{
"username": "your_username",
"password": "your_password",
"email": "your_email@example.com"
}
POST /api/auth/login

Mengautentikasi pengguna dan menghasilkan token JWT.
Request Body:
{
"username": "your_username",
"password": "your_password"
}
2. Checklist API
   POST /api/checklists

Membuat checklist baru.
Request Body:
{
"title": "Your Checklist Title",
"userId": 1  // ID pengguna yang membuat checklist
}

Mengambil semua checklist untuk pengguna tertentu.
GET /api/checklists/{userId}

Menghapus checklist berdasarkan ID checklist.
DELETE /api/checklists/{id}
3. Item API
   POST /api/items

Menambahkan item baru ke checklist.
Request Body:
{
"description": "Your Item Description",
"completed": false,
"checklistId": 1  // ID checklist
}

Mengambil semua item berdasarkan ID checklist.
GET /api/items/{checklistId}


Menghapus item berdasarkan ID item.
DELETE /api/items/{id}