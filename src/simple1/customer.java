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
        customer cust = new customer();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. View Products\r\n"
            		+ "2. Add to Cart\r\n"
            		+ "3. Remove from Cart\"\r\n"
            		+"4. Checkout\r\n"
            		+ "5. View Order History\r\n"
            		+ "6. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    admin.view();
                    break;
                case 2:
                    System.out.print("Enter Product ID to add to cart: ");
                    int addId = sc.nextInt();
                    admin prod = null;
                    for (admin a : arrl) {
                        if (a.pid == addId) prod = a;
                    }
                    if (prod != null) {
                        cust.cart.add(prod);
                        System.out.println(prod.name + " added to cart.");
                    } else System.out.println("Product not found.");
                    break;
                case 3:
                    System.out.print("Enter Product ID to remove from cart: ");
                    int remId = sc.nextInt();
                    cust.cart.removeIf(p -> p.pid == remId);
                    System.out.println("Product removed (if in cart).");
                    break;
                case 4:
                    if (cust.cart.isEmpty()) {
                        System.out.println("Cart is empty!");
                        break;
                    }
                    int total = 0;
                    System.out.println("--- Checkout ---");
                    for (admin a : cust.cart) {
                        System.out.println(a.name + " - " + a.price);
                        total += a.price;
                    }
                    System.out.println("Total = " + total);
                    System.out.println("Checkout successful! Thank you for shopping.");
                    cust.history.add(new ArrayList<>(cust.cart));
                    cust.cart.clear();
                    break;
                case 5:
                    System.out.println("--- Order History ---");
                    int orderNum = 1;
                    for (ArrayList<admin> order : cust.history) {
                        System.out.println("Order #" + orderNum++);
                        int orderTotal = 0;
                        for (admin a : order) {
                            System.out.println(a.name + " - " + a.price);
                            orderTotal += a.price;
                        }
                        System.out.println("Total: " + orderTotal);
                    }
                    if (cust.history.isEmpty()) System.out.println("No orders yet.");
                    break;
                case 6: return;
            }
        }
    }
}