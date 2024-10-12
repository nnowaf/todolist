
# To-Do List Application

## Fitur
- **Registrasi Pengguna**: Pengguna dapat mendaftar dengan username, password, dan email.
- **Login Pengguna**: Pengguna dapat masuk ke aplikasi menggunakan username dan password.
- **Manajemen Checklist**: Pengguna dapat membuat, melihat, dan menghapus checklist.
- **Manajemen Item**: Pengguna dapat menambahkan, melihat, dan menghapus item dalam checklist.

## Teknologi yang Digunakan
- **Spring Boot**: Framework untuk membangun aplikasi backend.
- **PostgreSQL**: Database relasional yang digunakan untuk menyimpan data.
- **Spring Security**: Menangani otentikasi dan otorisasi pengguna.
- **JWT (JSON Web Token)**: Untuk mengamankan API.

## Struktur Database
Aplikasi ini menggunakan tiga tabel utama:

### 1. Tabel `users`
Tabel untuk menyimpan informasi pengguna.
```sql  
CREATE TABLE users (  
    id SERIAL PRIMARY KEY,  
    username VARCHAR(50) UNIQUE NOT NULL,  
    password VARCHAR(255) NOT NULL,  
    email VARCHAR(100) UNIQUE,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  
);  
```

### 2. Tabel `checklists`
Tabel untuk menyimpan daftar checklist yang dibuat oleh pengguna.
```sql  
CREATE TABLE checklists ( 
	id SERIAL PRIMARY KEY, 
	title VARCHAR(100) NOT NULL, 
	user_id INTEGER REFERENCES users(id) ON DELETE CASCADE, 
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP 
);  
```

### 3. Tabel `items`
Tabel untuk menyimpan item-item yang ada dalam setiap checklist.
```sql  
CREATE TABLE items (  
    id SERIAL PRIMARY KEY,  
    description VARCHAR(255) NOT NULL,  
    completed BOOLEAN DEFAULT FALSE,  
    checklist_id INTEGER REFERENCES checklists(id) ON DELETE CASCADE,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  
);
```


## Installasi

### 1. Tabel `git clone`
Tabel untuk menyimpan item-item yang ada dalam setiap checklist.
```sql  
git clone <repository-url>
cd <repository-directory>
```

### 2. Konfigurasi Database pom.xml
```
spring:  
  application:  
  name: @project.artifactId@  
  datasource:  
  url: jdbc:postgresql://${DATABASE_HOST:localhost}:${DATABASE_PORT:5432}/${DATABASE_NAME:usernamedatabase}  
    username: ${DATABASE_USER:username}  
    password: ${DATABASE_PASSWORD:password}  
    driver-class-name: org.postgresql.Driver
```

## Pengujian API dengan Postman

Saya telah menyediakan file **`Todolist.postman_collection.json`** yang berisi koleksi semua endpoint API yang telah dikembangkan dan bisa untuk dicoba.

### Cara Mengimpor Koleksi ke Postman

1. Buka aplikasi **Postman**.
2. Klik pada tab **"Collections"** di sidebar kiri.
3. Klik tombol **"Import"** yang terletak di bagian atas.
4. Pilih file **`Todolist.postman_collection.json`**.
