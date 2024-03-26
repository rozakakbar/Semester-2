import java.util.Scanner;

public class App {
    public void displayBooks() {
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-17s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Stok");
        System.out.println("\n=========================================================================================================================");

        for (Main.BookList i : Main.arr_bookList) {
            System.out.printf("|| %-25s || %-25s || %-25s || %-18s || %3s  ||\n", i.idbuku, i.judulbuku, i.penulisbuku, i.kategoriBuku, i.stokbuku);
        }

        System.out.print("=====================================================================================================================");

    }

    public void inputBook() {
        Admin adminObj = new Admin();
        Scanner inputuser = new Scanner(System.in);


        System.out.println("\n==== Tambah Buku ====");
        System.out.print("Masukkan ID buku: ");
        String idbuku =  inputuser.nextLine();

        System.out.print("Masukkan judul Buku: ");
        String judulbuku = inputuser.nextLine();

        System.out.print("Masukkan Nama Penulis: ");
        String penulisbuku = inputuser.nextLine();

        System.out.print("Masukkan Kategori Buku: ");
        String  kategoribuku = inputuser.nextLine();


        System.out.print("Masukkan Jumlah Stok Buku: ");
        int stokbuku = inputuser.nextInt();


        Main.arr_bookList.add(new Main.BookList(idbuku, judulbuku, penulisbuku, kategoribuku, stokbuku));
        System.out.println("==== Buku berhasil ditambahkan ====");
    }
}