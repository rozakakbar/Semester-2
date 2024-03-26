import java.util.ArrayList;
import java.util.Scanner;

public class Student extends App{

    private String name;
    private String faculty;
    private String nim;
    private String programStudi;

    static  Scanner inputuser = new Scanner(System.in);
    static  String idBukuYangDipinjam;

    static ArrayList<ListPinjamanBuku>arr_listPinjamanBuku = new ArrayList<>();

    static class ListPinjamanBuku {
        String id;


        public ListPinjamanBuku(String id) {
            this.id = id;

        }
    }
    public void displayInfo(){
        System.out.print(" "+name);
        System.out.print(" "+nim);
        System.out.print(" "+faculty);
        System.out.print(" "+programStudi);
    }

    public static void showBorrowedBooks(){

        System.out.println("=======================================  Informasi Buku Yang Dipinjam  ==================================================");
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "stok");
        System.out.println("\n=========================================================================================================================");

               for (ListPinjamanBuku a : arr_listPinjamanBuku) {
                   for (Main.BookList i : Main.arr_bookList) {
                       if (i.idbuku.equals(a.id)) {
                           System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku,i.stokbuku);
                       }

                   }

               }

        System.out.print("=========================================================================================================================");
    }

    @Override
    public void displayBooks(){
        super.displayBooks();
    }
    public static void logout(){
        Main.menu();
    }

    public static void returnBooks(){
        System.out.println("\n● Inputkan ID buku yang ingin dikembalikan.");
        System.out.print("> ID : ");
        idBukuYangDipinjam = inputuser.nextLine();
        for (int i = 0; i < arr_listPinjamanBuku.size(); i++ ) {
            if (arr_listPinjamanBuku.get(i).id.equals(idBukuYangDipinjam)) {
                for (Main.BookList a : Main.arr_bookList) {
                    if (a.idbuku.equals(idBukuYangDipinjam)) {
                        a.stokbuku++;
                        arr_listPinjamanBuku.remove(i);
                    }
                    }
                }
            }
        System.out.print("Pengembalian Berhasil");
    }

    public static void borrowedBooks(){

        boolean bool_validasi_borrowedBooks  = false;

            System.out.println("\n>> Input ID buku yang ingin dipinjam");
            System.out.print(">  ID: ");
            idBukuYangDipinjam = inputuser.nextLine();

            for (Main.BookList i : Main.arr_bookList) {
                if (i.idbuku.equals(idBukuYangDipinjam)) {
                    if (i.stokbuku > 0) {
                        i.stokbuku--;
                        arr_listPinjamanBuku.add(new ListPinjamanBuku(idBukuYangDipinjam));
                        bool_validasi_borrowedBooks = true;
                    } else {
                        bool_validasi_borrowedBooks = false;
                    }
                }
            }
            if (bool_validasi_borrowedBooks) {
                System.out.print("Buku berhasil dipinjam");
            } else {
                System.out.print("Stok buku habis");
            }

    }
    public static void  loginstudent(){
            Main.inputNIM();
            for(Main.UserStudent i : Main.arr_userStudent){
                if(i.nim.equals(Main.NIM)){
                    break;
                }
            }
        System.out.println("==== Login berhasil ====\n");
    }



}
