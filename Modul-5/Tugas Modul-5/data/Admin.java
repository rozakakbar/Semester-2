package data;
import com.main.LibrarySystem;
import java.util.Random;
import java.util.Scanner;
import exception.custom.IllegalAdminAccess;
import java.util.InputMismatchException;
import util.iMenu;

public class Admin extends User implements iMenu {

    //=================================== ATRIBUT =====================================
    static String adminusername = "admin";
    static String adminpassword = "admin";

    static String username, password;

    //Scanner yang dipakai khusus untuk switch case
    static Scanner inputpilihan = new Scanner(System.in);

    //Scanner yang dipakai untuk menerima berbagai input dari user
    static Scanner inputuser = new Scanner(System.in);
    static String NIM;


    //===================================== METHOD =====================================

    //Method menu yang override dari class iMenu.
    @Override
    public void menu() {
        try{

            System.out.println("\n==== Admin Menu ====");
            System.out.println("\n1. Tambah Mahasiswa\n2. Daftar Mahasiswa\n3. Tambah Buku\n4. Logout");
            System.out.print("Choose option (1-3): ");

            int pilihan = inputpilihan.nextInt();
            switch (pilihan) {
                case 1:
                    Admin.addstudent();
                    menu();
                    break;
                case 2:
                    Admin.displaystudent();
                    menu();
                    break;
                case 3:
                    inputBook();
                    menu();
                    break;
                case 4:
                    LibrarySystem.menu();
                    break;
                default:
                    System.out.print("Pilih 1-4");
                    menu();
            }
        }catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka antara 1-4.");
            inputpilihan.next(); // membersihkan input yang salah
            menu();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            menu();
        }
    }


    //Method untuk menambahkan  mahasiswa.
    public static void addstudent() {
        int loop;
        System.out.println("\n==== Tambah Mahasiswa ====");
        System.out.print("masukkan Nama:");
        String nama = inputuser.nextLine();

        do {
            System.out.print("masukkan NIM:");
            NIM = inputuser.nextLine();
            if (NIM.length() != 15) {
                System.out.println("\n> NIM harus 15 digit");
                loop = 0;
            } else {
                loop = 1;
            }
        } while (loop == 0);
        System.out.print("masukkan Fakultas:");
        String fakultas = inputuser.nextLine();

        System.out.print("masukkan jurusan:");
        String jurusan = inputuser.nextLine();

        Student.arr_userStudent.add(new Student.UserStudent(nama, NIM, fakultas, jurusan));

        System.out.println("==== berhasil didaftarkan ====");
    }

    //Method untuk menambahkan buku baru, dengan cara override dari class User.
    @Override
    public void inputBook() {
        super.inputBook();
    }

    //Method untuk menampilkan infomasi detail mahasiswa.
    public static void displaystudent() {
        System.out.println("\n==== Daftar Mahasiswa ====");
        for (Student.UserStudent i : Student.arr_userStudent) {
            System.out.print("Nama     : "+ i.nama +"\n" );
            System.out.print("NIM      : " + i.nim + "\n");
            System.out.print("Fakultas : " + i.fakultas + "\n");
            System.out.print("Prodi    : " + i.prodi + "\n");
            System.out.println("============================");

        }

    }

    //Method yang dipakai untuk login sebagai admin.
    public boolean isAdmin() throws IllegalAdminAccess{
        System.out.println("\n==== Login ====");
        System.out.print("Masukkan Username: \n");
        username = inputuser.nextLine();

        System.out.print("Massukkan password: \n");
        password = inputuser.nextLine();

        if (username.equals(adminusername) && password.equals(adminpassword)) {
            System.out.println("==== Login berhasil ====\n");
            menu();

        } else {
            throw new IllegalAdminAccess("==== Invalid Credentials ====");

        }
        return false;
    }

    //method untuk membuat angka random pada id buku.
     public String generateId () {
            Random random = new Random();

            StringBuilder idTengah = new StringBuilder();
            StringBuilder idAkhir = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                idTengah.append(random.nextInt(10));
                idAkhir.append(random.nextInt(10));

            }
            return ("UMM-" + idTengah + "-" + idAkhir);

        }



}

