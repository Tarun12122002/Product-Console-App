package simple1;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to E-Commerce Console");
            System.out.println("---------------------------------");
            System.out.println(" Hi user you are curently in home page!");
            System.out.println(" You can choose any 1 from the below ");
            System.out.print(" Enter 1 if you are an admin\r\n"
            		+ " Enter 2 if you want to purchase any products from our E-Commerce\r\n"
            		+ " Enter 3 to exit this app\r\n"
            		);
            System.out.print(" Enter your choice: ");
            int user = sc.nextInt();
            switch (user) {
                case 1: admin.adminMenu(); break;
                case 2: customer.customerMenu(); break;
                case 3: System.out.println(" Exiting..."); return;
                default: System.out.println(" Invalid Choice!");
            }
        }
    }
}
