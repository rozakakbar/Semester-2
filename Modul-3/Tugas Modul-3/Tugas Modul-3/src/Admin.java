
import java.util.Scanner;

public class Admin extends App {
    static String username, password;
    static Scanner inputuser = new Scanner(System.in);



    public static void addstudent() {
        System.out.println("\n==== Tambah Mahasiswa ====");
        System.out.print("masukkan Nama:");
        String nama = inputuser.nextLine();
        String nim;

        System.out.print("masukkan NIM:");
        nim = inputuser.nextLine();

        System.out.print("masukkan Fakultas:");
        String fakultas = inputuser.nextLine();

        System.out.print("masukkan jurusan:");
        String jurusan = inputuser.nextLine();

        Main.arr_userStudent.add(new Main.UserStudent(nama, nim, fakultas, jurusan));

        System.out.println("berhasil daftar");
    }
    @Override
    public void inputBook() {
        super.inputBook();
    }
    static String adminusername = "naufal";


    @Override
    public void displayBooks() {
        super.displayBooks();
    }
    static String adminpassword = "naufal";
    static void displaystudent() {
        System.out.println("\n==== Daftar Mahasiswa ====");
        for (Main.UserStudent i : Main.arr_userStudent) {
            System.out.print("Nama : " + i.nama + "\n");
            System.out.print("NIM : " + i.nim + "\n");
            System.out.print("Fakultas : " + i.fakultas + "\n");
            System.out.print("Prodi : " + i.prodi + "\n");
            System.out.println("============================");

        }

    }
   public static void isAdmin() {
        System.out.println("\n==== Login ====");
        System.out.print("Masukkan Username: \n");
        username = inputuser.nextLine();

        System.out.print("Massukkan password: \n");
        password = inputuser.nextLine();

        if (username.equals(adminusername) && password.equals(adminpassword)) {
            System.out.println("login berhasil");
        } else {
            System.out.println("==== Pengguna tidak ditemukan ====");

        }

    }
}

