import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BirthdayReminderAfter {
    // (1) Introduce Constant → agar format tanggal tetap
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== PROGRAM PENGINGAT ULANG TAHUN ===");
        System.out.print("Masukkan nama teman: ");
        String name = input.nextLine();

        System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");
        String date = input.nextLine();

        // (2) Extract Class → buat class Friend untuk menyimpan data teman
        Friend friend = new Friend(name, date);

        // (3) Extract Method → logika pengecekan ulang tahun dipisah ke method checkBirthday()
        friend.checkBirthday();

        input.close();
    }
}

// (4) Class Friend untuk menampung data dan logika
class Friend {
    // (5) Encapsulate Field → ubah field jadi private agar aman
    private String name;
    private LocalDate birthDate;

    // Constructor untuk mengisi data teman
    public Friend(String name, String date) {
        this.name = name;
        this.birthDate = LocalDate.parse(date, BirthdayReminderAfter.DATE_FORMAT);
    }

    // (6) Extract Method → method untuk mengecek ulang tahun
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
