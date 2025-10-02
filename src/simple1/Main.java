package simple1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to E-Commerce Console");
            System.out.println("---------------------------------");
            System.out.println("Choose User:");
            System.out.print("Enter choice: ");
            int user = sc.nextInt();
            switch (user) {
                case 1: admin.adminMenu(); break;
                case 2: customer.customerMenu(); break;
                case 3: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid Choice!");
            }
        }
    }
}