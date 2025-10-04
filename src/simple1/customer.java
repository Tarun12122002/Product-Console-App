package simple1;
import java.util.*;
public class customer extends admin {
    
	customer()
	{
		super(12,"t",13,1);
	}
    private ArrayList<admin> cart = new ArrayList<>();
    private ArrayList<ArrayList<admin>> history = new ArrayList<>();

    public static void customerMenu() {
    	System.out.println(" Welcome to our E-Commerce");
        customer cust = new customer();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" Enter 1 to View Products\r\n"
            		+ " Enter 2 to Add to Cart\r\n"
            		+ " Enter 3 to Remove from Cart\r\n"
            		+" Enter 4 to Checkout\r\n"
            		+ " Enter 5 to View Order History\r\n"
            		+ " Enter 6 to return to the home page");
            System.out.print(" Enter your choice based on above list for your today requirements: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    admin.view();
                    break;
                case 2:
                	System.out.println(" Refer below product details and enter product's PID to purchase");
                	admin.view();
                    System.out.print(" Enter Product ID to add to cart: ");
                    int addId = sc.nextInt();
                    admin prod = null;
                    for (admin a : arrl) {
                        if (a.pid == addId) prod = a;
                    }
                    if (prod != null) {
                        cust.cart.add(prod);
                        System.out.println(prod.name + " added to cart.");
                        System.out.println(" Kindly enter 4 next to checkout and confirm your order!"+" If checkout not done then order will not be placed!");
                    } else System.out.println(" Product not found.");
                    break;
                case 3:
                    System.out.print(" Enter Product ID to remove from cart: ");
                    int remId = sc.nextInt();
                    cust.cart.removeIf(p -> p.pid == remId);
                    System.out.println(" Product removed.");
                    break;
                case 4:
                    if (cust.cart.isEmpty()) {
                        System.out.println(" Cart is empty!");
                        break;
                    }
                    int total = 0;
                    System.out.println("--- Checkout ---");
                    for (admin a : cust.cart) {
                        System.out.println(a.name + " - " + a.price);
                        total += a.price;
                    }
                    System.out.println(" Total = " + total);
                    System.out.println(" Order Placed! Thank you for shopping.");
                    cust.history.add(new ArrayList<>(cust.cart));
                    cust.cart.clear();
                    break;
                case 5:
                    System.out.println("--- Order History ---");
                    int orderNum = 1;
                    for (ArrayList<admin> order : cust.history) {
                        System.out.println(" Order #" + orderNum++);
                        int orderTotal = 0;
                        for (admin a : order) {
                            System.out.println(a.name + " - " + a.price);
                            orderTotal += a.price;
                        }
                        System.out.println(" Total: " + orderTotal);
                    }
                    if (cust.history.isEmpty()) System.out.println(" No orders yet.");
                    break;
                case 6: return;
            }
        }
    }
}
