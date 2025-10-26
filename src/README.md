Program Pengingat Ulang Tahun

Deskripsi Program

Program ini berfungsi untuk mengingatkan pengguna apabila hari ini adalah ulang tahun temannya.
Pengguna akan memasukkan nama teman dan tanggal lahir dalam format yyyy-MM-dd, lalu program akan mengecek apakah tanggal hari ini sama dengan tanggal lahir tersebut.
Jika tanggal dan bulan sama, program akan menampilkan pesan bahwa hari ini adalah ulang tahun teman tersebut, dan jika tidak, akan muncul pesan bahwa hari ini bukan hari ulang tahunnya.

| **Langkah** | **Deskripsi Proses**                                                                                                                   | **Kode yang Terlibat**                                                                                | **Hasil / Tujuan**                                           |
|------| -------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------ |
| 1️   | Program dimulai dan menampilkan judul                                                                                                  | `System.out.println("=== PROGRAM PENGINGAT ULANG TAHUN ===");`                                        | Pengguna tahu program sudah siap digunakan                   |
| 2️   | Program meminta pengguna memasukkan **nama teman**                                                                                     | `System.out.print("Masukkan nama teman: ");`                                                          | Nama teman disimpan dalam variabel `name`                    |
| 3️   | Program meminta pengguna memasukkan **tanggal lahir** dalam format `yyyy-MM-dd`                                                        | `System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");`                                          | Tanggal disimpan dalam variabel `date`                       |
| 4️   | Program membuat **objek Friend** menggunakan data nama dan tanggal lahir yang diinput pengguna                                         | `Friend friend = new Friend(name, date);`                                                             | Data disimpan dalam objek `Friend`                           |
| 5️   | Di dalam konstruktor `Friend`, tanggal lahir dikonversi dari teks menjadi format tanggal (`LocalDate`) menggunakan `DateTimeFormatter` | `this.birthDate = LocalDate.parse(date, BirthdayReminderAfter.DATE_FORMAT);`                          | Format tanggal menjadi valid dan siap dibandingkan           |
| 6️   | Program memanggil method `checkBirthday()` untuk melakukan pengecekan                                                                  | `friend.checkBirthday();`                                                                             | Pengecekan apakah hari ini ulang tahunnya atau bukan dimulai |
| 7️   | Program mengambil tanggal hari ini dari sistem                                                                                         | `LocalDate today = LocalDate.now();`                                                                  | Menyimpan tanggal saat program dijalankan                    |
| 8️   | Program membandingkan **bulan dan tanggal lahir** dengan **bulan dan tanggal hari ini**                                                | `if (birthDate.getMonth() == today.getMonth() && birthDate.getDayOfMonth() == today.getDayOfMonth())` | Menentukan apakah hari ini ulang tahun atau bukan            |
| 9️   | Jika cocok → tampilkan pesan “Hari ini ulang tahun [nama]!”                                                                            | `System.out.println("Hari ini ulang tahun " + name + "! ");`                                          | Memberi notifikasi ulang tahun                               |
| 10   | Jika tidak cocok → tampilkan pesan “Bukan hari ulang tahun [nama].”                                                                    | `System.out.println("Bukan hari ulang tahun " + name + ".");`                                         | Memberi tahu bahwa bukan hari ulang tahunnya                 |
|      | Program selesai, scanner ditutup                                                                                                       | `input.close();`                                                                                      | Program berhenti dengan aman                                 |

Contoh Jalannya Program

| **Input dari Pengguna**                  | **Tanggal Sistem (otomatis)** | **Output Program**            |
| ---------------------------------------- | ----------------------------- | ----------------------------- |
| Nama: Rina<br>Tanggal lahir: 2005-10-26  | 2025-10-26                    | Hari ini ulang tahun Rina!    |
| Nama: Dimas<br>Tanggal lahir: 2004-07-14 | 2025-10-26                    | Bukan hari ulang tahun Dimas. |

