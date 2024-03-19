import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\n\nMasukkan nama Anda:");
        String nama = input.nextLine();

        System.out.print("Masukkan jenis kelamin (L/P):");
        String jenisKelaminInput = input.nextLine();
        String jenisKelamin = jenisKelaminInput.equalsIgnoreCase("L") ? "laki-laki" : "perempuan";

        System.out.print("Masukkan tanggal lahir (YYYY-MM-DD):");
        String tanggalLahirStr = input.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirStr);

        LocalDate tanggalSekarang = LocalDate.now();
        Period selisih = Period.between(tanggalLahir, tanggalSekarang);
        int tahun = selisih.getYears();
        int bulan = selisih.getMonths();

        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("Umur: " + tahun + " tahun " + bulan + " bulan");
        input.close();
    }
}