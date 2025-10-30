#Implementasi Pola Navigasi & Passing Data (Jetpack Compose)
Proyek ini merupakan implementasi dari tugas **"Implementasi Pola Navigasi & Passing Data"** menggunakan **Jetpack Compose** di Android Studio.  
Aplikasi ini menerapkan pola **Bottom Navigation** dan mengirimkan data antar-screen menggunakan anotasi `@Serializable`.

##Tujuan
- Menerapkan salah satu pola navigasi lanjutan yaitu **Bottom Navigation**.  
- Mengirimkan data dari satu screen ke screen lainnya dengan cara yang benar menggunakan `@Serializable`.  
- Memahami struktur aplikasi multi-screen sederhana di Jetpack Compose.
  
#Teknologi yang Digunakan
- Kotlin  
- Jetpack Compose  
- Android Studio  
- Navigation Compose  
- Kotlinx Serialization  

#Struktur Folder (Sesuai Repository)
app/src/main/java/com/anindya/bottomnavigation/
├─ MainActivity.kt
├─ model/
│ └─ User.kt
├─ screens/
│ ├─ HomeScreen.kt
│ └─ DetailScreen.kt
├─ tabview/
│ └─ BottomBar.kt
└─ ui/theme/
├─ Color.kt
├─ Theme.kt
└─ Type.kt

#Pola Navigasi: Bottom Navigation
Aplikasi ini menggunakan **Bottom Navigation** sebagai pola navigasi utama untuk berpindah antar layar.  
Menu navigasi ditampilkan di bagian bawah aplikasi dan menampilkan indikator aktif sesuai screen yang sedang dibuka.
Bottom Navigation dipilih karena:
- Struktur implementasinya sederhana.  
- Cocok untuk aplikasi dengan 2–3 screen.  
- Mudah digunakan bersama Jetpack Navigation Compose.

#Mekanisme Pengiriman Data antar Screen
Aplikasi ini mengirim data dari **HomeScreen** ke **DetailScreen** dengan langkah-langkah berikut:
1. Pengguna menginput data (misalnya nama dan usia) di `HomeScreen`.  
2. Data tersebut dibungkus ke dalam objek `User` yang diberi anotasi `@Serializable`.  
3. Objek `User` dikonversi menjadi JSON menggunakan `Json.encodeToString()`.  
4. JSON dikirim ke `DetailScreen` melalui route:
5. Di `DetailScreen`, data JSON diubah kembali ke objek `User` dengan `Json.decodeFromString()`.  
6. Data ditampilkan di tampilan detail.

Dengan mekanisme ini, data dapat berpindah antar-screen tanpa kehilangan tipe dan struktur.
#Alur Aplikasi
1. HomeScreen (Screen A): pengguna mengisi nama dan usia.  
2. Menekan tombol "Kirim ke Halaman Detail" → aplikasi berpindah ke halaman detail.  
3. DetailScreen (Screen B): data pengguna ditampilkan.  
4. Bottom Navigation: menampilkan indikator screen aktif saat ini.

#Anggota Kelompok
| Nama | NIM |
| Anindya Putri Aisyah| |(23523136)|
| Nur Astrid Damayanti | (23523251) |

#Repository
**GitHub Repo:** [https://github.com/ysrednina0/BottomNavigation](https://github.com/ysrednina0/BottomNavigation)

**Kesimpulan:**
Aplikasi ini berhasil menerapkan pola navigasi **Bottom Navigation** dan mekanisme **passing data antar-screen** dengan `@Serializable`.  
Struktur folder rapi, tampilan jelas, serta dokumentasi sudah memenuhi seluruh ketentuan tugas.



