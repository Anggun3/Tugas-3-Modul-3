import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Program sederhana untuk mengingatkan pengguna apakah hari ini adalah ulang tahun teman.
 * <p>
 * Pengguna akan diminta memasukkan nama dan tanggal lahir teman,
 * kemudian program akan memeriksa apakah tanggal hari ini sama dengan tanggal lahir tersebut.
 * </p>
 *
 * <b>Teknik Refactoring yang digunakan:</b>
 * <ul>
 *     <li>Introduce Constant</li>
 *     <li>Extract Class</li>
 *     <li>Encapsulate Field</li>
 *     <li>Extract Method</li>
 * </ul>
 *
 * @author Anggun
 * @version 1.0
 */
public class BirthdayReminderAfter {

    /**
     * Konstanta untuk format tanggal agar konsisten di seluruh program.
     * Format yang digunakan adalah yyyy-MM-dd (contoh: 2005-10-26).
     */
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Method utama yang menjalankan program.
     * <p>
     * Method ini akan meminta input nama dan tanggal lahir dari pengguna,
     * membuat objek {@code Friend}, lalu memanggil method {@code checkBirthday()}
     * untuk mengecek apakah hari ini adalah ulang tahun teman tersebut.
     * </p>
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== PROGRAM PENGINGAT ULANG TAHUN ===");
        System.out.print("Masukkan nama teman: ");
        String name = input.nextLine();

        System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");
        String date = input.nextLine();

        // Membuat objek Friend untuk menyimpan data teman
        Friend friend = new Friend(name, date);

        // Memanggil method untuk mengecek apakah hari ini ulang tahunnya
        friend.checkBirthday();

        input.close();
    }
}

/**
 * Kelas {@code Friend} digunakan untuk menyimpan data teman berupa nama dan tanggal lahir.
 * <p>
 * Kelas ini juga berisi logika untuk mengecek apakah hari ini adalah ulang tahun teman tersebut.
 * </p>
 */
class Friend {
    /** Nama teman yang diinput pengguna */
    private String name;

    /** Tanggal lahir teman dalam format LocalDate */
    private LocalDate birthDate;

    /**
     * Konstruktor untuk menginisialisasi data teman.
     *
     * @param name nama teman
     * @param date tanggal lahir teman dalam format yyyy-MM-dd
     */
    public Friend(String name, String date) {
        this.name = name;
        this.birthDate = LocalDate.parse(date, BirthdayReminderAfter.DATE_FORMAT);
    }

    /**
     * Mengecek apakah hari ini adalah ulang tahun.
     * <p>
     * Method ini akan membandingkan bulan dan tanggal dari {@code birthDate}
     * dengan tanggal hari ini ({@code LocalDate.now()}).
     * Jika sama, maka program akan menampilkan pesan bahwa hari ini adalah ulang tahun.
     * </p>
     */
    public void checkBirthday() {
        LocalDate today = LocalDate.now();

        if (birthDate.getMonth() == today.getMonth() &&
                birthDate.getDayOfMonth() == today.getDayOfMonth()) {
            System.out.println("Hari ini ulang tahun " + name + "! ");
        } else {
            System.out.println("Bukan hari ulang tahun " + name + ".");
        }
    }
}