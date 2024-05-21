package data;

import books.Book;
import com.main.LibrarySystem;
import exception.custom.IllegalAdminAccess;
import java.util.InputMismatchException;
import util.iMenu;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements iMenu{

    //===================================== ATRIBUT ====================================

    //Scanner yang dipakai khusus untuk switch case.
    Scanner inputpilihan = new Scanner(System.in);

    //Scanner yang dipakai untuk menerima berbagai input dari user.
    static  Scanner inputuser = new Scanner(System.in);

    //Arraylist yang dipakai untuk menyimpan list informasi mahasiswa.
    static ArrayList<UserStudent> arr_userStudent = new ArrayList<>();

    //====================================  METHOD  =====================================
    //Konstruktor untuk arraylist arr_userStudent.
    static class UserStudent{
        String nama,nim,fakultas,prodi;
        public UserStudent(String nama, String nim, String fakultas, String prodi){
            this.nama = nama;
            this.nim = nim;
            this.fakultas = fakultas;
            this.prodi = prodi;
        }
    }



    //Method menu yang override dari class iMenu
    @Override
    public void menu(){
        try {

        Student studentObject = new Student();
        Student.displayInfo();

        System.out.println("\n==== Student Menu ====");
        System.out.print("\n1. Buku Terpinjam\n2. Pinjam buku\n3. Kembalikan buku\n4. Logout");
        System.out.println("\n Choose option (1-3): ");

        int pilihan = inputpilihan.nextInt();
        switch (pilihan){
            case 1:
                Student.showBorrowedBooks();
                menu();
                break;
            case 2:
                studentObject.choiceBooks();
                menu();
                break;
            case 3:
                Student.showBorrowedBooks();
                Student.returnBooks();
                menu();
                break;
            case 4:
                Student.logout();
                break;
            default:
                System.out.print("Pilih 1-4");
                LibrarySystem.menu();
        }
    } catch (InputMismatchException e) {
        System.out.println("Input tidak valid. Harap masukkan angka antara 1-4.");
        inputpilihan.next(); // membersihkan input yang salah
        menu();
    } catch (Exception e) {
        System.out.println("Terjadi kesalahan: " + e.getMessage());
        menu();
    }

    }

    //Method untuk menampilkan informasi nama dan NIM mahasiswa di tampilan awal menu student.
    public static void displayInfo() {
        for (UserStudent i : arr_userStudent) {
            if (LibrarySystem.NIM.equals(i.nim)) {
                System.out.println("\n");
                System.out.print("> Nama: " + i.nama);
                System.out.println("\n> NIM : " + i.nim);
                break;
            }
        }
    }

    //Method untuk menampilkan daftar buku yang dipinjam mahasiswa.
    public static void showBorrowedBooks(){

        System.out.println("=======================================  Informasi Buku Yang Dipinjam  ==================================================");
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Durasi");
        System.out.println("\n=========================================================================================================================");

               for (Book a : Book.arr_borrowedBook) {
                   for (Book i : Book.arr_bookList) {
                       if (i.getBookId().equals(a.getBookId())) {
                           System.out.printf("|| %-23s || %-25s || %-25s || %-20s || %-5s  ||\n", i.getBookId(), i.getTitle(), i.getAuthor(), i.getCategory(), a.getDuration());
                       }

                   }

               }

        System.out.print("=========================================================================================================================");
    }

    //Method yang berfungsi untuk memilih buku dengan override method dari class User.
    @Override
    public void choiceBooks(){
        super.choiceBooks();
    }

    //Method untuk kembali ke menu tampilan awal yaitu menu library system.
    public static void logout(){
        LibrarySystem.menu();
    }

    public static void returnBooks(){

        boolean validasiReturnBooks = false;

        System.out.println("\n● Inputkan ID buku yang ingin dikembalikan.");
        System.out.print("> ID : ");

        idBukuYangDipinjam = inputuser.nextLine();

        //For dengan variabel i yang membaca ukuran arraylist arr_borrowedBook.
        for (int i = 0; i < Book.arr_borrowedBook.size(); i++ ) {

            //If untuk membandingkan variabel idBukuYangDipinjam dengan id yang ada di arr_borrowedBook.
            if (Book.arr_borrowedBook.get(i).getBookId().equals(idBukuYangDipinjam)) {
                for (Book book : Book.arr_bookList) {
                    if (book.getBookId().equals(idBukuYangDipinjam)) {

                        int returnBook = book.getStock();   //variabel returnBook yang berfungsi untuk mendapatkan info jumlah stok buku dari variabel book.
                        returnBook++;                       //lalu setelah itu menambahkan nilai +1 pada variabel returnBook.
                        book.setStock(returnBook);          //Lalu, menambahkan nilai returnBook kedalam stok buku yang ada di arraylist arr_bookList.

                        Book.arr_borrowedBook.remove(i);    //Menghapus buku dari arraylist arr_borrowedBook.

                        validasiReturnBooks = true;
                    }
                }
            }
        }
        if(validasiReturnBooks){

            System.out.print("Pengembalian Berhasil");
        }else{

            System.out.print(">>> Buku tidak ditemukan. <<<");
        }
    }

    //Method untuk mengecek jumlah angka NIM dari method inputNIM() yang ada di class Library System.
    public boolean validasiLogin(){
            LibrarySystem.inputNIM();
            if(LibrarySystem.NIM.length() == 15) {
                for(UserStudent i : arr_userStudent) {
                    if (i.nim.equals(LibrarySystem.NIM)) {
                        return true;
                    }
                }
            } else{
              System.out.println(">>> NIM harus 15 digit ! <<<\n");
              validasiLogin();
            }

    return false;
    }

    //Method untuk mengakses menu pada class student
    public void isStudents() throws  IllegalAdminAccess{
        if(validasiLogin()){
            System.out.println("==== Login berhasil ====\n");
            menu();

        }else{
            throw new IllegalAdminAccess(">>> NIM tidak terdaftar <<<");
        }
    }
}

