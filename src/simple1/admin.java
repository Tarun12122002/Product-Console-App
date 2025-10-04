package simple1;
import java.util.*;
public class admin {
	
	int pid;
	String name;
	int price;
	int stock;
	protected static ArrayList<admin> arrl=new ArrayList<admin>();
	admin(int pid, String name, int price, int stock)
	{
		this.pid=pid;
		this.name=name;
		this.price=price;
		this.stock=stock;
	}
	@Override
	public String toString() {
		return "PID: "+pid+" | "+"Name: "+name+" | "+"Price: "+price+" | "+"Stock: "+stock;
	}
	public static void add()
	{
		Scanner in=new Scanner(System.in);
		
		System.out.println(" Enter number of products you want to add");
		int n=in.nextInt();
		for(int i=0; i<n;i++)
		{
			System.out.println(" Enter PID:");
			int p=in.nextInt();
			in.nextLine();
			String na = "";
			while (true) {
			    try {
			        System.out.print(" Enter Name: ");
			        na = in.nextLine();
			        if (na == null || na.trim().isEmpty()) {
			            throw new IllegalArgumentException("Name cannot be empty");
			        }
			        if (!na.matches("[A-Za-z ]+")) {
			            throw new IllegalArgumentException("Name must contain only letters and spaces");
			        }
			        break;
			    } catch (IllegalArgumentException e) {
			        System.out.println("Error: " + e.getMessage());
			        System.out.println("Please try again.");
			    }
			}
			System.out.println(" Enter Price:");
			int pr=in.nextInt();
			System.out.println(" Enter stock:");
			int s=in.nextInt();
			admin pro=new admin(p,na,pr,s);
			arrl.add(pro);
		}
		System.out.println(" Product details added successfully! ");
		
	}
	public static void view()
	{
		for(admin pro:arrl)
		{
			System.out.println(pro+" ");
		}
	}
	public static void update()
	{
		if (arrl.isEmpty())
		{
			System.out.println("Currently products unavailable!");
			return;
		}
		Scanner in2=new Scanner(System.in);
		for(int i=0; i<arrl.size();i++)
		{
			System.out.println((i+1)+":"+" "+arrl.get(i));
		}
		if(arrl.size()==1)
		{
			System.out.println(" Currently only 1 product available here");
		}
		else {
			System.out.println(" Currently 1 to "+ arrl.size()+" Products available here");
		}
		System.out.println(" Choose product based on number listed below to update it's details...");
		System.out.println(" Your Choice:");
		int idx=in2.nextInt()-1;
		if(idx<0||idx>=arrl.size())
		{
			System.out.println(" Invalid index");
			return;
		}
		System.out.println("What do you want to update?");
	    System.out.println(" Enter 1 to update PID\r\n"
        		+ " Enter 2 to update product name\r\n"
        		+ " Enter 3 to update the product's price\r\n"
        		+" Enter 4 to update number of stocks available for that product");
	    System.out.println(" Enter your choice:");
	    int field = in2.nextInt();
	    in2.nextLine(); 
	    admin product = arrl.get(idx);
	    switch (field) {
	        case 1:
	            System.out.print(" Enter new PID: ");
	            product.pid = in2.nextInt();
	            break;
	        case 2:
	            System.out.print(" Enter new Name: ");
	            product.name = in2.nextLine();
	            break;
	        case 3:
	            System.out.print(" Enter new Price: ");
	            product.price = in2.nextInt();
	            break;
	        case 4:
	            System.out.print(" Enter new Stock: ");
	            product.stock = in2.nextInt();
	            break;
	        default:
	            System.out.println(" Invalid choice!");
	            return;
	    }
	    System.out.println(" Product details updated successfully!");
	
	}
	public static void delete()
	{
		if (arrl.isEmpty())
		{
			System.out.println(" Currently products unavailable!");
			return;
		}
		if(arrl.size()==1) {
			System.out.println(" Currently only 1 product available. Store cannot be empty!");
			return;
		}
		System.out.println(" There are "+arrl.size()+" Products");
		for(int i=0;i<arrl.size();i++)
		{
			System.out.println(" Product: "+i+" "+ arrl.get(i));
		}
		
		System.out.println(" Which product you need to remove ?");
		System.out.println(" Enter product number based on below values ");
		for(int i=0;i<arrl.size();i++)
		{
			System.out.println(" "+ i + " for "+" Product Number "+(i+1));
		}
		System.out.println(" Enter your Choice:");
		Scanner d=new Scanner(System.in);
		int uin=d.nextInt();
		arrl.remove(uin);
		System.out.println(" Product removed successfully! ");
		System.out.println(" Currently available product details: " );
		System.out.println(" "+arrl);
		System.out.println(" Add any product in future if needed ");
		
	}
	public static void adminMenu() 
	{
		System.out.println(" Hi user you are currently in Admin ");
		System.out.println(" Choose any one operation you need to perform and enter the value similar to that! ");
		while(true)
		{
			System.out.println(" Enter 1 to Add the Products\r\n"
            		+ " Enter 2 to View the Products\r\n"
            		+ " Enter 3 to Update the Product details\r\n"
            		+" Enter 4 to remove the product details\r\n"
            		+ " Enter 5 to return to home page");
			System.out.println(" Enter your choice:");
			Scanner in1=new Scanner(System.in);
			int no=in1.nextInt();
			switch(no)
			{
			case 1:
				add();
				break;
			case 2:
				view();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:	
				return;
			}
			
				

		}
		
		
	}


}
