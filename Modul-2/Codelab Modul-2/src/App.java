import java.util.Scanner;
class Mahasiswa {
    static void tampilUniversitas() {
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("3. EXIT");
        System.out.print("Pilihan Anda (1-3): ");
    }
    void tampilDataMahasiswa() {
        System.out.println("masukan nama mahasiswa");
        System.out.println("masukan nim mahasiswa");
    }
}
public class App {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        int menu;
        String[] jumlahnim = new String[100];
        String[] namaMahasiswa = new String[100];
        String[] jurusanMahasiswa = new String[100];
        int jumlahMahasiswa = 0;

        do {
            System.out.println("menu :");
            Mahasiswa.tampilUniversitas();;
            menu = objInput.nextInt();
            objInput.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nama mahasiswa : ");
                    namaMahasiswa[jumlahMahasiswa] = objInput.nextLine();
                    System.out.print("Masukkan nim mahasiswa : ");
                    jumlahnim[jumlahMahasiswa] = objInput.nextLine();
                    int len = jumlahnim[jumlahMahasiswa].length();
                    if (len == 15) {
                        System.out.print("Masukkan jurusan mahasiswa : ");
                        jurusanMahasiswa[jumlahMahasiswa] = objInput.nextLine();
                        System.out.println("Data mahasiswa berhasil ditambahkan.");
                        jumlahMahasiswa++;
                    } else {
                        System.out.println("Nim harus 15 digit !!!");
                    }
                    break;

                case 2:
                    System.out.println("Data Mahasiswa : ");
                    System.out.println("Universitas-Muhammadiyah-Malang");
                    System.out.println("No  |  Nama  |  NIM  | Jurusan");
                    for (int i = 0; i < jumlahMahasiswa; i++) {
                        System.out.println((i+1)+"    " + namaMahasiswa[i] + "    " + jumlahnim[i] + "    " + jurusanMahasiswa[i]);
                    }
                    break;

                case 3:
                    System.out.println("adios");
                    break;
            }

        } while (menu != 3);

    }
}