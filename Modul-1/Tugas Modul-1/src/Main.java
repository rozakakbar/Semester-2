import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("==== Library System ====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    Scanner baru = new Scanner(System.in);
                    System.out.print("Enter your NIM : ");
                    String nim = baru.nextLine();

                    if (nim.length() == 15) {
                        System.out.println("Successful Login as Student");
                    } else {
                        System.out.println("User not found!!");
                    }

                 
                    break;

                case 2:
                    Scanner admin = new Scanner(System.in);

                    System.out.print("Enter your username (admin) : ");
                    String user = admin.next();
                    System.out.print("Enter your password (admin) : ");
                    String pass = admin.next();

                    if (user.equals("admin") && pass.equals("admin")) {
                        System.out.println("Successful Login as Admin");
                    } else {
                        System.out.println("User admin not found!!");
                    }

                    
                    break;

                case 3:
                    System.out.println("bai");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Input not valid!!");
                    break;
            }
        }
    }
}