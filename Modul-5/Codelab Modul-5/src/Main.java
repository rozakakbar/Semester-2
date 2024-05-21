import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> daftarNama = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Masukkan Nama-Nama Mahasiswa (ketik 'selesai' untuk berhenti)");

        int j = 1;
        while (true) {
            try {
                System.out.print("Masukkan Nama ke-" + j + " : ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("selesai")) {
                    break;
                } else if (input.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                } else {
                    daftarNama.add(input);
                    j++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nDaftar nama mahasiswa:");
        for (int i = 0; i < daftarNama.size(); i++) {
            System.out.println("Nama ke-" + (i+1) + ": " + daftarNama.get(i));
        }
    }
}